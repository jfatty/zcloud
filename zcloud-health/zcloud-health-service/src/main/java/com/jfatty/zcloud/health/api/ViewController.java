package com.jfatty.zcloud.health.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 描述
 *
 * @author jfatty on 2019/12/14
 * @email jfatty@163.com
 */
@Slf4j
@Controller
public class ViewController {

    @RequestMapping("/")
    public ModelAndView index(){
        return new ModelAndView("index.html");
    }
}
