package com.jfatty.zcloud.hospital.api;


import com.jfatty.zcloud.hospital.entity.AlipayConfig;
import com.jfatty.zcloud.hospital.interfaces.IAlipayConfig;
import com.jfatty.zcloud.hospital.req.AlipayConfigReq;
import com.jfatty.zcloud.hospital.res.AlipayConfigRes;
import com.jfatty.zcloud.hospital.service.AlipayConfigService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 支付宝支付配置信息表 前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2019-12-23
 */

@Api(tags = "支付宝支付配置信息API" ,value = "支付宝支付配置信息")
@Slf4j
@RestController
@RequestMapping("/api/alipayConfig")
public class ApiAlipayConfigController extends ApiBaseHospitalController<AlipayConfig,AlipayConfigReq,AlipayConfigRes>  implements IAlipayConfig {

    private AlipayConfigService alipayConfigService ;


    @Autowired
    public void setAlipayConfigService(AlipayConfigService alipayConfigService) {
        super.setBaseService(alipayConfigService);
        this.alipayConfigService = alipayConfigService;
    }



}

