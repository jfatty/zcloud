package com.jfatty.zcloud.system.api;


import com.jfatty.zcloud.system.entity.AreaCn;
import com.jfatty.zcloud.system.interfaces.IAreaCn;
import com.jfatty.zcloud.system.req.AreaCnReq;
import com.jfatty.zcloud.system.res.AreaCnRes;
import com.jfatty.zcloud.system.service.AreaCnService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 中国行政地区表 前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2019-12-27
 */
@Api(tags = "中国行政地区API" ,value = "中国行政地区")
@Slf4j
@RestController
@RequestMapping(value={"/api/areaCn"})
public class ApiAreaCnController extends ApiBaseSystemController<AreaCn,AreaCnReq,AreaCnRes>  implements IAreaCn {

    private AreaCnService areaCnService ;

    @Autowired
    public void setAreaCnService(AreaCnService areaCnService) {
        super.setBaseService(areaCnService);
        this.areaCnService = areaCnService;
    }
}

