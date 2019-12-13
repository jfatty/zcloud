package com.jfatty.zcloud.uiadmin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 描述
 *
 * @author jfatty on 2019/12/9
 * @email jfatty@163.com
 */
@Slf4j
@Controller
public class LoginController {

    @GetMapping(value = "/login")
    public ModelAndView login() {
        System.out.println("================>去登陆");
        ModelAndView model = new ModelAndView();
        model.setViewName("html/login");
        return model;
    }



}
