package com.jfatty.zcloud.alipay.api;

import com.jfatty.zcloud.alipay.entity.AlipayAutoresponseDefault;
import com.jfatty.zcloud.alipay.interfaces.IAlipayAutoresponseDefault;
import com.jfatty.zcloud.alipay.req.AlipayAutoresponseDefaultReq;
import com.jfatty.zcloud.alipay.res.AlipayAutoresponseDefaultRes;
import com.jfatty.zcloud.alipay.service.AlipayAutoresponseDefaultService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述  默认关键字回复
 *
 * @author jfatty on 2020/4/26
 * @email jfatty@163.com
 */
@Api(tags = "默认关键字回复API" ,value = "默认关键字回复")
@Slf4j
@RestController
@RequestMapping(value={"/api/alipayAutoresponseDefault"})
public class ApiAlipayAutoresponseDefaultController extends
        ApiBaseAlipayController<AlipayAutoresponseDefault,AlipayAutoresponseDefaultReq,AlipayAutoresponseDefaultRes> implements IAlipayAutoresponseDefault {


    private AlipayAutoresponseDefaultService alipayAutoresponseDefaultService ;

    @Autowired
    public void setAlipayAutoresponseDefaultService(AlipayAutoresponseDefaultService alipayAutoresponseDefaultService) {
        super.setBaseService(alipayAutoresponseDefaultService);
        this.alipayAutoresponseDefaultService = alipayAutoresponseDefaultService;
    }
}
