package com.jfatty.zcloud.health.api;



import com.jfatty.zcloud.health.entity.HCSIDCardInfo;
import com.jfatty.zcloud.health.interfaces.IHCSIDCardInfo;
import com.jfatty.zcloud.health.req.HCSIDCardInfoReq;
import com.jfatty.zcloud.health.res.HCSIDCardInfoRes;
import com.jfatty.zcloud.health.service.HCSIDCardInfoService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 身份证信息表 前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2019-12-26
 */
@Api(tags = "身份证信息API" ,value = "身份证信息")
@Slf4j
@RestController
@RequestMapping(value={"/api/idCardInfo"})
public class ApiHCSIDCardInfoController extends ApiBaseHealthController<HCSIDCardInfo,HCSIDCardInfoReq,HCSIDCardInfoRes>  implements IHCSIDCardInfo {

    private HCSIDCardInfoService hcsidCardInfoService ;

    @Autowired
    public void setHcsidCardInfoService(HCSIDCardInfoService hcsidCardInfoService) {
        super.setBaseService(hcsidCardInfoService);
        this.hcsidCardInfoService = hcsidCardInfoService;
    }
}

