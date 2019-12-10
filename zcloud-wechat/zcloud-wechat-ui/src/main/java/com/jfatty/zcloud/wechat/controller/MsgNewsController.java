package com.jfatty.zcloud.wechat.controller;


import com.jfatty.zcloud.wechat.feign.MsgNewsFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 描述
 *
 * @author jfatty on 2019/11/13
 * @email jfatty@163.com
 */
@Slf4j
@RestController
public class MsgNewsController {

    @Autowired
    private MsgNewsFeignClient msgNewsFeignClient ;

    /**
     * @description:最新文章列表获取
     * @author jfatty
     * @date 2018年7月26日
     * @version 1.0.0
     * @param request
     * @param session
     * @return
     */
    @RequestMapping(value={"/msgNews/list"})
    public Object list(HttpServletRequest request, HttpSession session) {
        return msgNewsFeignClient.list();
    }

}
