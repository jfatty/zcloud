package com.jfatty.zcloud.auth.api;

import com.jfatty.zcloud.auth.req.LoginVoReq;
import com.jfatty.zcloud.base.utils.RETResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


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



    @ApiOperation(value="001******登录")
    @RequestMapping(value = {"/login"} ,method = RequestMethod.POST)
    public RETResultUtils<String> login(@RequestBody LoginVoReq loginVo , HttpServletRequest request){
        //Subject subject = SecurityUtils.getSubject();
        //AuthenticationToken token = new UsernamePasswordToken(loginVo.getAccount(), loginVo.getPassword());
        //UsernamePasswordToken upToken = new UsernamePasswordToken(loginVo.getAccount(), loginVo.getPassword());
        //subject.login(upToken);
        //subject.login(token);
        //登录成功就不会报异常
        return new RETResultUtils("TOKENACDX"+System.currentTimeMillis()) ;
    }


}
