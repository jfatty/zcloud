package com.jfatty.zcloud.hospital.api;

import com.jfatty.zcloud.hospital.entity.WepayConfig;
import com.jfatty.zcloud.hospital.interfaces.IWepayConfig;
import com.jfatty.zcloud.hospital.req.WepayConfigReq;
import com.jfatty.zcloud.hospital.res.WepayConfigRes;
import com.jfatty.zcloud.hospital.service.WepayConfigService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 微信支付配置信息表 前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2019-12-19
 */
@Api(tags = "微信支付配置信息API" ,value = "微信支付配置信息")
@Slf4j
@RestController
@RequestMapping("/api/wepayConfig")
public class ApiWepayConfigController extends ApiBaseHospitalController<WepayConfig,WepayConfigReq,WepayConfigRes>  implements IWepayConfig {

    private WepayConfigService wepayConfigService ;

    @Autowired
    public void setWepayConfigService(WepayConfigService wepayConfigService) {
        super.setBaseService(wepayConfigService);
        this.wepayConfigService = wepayConfigService;
    }
}
