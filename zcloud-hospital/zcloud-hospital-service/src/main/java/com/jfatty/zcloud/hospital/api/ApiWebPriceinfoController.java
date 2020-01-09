package com.jfatty.zcloud.hospital.api;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.base.utils.StringUtils;
import com.jfatty.zcloud.hospital.req.WebPriceinfoReq;
import com.jfatty.zcloud.hospital.res.WebPriceinfoRes;
import com.jfatty.zcloud.hospital.service.WebPriceinfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 描述 物价查询
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
@Api(tags = "物价查询API" ,value = "物价查询")
@Slf4j
@RestController
@RequestMapping("/api/webPriceinfo")
public class ApiWebPriceinfoController {


    @Autowired
    private WebPriceinfoService webPriceinfoService ;


    @ApiOperation(value="POST 参数 获取列表数据")
    @RequestMapping(value = {"/getWebPriceinfo"} ,method = RequestMethod.POST)
    public RELResultUtils<WebPriceinfoRes> getWebPriceinfo(@RequestBody WebPriceinfoReq webPriceinfoReq){
        if(StringUtils.isEmptyOrBlank(webPriceinfoReq.getXmmc()))
            return RELResultUtils._509("请输入查询信息") ;
        List<WebPriceinfoRes> list = webPriceinfoService.getWebPriceinfo(webPriceinfoReq.getOpenId(),webPriceinfoReq.getOpenIdType(),webPriceinfoReq.getPageIndex(),webPriceinfoReq.getPageSize(),webPriceinfoReq.getXmmc(),webPriceinfoReq.getCxlb());
        if(CollectionUtils.isNotEmpty(list))
            return new RELResultUtils(list);
        return RELResultUtils._506("没有查询到相关物价信息") ;
    }


}
