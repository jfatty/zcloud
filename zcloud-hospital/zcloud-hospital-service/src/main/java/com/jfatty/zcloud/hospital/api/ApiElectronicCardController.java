package com.jfatty.zcloud.hospital.api;

import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.base.utils.ResultUtils;
import com.jfatty.zcloud.hospital.req.ElectronicCardReq;
import com.jfatty.zcloud.hospital.res.ElectronicCardRes;
import com.jfatty.zcloud.hospital.res.WebRegPatientRes;
import com.jfatty.zcloud.hospital.service.ComplexPatientService;
import com.jfatty.zcloud.hospital.service.ElectronicCardService;
import com.jfatty.zcloud.hospital.vo.ElectronicCard;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述 电子就诊卡
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
@Api(tags = "电子就诊卡API" ,value = "电子就诊卡")
@Slf4j
@RestController
@RequestMapping("/api/electronicCard")
public class ApiElectronicCardController {

    @Autowired
    private ElectronicCardService electronicCardService ;

    @Autowired
    private ComplexPatientService complexPatientService ;

    @ApiOperation(value="001****获取电子就诊卡信息列表")
    @RequestMapping(value = {"/getWebPriceinfo"} ,method = RequestMethod.POST)
    public RELResultUtils<ElectronicCardRes> getElectronicCards(@RequestBody ElectronicCardReq electronicCardReq){
        List<WebRegPatientRes> list = complexPatientService.getWebRegList(electronicCardReq.getOpenId(),electronicCardReq.getOpenIdType());
        List<ElectronicCard>  eCards = electronicCardService.getECards(list);
        if( !CollectionUtils.isEmpty(eCards)){
            List<ElectronicCardRes> results = new ArrayList<ElectronicCardRes>();
            eCards.forEach(
                    eCard ->  {
                        ElectronicCardRes electronicCardRes = new ElectronicCardRes();
                        BeanUtils.copyProperties(eCard,electronicCardRes);
                        results.add(electronicCardRes);
                    }
            );
            return new RELResultUtils(results);
        }
        return RELResultUtils.success("请先绑定就诊人!");
    }


}
