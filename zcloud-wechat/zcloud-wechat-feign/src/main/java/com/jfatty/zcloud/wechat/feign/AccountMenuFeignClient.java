package com.jfatty.zcloud.wechat.feign;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.base.utils.ResultUtils;
import com.jfatty.zcloud.wechat.entity.AccountMenu;
import com.jfatty.zcloud.wechat.req.AccountMenuReq;
import com.jfatty.zcloud.wechat.res.AccountMenuRes;
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
 * @author jfatty on 2019/11/13
 * @email jfatty@163.com
 */
@FeignClient(value = "zcloud-wechat-service" , path = "/api/accountMenu")
public interface AccountMenuFeignClient extends BInterface<AccountMenu,AccountMenuReq,AccountMenuRes> {


    @RequestMapping(value={"/table/list"},method = RequestMethod.POST)
    RELResultUtils<AccountMenuRes> table(@RequestBody Map<String,Object> params) ;


    @RequestMapping(value={"/table/list"},method = RequestMethod.GET )
    RELResultUtils<AccountMenuRes> table(@RequestParam(value = "v" , defaultValue = "20191101") String v ,
                            @RequestParam(value = "pageIndex" , defaultValue = "1" ) Integer pageIndex ,
                            @RequestParam(value = "pageSize" , defaultValue = "10") Integer pageSize) ;

    @RequestMapping(value={"/list"},method=RequestMethod.GET)
    ResultUtils list() ;

    @RequestMapping(value={"/list"},method=RequestMethod.POST)
    List<AccountMenuRes> list(Long v);

    @RequestMapping(value={"/save"},method=RequestMethod.POST)
    ResultUtils save(@RequestBody AccountMenuReq entity) ;

    @RequestMapping(value={"/edit"},method=RequestMethod.GET)
    ResultUtils view(@RequestParam(value = "id" , defaultValue = "AQAQAQ") String id ) ;

    @RequestMapping(value={"/edit"},method=RequestMethod.POST)
    ResultUtils edit(@RequestBody AccountMenuReq entity) ;

    @RequestMapping(value={"/delete"},method=RequestMethod.POST)
    ResultUtils delete(@RequestBody Map<String,Object> params) ;

    @RequestMapping(value={"/saveMenu"},method=RequestMethod.POST)
    ResultUtils saveMenu(@RequestParam(value = "menus" , defaultValue = "AQAQAQ") String menus ) ;

    @RequestMapping(value={"/publishMenu"},method=RequestMethod.GET)
    ResultUtils publishMenu();
}
