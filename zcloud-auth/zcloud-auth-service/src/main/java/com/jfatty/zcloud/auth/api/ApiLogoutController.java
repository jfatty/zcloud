package com.jfatty.zcloud.auth.api;

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

/**
 * 描述 注销登录
 *
 * @author jfatty on 2020/2/3
 * @email jfatty@163.com
 */

@Api(tags = "003*****注销登录API" ,value = "注销登录")
@Slf4j
@RestController
@RequestMapping(value={"/api"})
public class ApiLogoutController  {


    @Autowired
    private RedisTemplate redisTemplate ;

    @Autowired
    private StringRedisTemplate stringRedisTemplate ;


    @ApiOperation(value="001******注销")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "登录秘钥",dataType = "String",defaultValue = "132154wx4712402349f957a41582"),
            @ApiImplicitParam(name = "random", value = "时间戳/随机字符串",dataType = "String",defaultValue = "122151881"),
            @ApiImplicitParam(name = "appId", value = "每个应用都对应有appId支付宝、微信、第三方APP",dataType = "String",defaultValue = "wx4712402349f957a4")
    })
    @RequestMapping(value = {"/logout"} ,method = {RequestMethod.GET,RequestMethod.POST})
    public RETResultUtils<String> logout(@RequestParam(value = "token" , defaultValue = "132154wx4712402349f957a41582") String token ,//
                                          @RequestParam(value = "random" , defaultValue = "122151881" ) String random,//
                                          @RequestParam(value = "appId" , defaultValue = "wx4712402349f957a4" ) String appId,//
                                          HttpServletRequest request ){

        if(StringUtils.isEmptyOrBlank(appId))
            return RETResultUtils._509("appId不能为空") ;
        if(StringUtils.isEmptyOrBlank(token))
            return RETResultUtils._509("token不能为空") ;
        //通过请求头信息判断 agent 请求发起者是 APP微信还是PC端
        //删除token对应用户信息
        if ( redisTemplate.delete(token) )
            return RETResultUtils.success("注销成功");
        //用户注销登录 删除缓存信息失败
        log.error("logout 注销对应 token 值 ========> [{}] random ========> [{}] appId ========> [{}]",token,random,appId);
        return RETResultUtils.faild("哎呀!网络走丢了!");
    }

}
