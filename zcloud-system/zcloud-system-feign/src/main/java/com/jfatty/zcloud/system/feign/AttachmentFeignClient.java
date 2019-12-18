package com.jfatty.zcloud.system.feign;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.base.utils.ResultUtils;
import com.jfatty.zcloud.system.entity.Attachment;
import com.jfatty.zcloud.system.req.AttachmentReq;
import com.jfatty.zcloud.system.res.AttachmentRes;
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
 * @author jfatty on 2019/11/12
 * @email jfatty@163.com
 */
@FeignClient(value = "zcloud-system-service" , path = "/api/attachment")
public interface AttachmentFeignClient extends BInterface<Attachment,AttachmentReq,AttachmentRes> {


    @RequestMapping(value={"/table/list"},method = RequestMethod.POST)
    RELResultUtils<AttachmentRes> table(@RequestBody Map<String,Object> params) ;


    @RequestMapping(value={"/table/list"},method = RequestMethod.GET )
    RELResultUtils<AttachmentRes> table(@RequestParam(value = "v" , defaultValue = "20191101") String v ,
                               @RequestParam(value = "pageIndex" , defaultValue = "1" ) Integer pageIndex ,
                               @RequestParam(value = "pageSize" , defaultValue = "10") Integer pageSize) ;

    @RequestMapping(value={"/list"},method=RequestMethod.GET)
    ResultUtils list() ;

    @RequestMapping(value={"/list"},method=RequestMethod.POST)
    List<AttachmentRes> list(@RequestParam(value = "v" , defaultValue = "20191101") Long v);

    @RequestMapping(value={"/save"},method=RequestMethod.POST)
    ResultUtils save(@RequestBody AttachmentReq entity) ;

    @RequestMapping(value={"/edit"},method=RequestMethod.GET)
    ResultUtils view(@RequestParam(value = "id" , defaultValue = "AQAQAQ") String id ) ;

    @RequestMapping(value={"/edit"},method=RequestMethod.POST)
    ResultUtils edit(@RequestBody AttachmentReq entity) ;

    @RequestMapping(value={"/delete"},method=RequestMethod.POST)
    ResultUtils delete(@RequestBody Map<String,Object> params) ;

}
