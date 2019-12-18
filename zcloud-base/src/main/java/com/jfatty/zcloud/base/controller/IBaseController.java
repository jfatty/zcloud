package com.jfatty.zcloud.base.controller;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.jfatty.zcloud.base.dto.BaseDTO;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 描述
 *
 * @author jfatty on 2019/12/4
 * @email jfatty@163.com
 */
public interface IBaseController<T extends Model,P extends BaseDTO,R extends BaseDTO > {


    //列表 增删改查 其余接口子类自定义

    @RequestMapping(value={"/table/list"},method = RequestMethod.POST)
    RELResultUtils<R> table(@RequestBody Map<String,Object> params) ;


    @RequestMapping(value={"/table/list"},method = RequestMethod.GET )
    RELResultUtils<R> table(@RequestParam(value = "v" , defaultValue = "20191101") String v ,
                            @RequestParam(value = "pageIndex" , defaultValue = "1" ) Integer pageIndex ,
                            @RequestParam(value = "pageSize" , defaultValue = "10") Integer pageSize) ;


    @RequestMapping(value={"/list"},method=RequestMethod.GET)
    Object  list() ;

    @RequestMapping(value={"/list"},method=RequestMethod.POST)
    List<R> list(@RequestParam(value = "v" , defaultValue = "20191101") Long v) ;

    @RequestMapping(value={"/save"},method=RequestMethod.POST)
    Object save(@RequestBody P entity) ;

    @RequestMapping(value={"/edit"},method=RequestMethod.GET)
    Object view(@RequestParam(value = "id" , defaultValue = "AQAQAQ") String id ) ;

    @RequestMapping(value={"/edit"},method=RequestMethod.POST)
    Object edit(@RequestBody P entity) ;

    @RequestMapping(value={"/delete"},method=RequestMethod.POST)
    Object delete(@RequestBody Map<String,Object> params) ;


}
