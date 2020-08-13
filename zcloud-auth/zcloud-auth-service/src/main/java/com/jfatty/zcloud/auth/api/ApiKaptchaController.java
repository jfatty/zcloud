package com.jfatty.zcloud.auth.api;

import com.jfatty.zcloud.auth.entity.AuthSmsConfig;
import com.jfatty.zcloud.auth.entity.AuthSmsLog;
import com.jfatty.zcloud.auth.entity.UserPasswd;
import com.jfatty.zcloud.auth.service.AuthSmsConfigService;
import com.jfatty.zcloud.auth.service.AuthSmsLogService;
import com.jfatty.zcloud.auth.service.SmsService;
import com.jfatty.zcloud.auth.service.UserPasswdService;
import com.jfatty.zcloud.auth.utils.PhoneNumUtil;
import com.jfatty.zcloud.auth.utils.ShiroKit;
import com.jfatty.zcloud.base.utils.RETResultUtils;
import com.jfatty.zcloud.base.utils.StringUtils;
import com.jfatty.zcloud.base.utils.UUIDGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 描述
 *
 * @author jfatty on 2019/12/19
 * @email jfatty@163.com
 */
@Api(tags = "001*****短息验证码API" ,value = "短息验证码")
@Slf4j
@RestController
public class ApiKaptchaController {



    @Autowired
    private RedisTemplate redisTemplate ;

    @Autowired
    private StringRedisTemplate stringRedisTemplate ;

    @Autowired
    private AuthSmsConfigService authSmsConfigService ;

    @Autowired
    private AuthSmsLogService authSmsLogService ;

    @Autowired
    private UserPasswdService userPasswdService ;

    @Resource(name = "aliyunSmsService")
    private SmsService aliyunSmsService ;

    @Resource(name = "tencentSmsService")
    private SmsService tencentSmsService ;


    /**
     *  通过手机号检查用户账号信息
     * @param phone 用户手机号
     * @param appId 每个应用都对应有appId
     */
    private void checkUserAccountInfo(String phone, String appId) {
        String msg = PhoneNumUtil.isPhone(phone) ;
        if( !StringUtils.isNotEmptyAndBlank(msg)) { //合法手机号前提条件下
            UserPasswd  userPasswd = userPasswdService.getUserByPhone(phone);
            if (userPasswd == null) {
                userPasswd = new UserPasswd();
                userPasswd.setId(UUIDGenerator.uuid());
                userPasswd.setPhone(phone);
                //生成账号
                String account = UUIDGenerator.genNum(phone) ;
                //密码的盐值
                String salt = ShiroKit.getRandomSalt();
                userPasswd.setSalt(salt);
                userPasswd.setAccount(account);
                userPasswd.setCreateTime(LocalDateTime.now());
                userPasswd.setPassword(ShiroKit.md5("12345678",userPasswd.getCredentialsSalt()));
                if ( userPasswdService.saveUser(userPasswd) ) {
                    log.error("===>通过手机号检查用户账号信息 保存用户信息[{}]到数据库 当前应用appId为[{}]",userPasswd,appId);
                }
            }
        }
    }

