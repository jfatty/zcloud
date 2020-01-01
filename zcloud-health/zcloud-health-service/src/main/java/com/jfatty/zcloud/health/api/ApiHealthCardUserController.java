package com.jfatty.zcloud.health.api;


import com.jfatty.zcloud.health.entity.HealthCardUser;
import com.jfatty.zcloud.health.interfaces.IHealthCardUser;
import com.jfatty.zcloud.health.req.HealthCardUserReq;
import com.jfatty.zcloud.health.res.HealthCardUserRes;
import com.jfatty.zcloud.health.service.HealthCardUserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 电子健康卡微信用户信息表 前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2019-12-31
 */
@Api(tags = "电子健康卡微信用户信息API" ,value = "电子健康卡微信用户信息")
@Slf4j
@RestController
@RequestMapping(value={"/api/healthCardUser"})
public class ApiHealthCardUserController extends ApiBaseHealthController<HealthCardUser,HealthCardUserReq,HealthCardUserRes>  implements IHealthCardUser {

    private HealthCardUserService healthCardUserService ;

    @Autowired
    public void setHealthCardUserService(HealthCardUserService healthCardUserService) {
        super.setBaseService(healthCardUserService);
        this.healthCardUserService = healthCardUserService;
    }

}

