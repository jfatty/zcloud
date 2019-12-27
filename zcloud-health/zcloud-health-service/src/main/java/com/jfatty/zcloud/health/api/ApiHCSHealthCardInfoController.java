package com.jfatty.zcloud.health.api;


import com.jfatty.zcloud.health.entity.HCSHealthCardInfo;
import com.jfatty.zcloud.health.entity.HealthCardSettings;
import com.jfatty.zcloud.health.interfaces.IHCSHealthCardInfo;
import com.jfatty.zcloud.health.interfaces.IHealthCardSettings;
import com.jfatty.zcloud.health.req.HCSHealthCardInfoReq;
import com.jfatty.zcloud.health.req.HealthCardSettingsReq;
import com.jfatty.zcloud.health.res.HCSHealthCardInfoRes;
import com.jfatty.zcloud.health.res.HealthCardSettingsRes;
import com.jfatty.zcloud.health.service.HCSHealthCardInfoService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2019-12-26
 */

@Api(tags = "健康卡信息API" ,value = "健康卡信息")
@Slf4j
@RestController
@RequestMapping(value={"/api/healthCardInfo"})
public class ApiHCSHealthCardInfoController  extends ApiBaseHealthController<HCSHealthCardInfo,HCSHealthCardInfoReq,HCSHealthCardInfoRes>  implements IHCSHealthCardInfo {

    private HCSHealthCardInfoService hcsHealthCardInfoService ;

    @Autowired
    public void setHcsHealthCardInfoService(HCSHealthCardInfoService hcsHealthCardInfoService) {
        super.setBaseService(hcsHealthCardInfoService);
        this.hcsHealthCardInfoService = hcsHealthCardInfoService;
    }
}

