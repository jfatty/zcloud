package com.jfatty.zcloud.base.interfaces;

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
public interface BInterface<T> {

    //列表 增删改查 其余接口子类自定义

    @RequestMapping(value={"/table/list"})
    List<T> table(@RequestParam(value = "v" , defaultValue = "20191101") String v ,
                  @RequestParam(value = "pageIndex" , defaultValue = "1" ) Integer pageIndex ,
                  @RequestParam(value = "pageSize" , defaultValue = "10") Integer pageSize) ;

    @RequestMapping(value={"/list"})
    List<T>  list() ;

    @RequestMapping(value={"/save"},method=RequestMethod.POST)
    Object save(@RequestBody T entity) ;

    @RequestMapping(value={"/edit"},method=RequestMethod.GET)
    Object view(@RequestParam(value = "id" , defaultValue = "AQAQAQ") String id ) ;

    @RequestMapping(value={"/edit"},method=RequestMethod.POST)
    Object edit(@RequestBody T entity) ;

    @RequestMapping(value={"/delete"},method=RequestMethod.POST)
    Object delete(@RequestBody Map<String,Object> params) ;
}
