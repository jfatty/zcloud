package com.jfatty.zcloud.base.api;


import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.base.service.BaseService;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.base.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

/**
 * 描述
 *
 * @author jfatty on 2019/11/5
 * @email jfatty@163.com
 */
@Slf4j
public abstract class ApiBaseController<T extends Model>  implements BInterface<T> {


    protected BaseService<T> baseService ;

    public void setBaseService(BaseService<T> baseService) {
        this.baseService = baseService;
    }

    @Override
    public RELResultUtils<T> table(Map<String, Object> params) {
        Integer pageIndex = (Integer) params.get("pageIndex");
        Integer pageSize = (Integer) params.get("pageSize");
        return baseService.getTable("",pageIndex,pageSize,params);
    }

    @Override
    public RELResultUtils<T> table(String v, Integer pageIndex, Integer pageSize) {
        return baseService.getTable(v,pageIndex,pageSize);
    }

    @Override
    public List<T> list(Long v) {
        return baseService.list();
    }

    @Override
    public ResultUtils list() {
        List<T> list = baseService.list();
        if(CollectionUtils.isNotEmpty(list))
            return ResultUtils.ok(list);
        return ResultUtils.build(400, "没有查询到数据");
    }

    @Override
    public ResultUtils save(T entity) {
        try {
            if(baseService.save(entity,null))
                return ResultUtils.build(200, "SUCCESS") ;
            return ResultUtils.build(500, "FAILED") ;
        } catch ( Exception e ) {
            log.error( "保存异常 异常信息为 : [{}]" , e.getMessage() );
        }
        return ResultUtils.build(500, "网络异常请稍后重试") ;
    }

    @Override
    public ResultUtils view(String id) {
        T obj = baseService.getById(id);
        if( obj != null )
            return ResultUtils.ok(obj);
        return ResultUtils.build(400, "没有查询到数据");
    }

    @Override
    public ResultUtils edit(T entity) {
        if(baseService.updateById(entity))
            return ResultUtils.build(200, "SUCCESS") ;
        return ResultUtils.build(500, "修改出现异常") ;
    }

    @Override
    public ResultUtils delete(Map<String, Object> params) {
        List<String> ids = (List<String>)params.get("ids") ;
        if( baseService.removeByIds(ids) )
            return ResultUtils.build(200, "SUCCESS") ;
        return ResultUtils.build(500, "网络异常请稍后重试") ;
    }

}



