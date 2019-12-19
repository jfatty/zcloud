package com.jfatty.zcloud.auth.api;

import com.jfatty.zcloud.base.utils.RETResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述
 *
 * @author jfatty on 2019/12/19
 * @email jfatty@163.com
 */
@Api(tags = "001*****短息验证码API" ,value = "短息验证码")
@Slf4j
@RestController
@RequestMapping(value={"/api"})
public class ApiKaptchaController {



    @ApiOperation(value="001******向用户手机号发送验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "时间戳",dataType = "String",defaultValue = "13177261541"),
            @ApiImplicitParam(name = "random", value = "时间戳/随机字符串",dataType = "String",defaultValue = "122151881"),
            @ApiImplicitParam(name = "appId", value = "每个应用都对应有appId支付宝、微信、第三方APP",dataType = "String",defaultValue = "wx4712402349f957a4")
    })
    @RequestMapping(value = {"/kaptcha"} ,method = RequestMethod.GET)
    public RETResultUtils<String> kaptcha(@RequestParam(value = "phone" , defaultValue = "1321541582") String phone ,//
                                          @RequestParam(value = "random" , defaultValue = "122151881" ) String random,//
                                          @RequestParam(value = "appId" , defaultValue = "wx4712402349f957a4" ) String appId,//
                                          HttpServletRequest request ){
        System.out.println(appId);
        System.out.println(random);
        System.out.println(phone);
        return new RETResultUtils("验证码发送成功,请注意查收") ;
    }
}
