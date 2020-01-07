package com.jfatty.zcloud.system.feign;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.system.entity.PageHref;
import com.jfatty.zcloud.system.req.PageHrefReq;
import com.jfatty.zcloud.system.res.PageHrefRes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 描述
 *
 * @author jfatty on 2020/1/7
 * @email jfatty@163.com
 */
@FeignClient(value = "zcloud-system-service" , path = "/api/pageHref")
public interface PageHrefFeignClient   extends BInterface<PageHref,PageHrefReq,PageHrefRes> {

    RELResultUtils<PageHrefRes> getPageHrefsOpts(@RequestParam(value = "appId" , defaultValue = "wxe3336a60d2685379" ) String appId  ,//
                                                 @RequestParam(value = "hospitalId" , defaultValue = "30646" ) String hospitalId  ,//
                                                 @RequestParam(value = "verifyName" , defaultValue = "getHealthCardByHealthCardInfoId" ) String verifyName  ,
                                                 @RequestParam(value = "verifyRule" ,  defaultValue = "addWechatPack") String verifyRule);

}