    @ApiOperation(value="001****向用户手机号发送验证码(2020年01月03日本接口正式关闭)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号",dataType = "String",defaultValue = "13177261541"),
            @ApiImplicitParam(name = "random", value = "时间戳/随机字符串",dataType = "String",defaultValue = "122151881"),
            @ApiImplicitParam(name = "appId", value = "每个应用都对应有appId支付宝、微信、第三方APP",dataType = "String",defaultValue = "wx4712402349f957a4")
    })
    @RequestMapping(value = {"/api/kaptcha"} ,method = RequestMethod.GET)
    public RETResultUtils<String> kaptcha(@RequestParam(value = "phone" , defaultValue = "1321541582") String phone ,//
                                          @RequestParam(value = "random" , defaultValue = "122151881" ) String random,//
                                          @RequestParam(value = "appId" , defaultValue = "wx4712402349f957a4" ) String appId,//
                                          HttpServletRequest request ){
        //验证系统中是否对应手机号账号信息
        checkUserAccountInfo(phone,appId);
        return sendSms(phone,random,appId);
    }




    @ApiOperation(value="002****智慧医疗****向用户手机号发送验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号",dataType = "String",defaultValue = "13177261541"),
            @ApiImplicitParam(name = "random", value = "时间戳/随机字符串",dataType = "String",defaultValue = "122151881"),
            @ApiImplicitParam(name = "appId", value = "每个应用都对应有appId支付宝、微信、第三方APP",dataType = "String",defaultValue = "wx4712402349f957a4")
    })
    @RequestMapping(value = {"/api/hospital/kaptcha"} ,method = RequestMethod.GET)
    public RETResultUtils<String> hospitalKaptcha(@RequestParam(value = "phone" , defaultValue = "1321541582") String phone ,//
                                          @RequestParam(value = "random" , defaultValue = "122151881" ) String random,//
                                          @RequestParam(value = "appId" , defaultValue = "wx4712402349f957a4" ) String appId,//
                                          HttpServletRequest request ){
        //验证系统中是否对应手机号账号信息
        checkUserAccountInfo(phone,appId);
        return sendSms(phone,random,appId);
    }


    @ApiOperation(value="003****电子健康卡****向用户手机号发送验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号",dataType = "String",defaultValue = "13177261541"),
            @ApiImplicitParam(name = "random", value = "时间戳/随机字符串",dataType = "String",defaultValue = "122151881"),
            @ApiImplicitParam(name = "appId", value = "每个应用都对应有appId支付宝、微信、第三方APP",dataType = "String",defaultValue = "wx4712402349f957a4"),
            @ApiImplicitParam(name = "hospitalId", value = "医院ID",dataType = "String",defaultValue = "30646")
    })
    @RequestMapping(value = {"/api/health/kaptcha"} ,method = RequestMethod.GET)
    public RETResultUtils<String> healthKaptcha(@RequestParam(value = "phone" , defaultValue = "1321541582") String phone ,//
                                          @RequestParam(value = "random" , defaultValue = "122151881" ) String random,//
                                          @RequestParam(value = "appId" , defaultValue = "wx4712402349f957a4" ) String appId, //
                                          @RequestParam(value = "hospitalId" , defaultValue = "30646" ) String hospitalId,//
                                          HttpServletRequest request ){
        //验证系统中是否对应手机号账号信息
        checkUserAccountInfo(phone,appId);
        return sendSms(phone,random,appId);
    }

    @ApiOperation(value="004****微信点餐****向用户手机号发送验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号",dataType = "String",defaultValue = "13177261541"),
            @ApiImplicitParam(name = "random", value = "时间戳/随机字符串",dataType = "String",defaultValue = "122151881"),
            @ApiImplicitParam(name = "appId", value = "每个应用都对应有appId支付宝、微信、第三方APP",dataType = "String",defaultValue = "wx4712402349f957a4"),
            @ApiImplicitParam(name = "opt", value = "操作编码 登录LOGIN 注册REG 忘记密码FORGET",dataType = "String",defaultValue = "LOGIN")
    })
    @RequestMapping(value = {"/api/sell/kaptcha"} ,method = RequestMethod.GET)
    public RETResultUtils<String> sellKaptcha(@RequestParam(value = "phone" , defaultValue = "1321541582") String phone ,//
                                                @RequestParam(value = "random" , defaultValue = "122151881" ) String random,//
                                                @RequestParam(value = "appId" , defaultValue = "wx4712402349f957a4" ) String appId, //
                                                @RequestParam(value = "opt" , defaultValue = "LOGIN" ) String opt,//
                                                HttpServletRequest request ){
        String msg = PhoneNumUtil.isPhone(phone) ;
        if(StringUtils.isNotEmptyAndBlank(msg))
            return RETResultUtils._509(msg) ;
        if(StringUtils.isEmptyOrBlank(opt))
            return RETResultUtils._509("操作编码不能为空") ;
        if("LOGIN".equals(opt)){
            return sendSms(phone,random,appId);
        } else if ("REG".equals(opt)) {
            UserPasswd  userPasswd = userPasswdService.getUserByPhone(phone);
            if (userPasswd != null) {
                return RETResultUtils._506(phone+"已被注册!");
            }
            return sendSms(phone,random,appId);
        }else { //忘记密码
            UserPasswd  userPasswd = userPasswdService.getUserByPhone(phone);
            if (userPasswd == null) {
                return RETResultUtils._506(phone+"尚未注册!");
            }
            return sendSms(phone,random,appId);
        }
    }

    protected RETResultUtils<String> sendSms(String phone,String random,String appId){
        String msg = PhoneNumUtil.isPhone(phone) ;
        if(StringUtils.isNotEmptyAndBlank(msg))
            return RETResultUtils._509(msg) ;
        //生成验证码
        String code = String.valueOf(new Random().nextInt(899999) + 100000);//生成短信验证码
        AuthSmsLog authSmsLog = new AuthSmsLog();
        try {
            AuthSmsConfig authSmsConfig = authSmsConfigService.getByAppId(appId);
            if ( authSmsConfig == null ) {
                return RETResultUtils.faild("用户未开通短信验证码");
            }
            if("aliyun".equalsIgnoreCase(authSmsConfig.getServiceName())){
                aliyunSmsService.sendSms(authSmsConfig,phone,code);
            }else if ("tencent".equalsIgnoreCase(authSmsConfig.getServiceName())){
                tencentSmsService.sendSms(authSmsConfig,phone,code);
            }else {
                log.error("没有配置对应短信验证码发送运营商");
                return RETResultUtils.faild("哎呀!网络走丢了!");
            }
            //设置有效时间为5分钟 timeout
            log.error("========>存入redis之前");
            redisTemplate.opsForValue().set(phone,code,authSmsConfig.getExpireTime(),TimeUnit.SECONDS);
            log.error("========>存入redis之后");
            BeanUtils.copyProperties(authSmsConfig,authSmsLog);
            authSmsLog.setSmsContent(code);
            authSmsLog.setSmsPhone(phone);
            authSmsLog.setStatus(0);
            authSmsLogService.save(authSmsLog,null);
            return new RETResultUtils("验证码发送成功,请注意查收") ;
        } catch (Exception e) {
            authSmsLog.setStatus(-1);
            authSmsLog.setErrMsg(e.getMessage());
            log.error("========>存入redis之后 捕获异常信息[{}]",e.getMessage());
        }
        log.error(" 短信发送 appId [{}] 发送手机号 [{}] 验证码 [{}]" , appId,phone,code);
        try {
            authSmsLogService.save(authSmsLog,null);
        } catch (Exception e) {
            log.error("系统短信息发送日志记录 保存出现异常[{}]",e.getMessage());
        }
        return RETResultUtils.faild("哎呀!网络走丢了!");
    }
}
