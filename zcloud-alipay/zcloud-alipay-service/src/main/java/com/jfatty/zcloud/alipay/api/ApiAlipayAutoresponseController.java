package com.jfatty.zcloud.alipay.api;

import com.jfatty.zcloud.alipay.entity.AlipayAutoresponse;
import com.jfatty.zcloud.alipay.interfaces.IAlipayAutoresponse;
import com.jfatty.zcloud.alipay.req.AlipayAutoresponseReq;
import com.jfatty.zcloud.alipay.res.AlipayAutoresponseRes;
import com.jfatty.zcloud.alipay.service.AlipayAutoresponseService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述 支付宝自动回复
 *
 * @author jfatty on 2020/4/26
 * @email jfatty@163.com
 */
@Api(tags = "支付宝自动回复API" ,value = "支付宝自动回复")
@Slf4j
@RestController
@RequestMapping(value={"/api/alipayAutoresponse"})
public class ApiAlipayAutoresponseController extends ApiBaseAlipayController<AlipayAutoresponse,AlipayAutoresponseReq,AlipayAutoresponseRes> implements IAlipayAutoresponse {


    private AlipayAutoresponseService alipayAutoresponseService ;


    @Autowired
    public void setAlipayAutoresponseService(AlipayAutoresponseService alipayAutoresponseService) {
        super.setBaseService(alipayAutoresponseService);
        this.alipayAutoresponseService = alipayAutoresponseService;
    }

}
