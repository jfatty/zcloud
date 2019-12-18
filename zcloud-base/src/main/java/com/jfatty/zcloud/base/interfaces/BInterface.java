package com.jfatty.zcloud.base.interfaces;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.jfatty.zcloud.base.dto.BaseDTO;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.base.utils.ResultUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 描述
 *
 * @author jfatty on 2019/11/5
 * @email jfatty@163.com
 */
public interface BInterface<T extends Model,P extends BaseDTO,R extends BaseDTO > {

    //列表 增删改查 其余接口子类自定义
    @ApiOperation(value="POST 携参 获取表格数据")
    @RequestMapping(value={"/table/list"},method = RequestMethod.POST)
    RELResultUtils<R> table(@RequestBody Map<String,Object> params) ;

    @ApiOperation(value="GET URL拼接参数 获取表格数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "v", value = "时间戳",dataType = "String",defaultValue = "20191101"),
            @ApiImplicitParam(name = "pageIndex", value = "页码",dataType = "Integer",defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数",dataType = "Integer",defaultValue = "10")
    })
    @RequestMapping(value={"/table/list"},method = RequestMethod.GET )
    RELResultUtils<R> table(@RequestParam(value = "v" , defaultValue = "20191101") String v ,
                            @RequestParam(value = "pageIndex" , defaultValue = "1" ) Integer pageIndex ,
                            @RequestParam(value = "pageSize" , defaultValue = "10") Integer pageSize) ;


    @ApiOperation(value="GET 获取列表数据")
    @RequestMapping(value={"/list"},method=RequestMethod.GET)
    ResultUtils list() ;

    @ApiOperation(value="POST 获取列表数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "v", value = "时间戳",dataType = "Long",defaultValue = "20191216")
    })
    @RequestMapping(value={"/list"},method=RequestMethod.POST)
    List<R>  list(@RequestParam(value = "v" , defaultValue = "20191216") Long v) ;

    @ApiOperation(value="新增")
    @RequestMapping(value={"/save"},method=RequestMethod.POST)
    ResultUtils save(@RequestBody P entity) ;

    @ApiOperation(value="回显/根据ID查询数据")
    @RequestMapping(value={"/edit"},method=RequestMethod.GET)
    ResultUtils view(@RequestParam(value = "id" , defaultValue = "AQAQAQ") String id ) ;

    @ApiOperation(value="修改")
    @RequestMapping(value={"/edit"},method=RequestMethod.POST)
    ResultUtils edit(@RequestBody P entity) ;

    @ApiOperation(value="删除")
    @RequestMapping(value={"/delete"},method=RequestMethod.POST)
    ResultUtils delete(@RequestBody Map<String,Object> params) ;
}
