package com.jfatty.zcloud.hospital.api;


import com.jfatty.zcloud.hospital.entity.CcbConfig;
import com.jfatty.zcloud.hospital.interfaces.ICcbConfig;
import com.jfatty.zcloud.hospital.req.CcbConfigReq;
import com.jfatty.zcloud.hospital.res.CcbConfigRes;
import com.jfatty.zcloud.hospital.service.CcbConfigService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 建行支付配置信息表 前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2020-07-27
 */
@Api(tags = "建行支付配置信息API" ,value = "建行支付配置信息")
@Slf4j
@RestController
@RequestMapping("/api/ccbConfig")
public class ApiCcbConfigController extends ApiBaseHospitalController<CcbConfig,CcbConfigReq,CcbConfigRes> implements ICcbConfig {

    private CcbConfigService ccbConfigService ;

    @Autowired
    public void setCcbConfigService(CcbConfigService ccbConfigService) {
        super.setBaseService(ccbConfigService);
        this.ccbConfigService = ccbConfigService;
    }

}

