package com.jfatty.zcloud.wechat.controller;


import com.jfatty.zcloud.wechat.feign.WechatFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述
 *
 * @author jfatty on 2019/12/4
 * @email jfatty@163.com
 */
@Slf4j
@RestController
@RequestMapping(value={"/wechat"})
public class WechatController {

    @Autowired
    private WechatFeignClient wechatFeignClient ;

    @RequestMapping(value = "/dataCube" , method = RequestMethod.POST)
    public Object dataCube(String type, String start, String end) {
        return wechatFeignClient.dataCube(type,start,end) ;
    }

}
