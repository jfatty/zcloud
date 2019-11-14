package com.jfatty.zcloud.system.api;

import com.jfatty.zcloud.system.entity.Office;
import com.jfatty.zcloud.system.interfaces.IOffice;
import com.jfatty.zcloud.system.service.OfficeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述
 *
 * @author jfatty on 2019/11/13
 * @email jfatty@163.com
 */
@Slf4j
@RestController
@RequestMapping(value={"/api/office"})
public class ApiOfficeController extends ApiBaseSystemController<Office>  implements IOffice {

    private OfficeService officeService ;

    @Autowired
    public void setOfficeService(OfficeService officeService) {
        super.setBaseService(officeService);
        this.officeService = officeService;
    }
}
