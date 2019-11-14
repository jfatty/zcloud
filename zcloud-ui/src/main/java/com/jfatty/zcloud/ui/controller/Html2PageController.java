package com.jfatty.zcloud.ui.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述
 *
 * @author jfatty on 2019/11/13
 * @email jfatty@163.com
 */

@Controller
@Slf4j
public class Html2PageController {

    @RequestMapping(value="index")
    public ModelAndView index(){
        return new ModelAndView("index") ;
    }

    /**
     * 二级页面
     * @param request
     * @return
     */
    @RequestMapping(value="/{[\\s\\S]*}/{[\\s\\S]*}.htm")
    public ModelAndView secondPage(HttpServletRequest request) {
        return  new ModelAndView(rturnPath(request,"二"));
    }

    /**
     * 三级页面
     * @param request
     * @return
     */
    @RequestMapping(value="/{[\\s\\S]*}/{[\\s\\S]*}/{[\\s\\S]*}.htm")
    public ModelAndView thirdPage(HttpServletRequest request) {
        return  new ModelAndView(rturnPath(request,"三"));
    }

    /**
     * 四级页面
     * @param request
     * @return
     */
    @RequestMapping(value="/{[\\s\\S]*}/{[\\s\\S]*}/{[\\s\\S]*}/{[\\s\\S]*}.htm")
    public ModelAndView forthPage(HttpServletRequest request) {
        return  new ModelAndView(rturnPath(request,"四"));
    }

    /**
     * 五级页面
     * @param request
     * @return
     */
    @RequestMapping(value="/{[\\s\\S]*}/{[\\s\\S]*}/{[\\s\\S]*}/{[\\s\\S]*}/{[\\s\\S]*}.htm")
    public ModelAndView fifthPage(HttpServletRequest request) {
        return  new ModelAndView(rturnPath(request,"五"));
    }

    private String rturnPath(HttpServletRequest request,String grade){
        String title = grade + "级页面" ;
        String requestUrl = request.getRequestURI() ;
        log.info(title+"-------       requestUrl    -----------------"+requestUrl);
        String ctx = request.getContextPath() ;
        log.info(title+"-------       ctx      ------------"+ctx);
        requestUrl =  requestUrl.substring(ctx.length(),requestUrl.length());
        log.info(title+"----------------------------------    requestUrl    ------------------------"+requestUrl);
        requestUrl = requestUrl.substring(1, requestUrl.length());
        requestUrl = requestUrl.replaceAll(".htm", "");
        log.info(title+"-------   replaceAll    ----  .htm  ----   requestUrl  ----" + requestUrl);
        return  requestUrl ;
    }

}
