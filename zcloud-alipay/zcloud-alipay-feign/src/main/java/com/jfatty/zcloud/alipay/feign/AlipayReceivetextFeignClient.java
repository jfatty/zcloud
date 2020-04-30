package com.jfatty.zcloud.alipay.feign;

import com.jfatty.zcloud.alipay.entity.AlipayReceivetext;
import com.jfatty.zcloud.alipay.req.AlipayReceivetextReq;
import com.jfatty.zcloud.alipay.res.AlipayReceivetextRes;
import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.base.utils.ResultUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 描述 文本消息
 *
 * @author jfatty on 2020/4/26
 * @email jfatty@163.com
 */
@FeignClient(value = "zcloud-alipay-service" , path = "/api/alipayReceivetext" )
public interface AlipayReceivetextFeignClient extends BInterface<AlipayReceivetext,AlipayReceivetextReq,AlipayReceivetextRes> {

    @RequestMapping(value={"/table/list"},method = RequestMethod.POST)
    RELResultUtils<AlipayReceivetextRes> table(@RequestBody Map<String,Object> params) ;


    @RequestMapping(value={"/table/list"},method = RequestMethod.GET )
    RELResultUtils<AlipayReceivetextRes> table(@RequestParam(value = "v" , defaultValue = "20191101") String v ,
                                                @RequestParam(value = "pageIndex" , defaultValue = "1" ) Integer pageIndex ,
                                                @RequestParam(value = "pageSize" , defaultValue = "10") Integer pageSize) ;

    @RequestMapping(value={"/list"},method=RequestMethod.GET)
    ResultUtils list() ;

    @RequestMapping(value={"/list"},method=RequestMethod.POST)
    List<AlipayReceivetextRes> list(@RequestParam(value = "v" , defaultValue = "20191101") Long v);

    @RequestMapping(value={"/save"},method=RequestMethod.POST)
    ResultUtils save(@RequestBody AlipayReceivetextReq entity) ;

    @RequestMapping(value={"/edit"},method=RequestMethod.GET)
    ResultUtils view(@RequestParam(value = "id" , defaultValue = "AQAQAQ") String id ) ;

    @RequestMapping(value={"/edit"},method=RequestMethod.POST)
    ResultUtils edit(@RequestBody AlipayReceivetextReq entity) ;

    @RequestMapping(value={"/delete"},method=RequestMethod.POST)
    ResultUtils delete(@RequestBody Map<String,Object> params) ;

}
