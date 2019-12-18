package com.jfatty.zcloud.base.api;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.jfatty.zcloud.base.dto.BaseDTO;
import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.base.service.BaseService;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.base.utils.ResultUtils;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述
 *
 * @author jfatty on 2019/11/5
 * @email jfatty@163.com
 */
@Slf4j
public abstract class ApiBaseController<T extends Model,P extends BaseDTO,R extends BaseDTO >  implements BInterface<T,P,R> {

    Class<T> clazz;

    Class<P> clapp;

    Class<R> clarr;

    protected BaseService<T> baseService ;

    public void setBaseService(BaseService<T> baseService) {
        this.baseService = baseService;
    }

    public ApiBaseController() {
       ParameterizedType pt =  (ParameterizedType)this.getClass().getGenericSuperclass();//ApiBaseController<User>
       clazz = (Class<T>)pt.getActualTypeArguments()[0];
       clapp = (Class<P>)pt.getActualTypeArguments()[1];
       clarr = (Class<R>)pt.getActualTypeArguments()[2];
//        Type[] tys =  pt.getActualTypeArguments();
//        for (Type t:tys){
//            log.error(t.getTypeName());
//        }
    }

    @Override
    public RELResultUtils<R> table(Map<String, Object> params) {
        Integer pageIndex = (Integer) params.get("pageIndex");
        Integer pageSize = (Integer) params.get("pageSize");
        RELResultUtils<T> resultT = baseService.getTable("",pageIndex,pageSize,params);
        List<R> listR = new ArrayList<R>();
        resultT.getList().forEach(
                lit -> {
                    R r = null;
                    try {
                        r = clarr.newInstance();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    BeanUtils.copyProperties(lit,r);
                    listR.add(r);
                }
        );
        RELResultUtils<R> resultR = new RELResultUtils<R>();
        BeanUtils.copyProperties(resultT,resultR);
        resultR.setList(listR);
        return resultR ;
    }

    @Override
    public RELResultUtils<R> table(String v, Integer pageIndex, Integer pageSize) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("v",v);
        params.put("pageIndex",pageIndex);
        params.put("pageSize",pageSize);
        return table(params);
    }

    @Override
    public List<R> list(Long v) {
        List<R> list = new ArrayList<R>();
        List<T> listT = baseService.list() ;
        listT.forEach(
                li -> {
                    R r = null;
                    try {
                        r = clarr.newInstance();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    BeanUtils.copyProperties(li,r);
                    list.add(r);
                }
        );
        return list ;
    }

    @Override
    public ResultUtils list() {
        List<R> listR = list(System.currentTimeMillis());
        if(CollectionUtils.isNotEmpty(listR))
            return ResultUtils.ok(listR);
        return ResultUtils.build(400, "没有查询到数据");
    }


    @Override
    public ResultUtils save(P entity) {
        try {
            T ent = clazz.newInstance() ;
            BeanUtils.copyProperties(entity,ent);
            if(baseService.save(ent,null))
                return ResultUtils.build(200, "SUCCESS") ;
            return ResultUtils.build(500, "FAILED") ;
        } catch ( Exception e ) {
            log.error( "保存异常 异常信息为 : [{}]" , e.getMessage() );
        }
        return ResultUtils.build(500, "网络异常请稍后重试") ;
    }

    @Override
    public ResultUtils view(String id) {
        try {
            T obj = baseService.getById(id);
            R result = clarr.newInstance() ;
            BeanUtils.copyProperties(obj,result);
            if( obj != null )
                return ResultUtils.ok(result);
            return ResultUtils.build(400, "没有查询到数据");
        } catch ( Exception e ) {
            log.error( "单数据查询异常 异常信息为 : [{}]" , e.getMessage() );
        }
        return ResultUtils.build(500, "网络异常请稍后重试") ;
    }

    @Override
    public ResultUtils edit(P entity) {
        try {
            T ent = clazz.newInstance() ;
            BeanUtils.copyProperties(entity,ent);
            if(baseService.updateById(ent))
                return ResultUtils.build(200, "SUCCESS") ;
            return ResultUtils.build(500, "修改出现异常") ;
        } catch ( Exception e ) {
            log.error( "更新异常 异常信息为 : [{}]" , e.getMessage() );
        }
        return ResultUtils.build(500, "网络异常请稍后重试") ;

    }

    @Override
    public ResultUtils delete(Map<String, Object> params) {
        List<String> ids = (List<String>)params.get("ids") ;
        if( baseService.removeByIds(ids) )
            return ResultUtils.build(200, "SUCCESS") ;
        return ResultUtils.build(500, "网络异常请稍后重试") ;
    }

}



