package com.jfatty.zcloud.alipay.api;

import com.jfatty.zcloud.alipay.entity.AlipayConfig;
import com.jfatty.zcloud.alipay.interfaces.IAlipayConfig;
import com.jfatty.zcloud.alipay.req.AlipayConfigReq;
import com.jfatty.zcloud.alipay.res.AlipayConfigRes;
import com.jfatty.zcloud.alipay.service.AlipayConfigService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述 支付宝支付配置信息
 *
 * @author jfatty on 2020/4/26
 * @email jfatty@163.com
 */
@Api(tags = "支付宝支付配置信息API" ,value = "支付宝支付配置信息")
@Slf4j
@RestController
@RequestMapping(value={"/api/alipayConfig"})
public class ApiAlipayConfigController extends ApiBaseAlipayController<AlipayConfig,AlipayConfigReq,AlipayConfigRes> implements IAlipayConfig {


    private AlipayConfigService alipayConfigService ;

    @Autowired
    public void setAlipayConfigService(AlipayConfigService alipayConfigService) {
        super.setBaseService(alipayConfigService);
        this.alipayConfigService = alipayConfigService;
    }
}
