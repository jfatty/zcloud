package com.jfatty.zcloud.hospital.api;


import com.jfatty.zcloud.hospital.entity.ConfigProfile;
import com.jfatty.zcloud.hospital.interfaces.IConfigProfile;
import com.jfatty.zcloud.hospital.req.ConfigProfileReq;
import com.jfatty.zcloud.hospital.res.ConfigProfileRes;
import com.jfatty.zcloud.hospital.service.ConfigProfileService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 智慧医疗系统配置配置 前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2020-05-20
 */
@Api(tags = "智慧医疗系统配置配置API" ,value = "智慧医疗系统配置配置")
@Slf4j
@RestController
@RequestMapping("/api/configProfile")
public class ApiConfigProfileController extends ApiBaseHospitalController<ConfigProfile,ConfigProfileReq,ConfigProfileRes> implements IConfigProfile {

    private ConfigProfileService configProfileService ;

    @Autowired
    public void setConfigProfileService(ConfigProfileService configProfileService) {
        super.setBaseService(configProfileService);
        this.configProfileService = configProfileService;
    }


}

