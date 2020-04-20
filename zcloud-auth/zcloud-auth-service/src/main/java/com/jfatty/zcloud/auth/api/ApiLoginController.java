package com.jfatty.zcloud.auth.api;

import com.jfatty.zcloud.auth.req.LoginVoReq;
import com.jfatty.zcloud.auth.res.UserProfileRes;
import com.jfatty.zcloud.auth.utils.PhoneNumUtil;
import com.jfatty.zcloud.base.utils.RETResultUtils;
import com.jfatty.zcloud.base.utils.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;


/**
 * 描述
 *
 * @author jfatty on 2019/12/7
 * @email jfatty@163.com
 */
@Api(tags = "002*****登录授权API" ,value = "登录授权")
@Slf4j
@RestController
@RequestMapping(value={"/api"})
public class ApiLoginController {


    @Autowired
    private RedisTemplate redisTemplate ;

    @Autowired
    private StringRedisTemplate stringRedisTemplate ;

    @ApiOperation(value="001******登录")
    @RequestMapping(value = {"/login"} ,method = RequestMethod.POST)
    public RETResultUtils<String> login(@RequestBody LoginVoReq loginVo , HttpServletRequest request){
        //Subject subject = SecurityUtils.getSubject();
        //AuthenticationToken token = new UsernamePasswordToken(loginVo.getAccount(), loginVo.getPassword());
        //UsernamePasswordToken upToken = new UsernamePasswordToken(loginVo.getAccount(), loginVo.getPassword());
        //subject.login(upToken);
        //subject.login(token);
        //登录成功就不会报异常
        String msg = PhoneNumUtil.isPhone(loginVo.getAccount()) ;
        if(StringUtils.isNotEmptyAndBlank(msg))
            return RETResultUtils._509(msg) ;
        if(StringUtils.isEmptyOrBlank(loginVo.getPassword()))
            return RETResultUtils._509("验证码不能为空") ;
        String code = (String) redisTemplate.opsForValue().get(loginVo.getAccount());
        if(StringUtils.isEmptyOrBlank(code))
            return RETResultUtils._506("验证码已经失效") ;
        if(!code.equalsIgnoreCase(loginVo.getPassword()))
            return RETResultUtils._509("验证码错误") ;
        redisTemplate.delete(loginVo.getAccount());
        String token = "TOKEN"+System.currentTimeMillis() ;
        redisTemplate.opsForValue().set(token,loginVo);
        //redisTemplate.opsForValue().set(token,loginVo,7200,TimeUnit.SECONDS);
        LoginVoReq login = (LoginVoReq) redisTemplate.opsForValue().get(token);
        log.error("login [{}]",login);
        return new RETResultUtils(token) ;
    }

    @ApiOperation(value="002******获取用户登录信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户登录token", required = true , dataType = "String",defaultValue = "QAZXSWEDVRE741258")
    })
    @RequestMapping(value = {"/userProfile"} ,method = RequestMethod.GET)
    public RETResultUtils<UserProfileRes> userProfile(@RequestParam(value = "token" , defaultValue = "QAZXSWEDVRE741258") String token , HttpServletRequest request){
        if(StringUtils.isEmptyOrBlank(token))
            return RETResultUtils._509("token不能为空") ;
        LoginVoReq login = (LoginVoReq) redisTemplate.opsForValue().get(token);
        if ( login == null)
            return RETResultUtils._506("登录过期") ;
        redisTemplate.opsForValue().set(token,login);
        UserProfileRes userProfile = new UserProfileRes();
        userProfile.setAccount(login.getAccount());
        userProfile.setNickName("张三");
        userProfile.setRole("普通用户");
        return new RETResultUtils(userProfile) ;
    }


}
