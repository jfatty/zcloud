package com.jfatty.zcloud.hospital.api;


import com.jfatty.zcloud.hospital.entity.Protocol;
import com.jfatty.zcloud.hospital.interfaces.IProtocol;
import com.jfatty.zcloud.hospital.service.ProtocolService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 协议或用户需知表 前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2019-12-12
 */
@Slf4j
@RestController
@RequestMapping("/api/protocol")
public class ApiProtocolController extends ApiBaseHospitalController<Protocol>  implements IProtocol {

    private ProtocolService protocolService ;

    @Autowired
    public void setProtocolService(ProtocolService protocolService) {
        super.setBaseService(protocolService);
        this.protocolService = protocolService;
    }

}

