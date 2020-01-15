package com.jfatty.zcloud.auth.api;

import com.jfatty.zcloud.auth.entity.AuthSmsConfig;
import com.jfatty.zcloud.auth.entity.AuthSmsLog;
import com.jfatty.zcloud.auth.service.AuthSmsConfigService;
import com.jfatty.zcloud.auth.service.AuthSmsLogService;
import com.jfatty.zcloud.auth.service.SmsService;
import com.jfatty.zcloud.auth.utils.PhoneNumUtil;
import com.jfatty.zcloud.base.utils.RETResultUtils;
import com.jfatty.zcloud.base.utils.StringUtils;
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

    @Resource(name = "aliyunSmsService")
    private SmsService aliyunSmsService ;

    @Resource(name = "tencentSmsService")
    private SmsService tencentSmsService ;

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
        return sendSms(phone,random,appId);
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
            if("aliyun".equalsIgnoreCase(authSmsConfig.getServiceName())){
                aliyunSmsService.sendSms(authSmsConfig,phone,code);
            }else if ("tencent".equalsIgnoreCase(authSmsConfig.getServiceName())){
                tencentSmsService.sendSms(authSmsConfig,phone,code);
            }else {
                log.error("没有配置对应短信验证码发送运营商");
                return RETResultUtils.faild("哎呀!网络走丢了!");
            }
            //设置有效时间为5分钟
            redisTemplate.opsForValue().set(phone,code,300,TimeUnit.SECONDS);
            BeanUtils.copyProperties(authSmsConfig,authSmsLog);
            authSmsLog.setSmsContent(code);
            authSmsLog.setSmsPhone(phone);
            authSmsLog.setStatus(0);
            authSmsLogService.save(authSmsLog,null);
            return new RETResultUtils("验证码发送成功,请注意查收") ;
        } catch (Exception e) {
            authSmsLog.setStatus(-1);
            authSmsLog.setErrMsg(e.getMessage());
        }
        System.out.println(appId);
        System.out.println(random);
        System.out.println(phone);
        try {
            authSmsLogService.save(authSmsLog,null);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("系统短信息发送日志记录 保存出现异常[{}]",e.getMessage());
        }
        return RETResultUtils.faild("哎呀!网络走丢了!");
    }
}
