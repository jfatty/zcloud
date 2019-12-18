package com.jfatty.zcloud.hospital.api;


import com.jfatty.zcloud.base.utils.RETResultUtils;
import com.jfatty.zcloud.hospital.entity.Protocol;
import com.jfatty.zcloud.hospital.interfaces.IProtocol;
import com.jfatty.zcloud.hospital.req.ProtocolReq;
import com.jfatty.zcloud.hospital.res.ProtocolRes;
import com.jfatty.zcloud.hospital.service.ProtocolService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 协议或用户需知表 前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2019-12-12
 */
@Api(tags = "协议或用户需知API" ,value = "协议或用户需知")
@Slf4j
@RestController
@RequestMapping("/api/protocol")
public class ApiProtocolController extends ApiBaseHospitalController<Protocol,ProtocolReq,ProtocolRes>  implements IProtocol {

    private ProtocolService protocolService ;

    @Autowired
    public void setProtocolService(ProtocolService protocolService) {
        super.setBaseService(protocolService);
        this.protocolService = protocolService;
    }


    @ApiOperation(value="001******协议或用户需知获取通道")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appId", value = "每个应用都对应有appId支付宝、微信、第三方APP",dataType = "String",defaultValue = "wxe3336a60d2685379"),
            @ApiImplicitParam(name = "version", value = "版本号",dataType = "String",defaultValue = "1.0.0"),
            @ApiImplicitParam(name = "opcode", value = "操作码例如 绑定就诊卡 预约挂号 添加就诊人",dataType = "String",defaultValue = "yygh")
    })
    @RequestMapping(value={"/gangway"},method=RequestMethod.GET)
    public RETResultUtils<ProtocolRes> gangway(@RequestParam(value = "appId" , defaultValue = "wxe3336a60d2685379" ) String appId  ,
                                           @RequestParam(value = "version" , defaultValue = "1.0.0") String version ,
                                           @RequestParam(value = "opcode" , defaultValue = "yygh" ) String opcode ){
        List<Protocol> protocols = protocolService.getByDiffs(appId,version,opcode);
        if(CollectionUtils.isEmpty(protocols))
            return RETResultUtils.success("未查询到对应菜单") ;
        ProtocolRes protocolRes = new ProtocolRes();
        BeanUtils.copyProperties(protocols.get(0),protocolRes);
        return new RETResultUtils(protocolRes);
    }

}

