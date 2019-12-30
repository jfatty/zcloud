package com.jfatty.zcloud.system.api;

import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.base.utils.ResultUtils;
import com.jfatty.zcloud.system.entity.IdentityFile;
import com.jfatty.zcloud.system.req.IdentityFileReq;
import com.jfatty.zcloud.system.res.IdentityFileRes;
import com.jfatty.zcloud.system.service.IdentityFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
@Api(tags = "自定义系统身份证文件API" ,value = "自定义系统身份证文件")
@Slf4j
@RestController
@RequestMapping(value={"/api/cusIdentityFile"})
public class ApiCusIdentityFileController {


    @Autowired
    private IdentityFileService identityFileService ;


    @ApiOperation(value="获取评估量表或者调查问卷表格数据",notes="获取评估量表或者调查问卷表格数据",  position = 0 )
    @RequestMapping(value={"/table/list"},method = RequestMethod.GET )
    RELResultUtils<IdentityFileRes> table(@RequestParam(value = "v" , defaultValue = "20191101") String v ,
                                          @RequestParam(value = "pageIndex" , defaultValue = "1" ) Integer pageIndex ,
                                          @RequestParam(value = "pageSize" , defaultValue = "10") Integer pageSize) {
        RELResultUtils<IdentityFile> ss = identityFileService.getTable("",pageIndex,pageSize);
        RELResultUtils<IdentityFileRes> res = new RELResultUtils<IdentityFileRes>();
        BeanUtils.copyProperties(ss,res);
        return res ;
    }

    @ApiOperation(value = "添加项目", notes = "添加项目管理", nickname = "liukx")
    @RequestMapping(value={"/save"},method=RequestMethod.POST)
    ResultUtils save(@RequestBody IdentityFileReq entity) {
        IdentityFile identityFile = new IdentityFile();
        try {
            identityFile.setAvatar(entity.getAvatar().getBytes());
            identityFile.setEmblem(entity.getEmblem().getBytes());
            if(identityFileService.save(identityFile))
                return ResultUtils.build(200, "SUCCESS") ;
            return ResultUtils.build(500, "FAILED") ;
        } catch ( Exception e ) {
            log.error( "保存异常 异常信息为 : [{}]" , e.getMessage() );
        }
        return ResultUtils.build(500, "网络异常请稍后重试") ;
    }


}
