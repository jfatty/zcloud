package com.jfatty.zcloud.hospital.feign;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.base.utils.ResultUtils;
import com.jfatty.zcloud.hospital.entity.Protocol;
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
 * @author jfatty on 2019/12/12
 * @email jfatty@163.com
 */
@FeignClient(value = "zcloud-hospital-service" , path = "/api/protocol" )
public interface ProtocolFeignClient extends BInterface<Protocol> {


    @RequestMapping(value={"/table/list"},method = RequestMethod.POST)
    RELResultUtils<Protocol> table(@RequestBody Map<String,Object> params) ;


    @RequestMapping(value={"/table/list"},method = RequestMethod.GET )
    RELResultUtils<Protocol> table(@RequestParam(value = "v" , defaultValue = "20191101") String v ,
                                     @RequestParam(value = "pageIndex" , defaultValue = "1" ) Integer pageIndex ,
                                     @RequestParam(value = "pageSize" , defaultValue = "10") Integer pageSize) ;

    @RequestMapping(value={"/list"},method=RequestMethod.GET)
    ResultUtils list() ;

    @RequestMapping(value={"/list"},method=RequestMethod.POST)
    List<Protocol> list(@RequestParam(value = "v" , defaultValue = "20191101") Long v);

    @RequestMapping(value={"/save"},method=RequestMethod.POST)
    ResultUtils save(@RequestBody Protocol entity) ;

    @RequestMapping(value={"/edit"},method=RequestMethod.GET)
    ResultUtils view(@RequestParam(value = "id" , defaultValue = "AQAQAQ") String id ) ;

    @RequestMapping(value={"/edit"},method=RequestMethod.POST)
    ResultUtils edit(@RequestBody Protocol entity) ;

    @RequestMapping(value={"/delete"},method=RequestMethod.POST)
    ResultUtils delete(@RequestBody Map<String,Object> params) ;

}
