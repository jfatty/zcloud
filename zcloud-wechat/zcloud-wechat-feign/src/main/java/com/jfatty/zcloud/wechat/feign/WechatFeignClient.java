package com.jfatty.zcloud.wechat.feign;

import com.jfatty.zcloud.base.utils.ResultUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 描述
 *
 * @author jfatty on 2019/12/4
 * @email jfatty@163.com
 */
@FeignClient(value = "zcloud-wechat-service" , path = "/api/wx")
public interface WechatFeignClient {

    @RequestMapping(value = "/dataCube" , method = RequestMethod.POST)
    ResultUtils dataCube(@RequestParam(value = "type" , defaultValue = "WX") String type ,
                         @RequestParam(value = "start" , defaultValue = "2019-01-01" ) String start ,
                         @RequestParam(value = "end" , defaultValue = "201-11-11") String end);
}
