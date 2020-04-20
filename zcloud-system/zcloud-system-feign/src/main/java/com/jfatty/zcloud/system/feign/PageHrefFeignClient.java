package com.jfatty.zcloud.system.feign;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.base.utils.ResultUtils;
import com.jfatty.zcloud.system.entity.PageHref;
import com.jfatty.zcloud.system.req.PageHrefReq;
import com.jfatty.zcloud.system.res.PageHrefRes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 描述
 *
 * @author jfatty on 2020/1/7
 * @email jfatty@163.com
 */
@FeignClient(value = "zcloud-system-service" , path = "/api/pageHref")
public interface PageHrefFeignClient   extends BInterface<PageHref,PageHrefReq,PageHrefRes> {

    @RequestMapping(value = {"/getPageHrefsOpts"} ,method = RequestMethod.GET)
    RELResultUtils<PageHrefRes> getPageHrefsOpts(@RequestParam(value = "appId" , defaultValue = "wxe3336a60d2685379" ) String appId  ,//
                                                 @RequestParam(value = "hospitalId" , defaultValue = "30646" ) String hospitalId  ,//
                                                 @RequestParam(value = "verifyName" , defaultValue = "getHealthCardByHealthCardInfoId" ) String verifyName  ,
                                                 @RequestParam(value = "verifyRule" ,  defaultValue = "addWechatPack") String verifyRule);


    @RequestMapping(value = {"/table/list"}, method = RequestMethod.POST)
    RELResultUtils<PageHrefRes> table(@RequestBody Map<String, Object> params);


    @RequestMapping(value = {"/table/list"}, method = RequestMethod.GET)
    RELResultUtils<PageHrefRes> table(@RequestParam(value = "v", defaultValue = "20191101") String v,
                                       @RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex,
                                       @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize);

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    ResultUtils list();

    @RequestMapping(value = {"/list"}, method = RequestMethod.POST)
    List<PageHrefRes> list(@RequestParam(value = "v", defaultValue = "20191101") Long v);

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    ResultUtils save(@RequestBody PageHrefReq entity);

    @RequestMapping(value = {"/edit"}, method = RequestMethod.GET)
    ResultUtils view(@RequestParam(value = "id", defaultValue = "AQAQAQ") String id);

    @RequestMapping(value = {"/edit"}, method = RequestMethod.POST)
    ResultUtils edit(@RequestBody PageHrefReq entity);

    @RequestMapping(value = {"/delete"}, method = RequestMethod.POST)
    ResultUtils delete(@RequestBody Map<String, Object> params);

}
