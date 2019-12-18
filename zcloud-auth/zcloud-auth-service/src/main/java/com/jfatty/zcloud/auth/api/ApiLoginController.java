package com.jfatty.zcloud.auth.api;

import com.jfatty.zcloud.auth.realm.PhoneRealm;
import com.jfatty.zcloud.auth.token.PhoneCaptchaToken;
import com.jfatty.zcloud.auth.vo.LoginVo;
import com.jfatty.zcloud.base.utils.ResultUtils;
import com.jfatty.zcloud.base.vo.AccountInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

/**
 * 描述
 *
 * @author jfatty on 2019/12/7
 * @email jfatty@163.com
 */
@Slf4j
@RestController
@RequestMapping(value={"/api"})
public class ApiLoginController {




    @PostMapping(value = "/login")
    public ResultUtils login(HttpServletRequest request, HttpSession session, @RequestBody LoginVo loginVo ){
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new UsernamePasswordToken(loginVo.getAccount(), loginVo.getPassword());
        //UsernamePasswordToken upToken = new UsernamePasswordToken(loginVo.getAccount(), loginVo.getPassword());
        //subject.login(upToken);
        subject.login(token);

        //登录成功就不会报异常
        return ResultUtils.success("登录成功") ;
    }

    @PostMapping(value = "/phone")
    public ResultUtils phone(HttpServletRequest request, HttpSession session, @RequestBody LoginVo loginVo ){
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new PhoneCaptchaToken(loginVo.getAccount(), loginVo.getPassword());
        //UsernamePasswordToken upToken = new UsernamePasswordToken(loginVo.getAccount(), loginVo.getPassword());
        //subject.login(upToken);
        subject.login(token);
        //登录成功就不会报异常
        return null ;
    }

}
