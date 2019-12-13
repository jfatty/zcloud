package com.jfatty.zcloud.system.api;


import com.jfatty.zcloud.system.entity.IdentityFile;
import com.jfatty.zcloud.system.interfaces.IIdentityFile;
import com.jfatty.zcloud.system.service.IdentityFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2019-12-13
 */
@Slf4j
@RestController
@RequestMapping(value={"/api/identityFile"})
public class ApiIdentityFileController extends ApiBaseSystemController<IdentityFile>  implements IIdentityFile {


    private IdentityFileService identityFileService ;

    @Autowired
    public void setIdentityFileService(IdentityFileService identityFileService) {
        super.setBaseService(identityFileService);
        this.identityFileService = identityFileService;
    }

}

