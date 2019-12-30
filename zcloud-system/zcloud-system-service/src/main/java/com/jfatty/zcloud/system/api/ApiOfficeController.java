package com.jfatty.zcloud.system.api;

import com.jfatty.zcloud.system.entity.Office;
import com.jfatty.zcloud.system.interfaces.IOffice;
import com.jfatty.zcloud.system.req.OfficeReq;
import com.jfatty.zcloud.system.res.OfficeRes;
import com.jfatty.zcloud.system.service.OfficeService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述 系统科室
 *
 * @author jfatty on 2019/11/13
 * @email jfatty@163.com
 */
@Api(tags = "系统科室API" ,value = "系统科室")
@Slf4j
@RestController
@RequestMapping(value={"/api/office"})
public class ApiOfficeController extends ApiBaseSystemController<Office,OfficeReq,OfficeRes>  implements IOffice {

    private OfficeService officeService ;

    @Autowired
    public void setOfficeService(OfficeService officeService) {
        super.setBaseService(officeService);
        this.officeService = officeService;
    }
}
