package com.jfatty.zcloud.wechat.feign;

import com.jfatty.zcloud.base.utils.ResultUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 描述
 *
 * @author jfatty on 2019/12/4
 * @email jfatty@163.com
 */
@FeignClient(value = "zcloud-wechat-service" , path = "/api/msgNews")
public interface MsgNewsFeignClient {


    @RequestMapping("/list")
    ResultUtils list() ;

}
