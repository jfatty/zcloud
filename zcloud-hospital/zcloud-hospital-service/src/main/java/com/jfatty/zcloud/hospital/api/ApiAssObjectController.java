package com.jfatty.zcloud.hospital.api;


import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.base.utils.StringUtils;
import com.jfatty.zcloud.hospital.entity.AssObject;
import com.jfatty.zcloud.hospital.interfaces.IAssObject;
import com.jfatty.zcloud.hospital.req.AssObjectReq;
import com.jfatty.zcloud.hospital.res.AssObjectRes;
import com.jfatty.zcloud.hospital.service.AssObjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 量表关联对象表 前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2020-06-03
 */
@Api(tags = "量表关联对象 API" ,value = "量表关联对象 ")
@RestController
@RequestMapping("/api/assObject")
public class ApiAssObjectController extends ApiBaseHospitalController<AssObject,AssObjectReq,AssObjectRes> implements IAssObject {


    @Autowired
    private AssObjectService assObjectService ;

    @Autowired
    public void setAssObjectService(AssObjectService assObjectService) {
        super.setBaseService(assObjectService);
        this.assObjectService = assObjectService;
    }

    @ApiOperation(value="根据量表ID查询 量表管理关联对象列表 进入每个量表操作页面首先要调用此接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "surveyId", value = "量表ID",dataType = "String",defaultValue = "4028fe81726dc6e101726dcb39e70000")
    })
    @RequestMapping(value="/getAssObjects", method=RequestMethod.GET)
    public RELResultUtils<AssObjectRes> getAssObjects(@RequestParam(value = "surveyId" , defaultValue = "" ) String surveyId  ) {
        //surveyId为空 直接返回 提示信息
        if (StringUtils.isEmptyOrBlank(surveyId) ) {
            return  RELResultUtils._509("surveyId不能为空") ;
        }
        //AssObjectRes
        List<AssObject> assObjectList = assObjectService.getAssObjects(surveyId);
        if (CollectionUtils.isEmpty(assObjectList) ) {
            return  RELResultUtils._506("未查询到对应关联对象") ;
        }

        List<AssObjectRes> assObjectRes = new ArrayList<AssObjectRes>();
        for ( AssObject assObject : assObjectList) {
            AssObjectRes assObjectR = new AssObjectRes() ;
            BeanUtils.copyProperties(assObject,assObjectR);
            assObjectRes.add(assObjectR);
        }
        return new RELResultUtils(assObjectRes);
    }





}

