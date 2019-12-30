package com.jfatty.zcloud.system.api;


import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.base.utils.StringUtils;
import com.jfatty.zcloud.system.entity.AreaCn;
import com.jfatty.zcloud.system.interfaces.IAreaCn;
import com.jfatty.zcloud.system.req.AreaCnReq;
import com.jfatty.zcloud.system.res.AreaCnRes;
import com.jfatty.zcloud.system.service.AreaCnService;
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


    @ApiOperation(value="POST 参数查询 层级列表数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parentId", value = "父级行政地区ID",dataType = "String",defaultValue = "748344"),
            @ApiImplicitParam(name = "level", value = "行政地区 级别0-4",dataType = "Integer",defaultValue = "0",required = true,allowableValues = "0,1,2,3,4"),
            @ApiImplicitParam(name = "name", value = "行政地区 名称",dataType = "String",defaultValue = "湖北省"),
            @ApiImplicitParam(name = "shortName", value = "行政地区 简称",dataType = "String",defaultValue = "湖北")
    })
    @RequestMapping(value={"/level/list"},method = RequestMethod.POST )
    public RELResultUtils<AreaCnRes> levelList(@RequestParam(value = "parentId" , defaultValue = "748344") String parentId ,
                            @RequestParam(value = "level" , defaultValue = "0" ) Integer level ,
                            @RequestParam(value = "name" , defaultValue = "湖北省") String name ,
                            @RequestParam(value = "shortName" , defaultValue = "湖北") String shortName) {

        if (StringUtils.isEmptyOrBlank(parentId))
            parentId = "0";
        name = StringUtils.likeStrSQL(name);
        shortName = StringUtils.likeStrSQL(shortName);
        List<AreaCn> areaCns = areaCnService.getLevelList(parentId,level,name,shortName);
        if (CollectionUtils.isEmpty(areaCns))
            return RELResultUtils._506("没有查询到行政地区有关数据");
        List<AreaCnRes> areaCnReses = new ArrayList<AreaCnRes>();
        for (AreaCn areaCn : areaCns) {
            AreaCnRes areaCnR = new AreaCnRes();
            BeanUtils.copyProperties(areaCn,areaCnR);
            areaCnReses.add(areaCnR);
        }
        return  new RELResultUtils(areaCnReses);

    }



}

