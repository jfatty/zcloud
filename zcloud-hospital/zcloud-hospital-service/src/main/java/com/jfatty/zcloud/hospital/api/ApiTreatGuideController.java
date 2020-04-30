package com.jfatty.zcloud.hospital.api;


import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.hospital.entity.TreatGuide;
import com.jfatty.zcloud.hospital.interfaces.ITreatGuide;
import com.jfatty.zcloud.hospital.req.TreatGuideReq;
import com.jfatty.zcloud.hospital.res.MenuRes;
import com.jfatty.zcloud.hospital.res.TreatGuideRes;
import com.jfatty.zcloud.hospital.service.TreatGuideService;
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

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 就诊指南 前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2020-04-28
 */
@Api(tags = "就诊指南API" ,value = "就诊指南")
@Slf4j
@RestController
@RequestMapping("/api/treatGuide")
public class ApiTreatGuideController extends ApiBaseHospitalController<TreatGuide,TreatGuideReq,TreatGuideRes> implements ITreatGuide {

    private TreatGuideService treatGuideService ;

    @Autowired
    public void setTreatGuideService(TreatGuideService treatGuideService) {
        super.setBaseService(treatGuideService);
        this.treatGuideService = treatGuideService;
    }


    @ApiOperation(value="001****获取就诊指南列表查看详情时使用标题和详情地址")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appId", value = "每个应用都对应有appId支付宝、微信、第三方APP",dataType = "String",defaultValue = "wxe3336a60d2685379"),
            @ApiImplicitParam(name = "version", value = "版本号",dataType = "String",defaultValue = "1.0.0"),
            @ApiImplicitParam(name = "specification", value = "规格,格式  PC MOBILE PAD APP",dataType = "String",defaultValue = "MOBILE")
    })
    @RequestMapping(value={"/getTreatGuides"},method=RequestMethod.GET)
    public RELResultUtils<TreatGuideRes> getTreatGuides(@RequestParam(value = "appId" , defaultValue = "wxe3336a60d2685379" ) String appId  ,
                                            @RequestParam(value = "version" , defaultValue = "1.0.0") String version ,
                                            @RequestParam(value = "specification" ,required = true, defaultValue = "MOBILE" ) String specification ){
        List<TreatGuide> treatGuides = treatGuideService.getTreatGuides(appId,version,"MOBILE");
        if(CollectionUtils.isEmpty(treatGuides))
            return RELResultUtils._506("未查询到就诊指南") ;
        List<TreatGuideRes> treatGuideRes = new ArrayList<TreatGuideRes>();
        treatGuides.forEach(
                treatGuide -> {
                    TreatGuideRes treatGuideRe = new TreatGuideRes();
                    BeanUtils.copyProperties(treatGuide,treatGuideRe);
                    treatGuideRes.add(treatGuideRe);
                }
        );
        return new RELResultUtils(treatGuideRes);
    }



}

