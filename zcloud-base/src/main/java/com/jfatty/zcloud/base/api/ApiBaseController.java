package com.jfatty.zcloud.base.api;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.base.service.BaseService;

import java.util.List;
import java.util.Map;

/**
 * 描述
 *
 * @author jfatty on 2019/11/5
 * @email jfatty@163.com
 */

public abstract class ApiBaseController<T extends Model>  implements BInterface<T> {


    protected BaseService<T> baseService ;

    public void setBaseService(BaseService<T> baseService) {
        this.baseService = baseService;
    }

    @Override
    public List<T> table(String v, Integer pageIndex, Integer pageSize) {
        return baseService.getTable(v,pageIndex,pageSize);
    }

    @Override
    public List<T> list() {
        return baseService.list();
    }

    @Override
    public Object save(T entity) {
        return baseService.save(entity);
    }

    @Override
    public Object view(String id) {
        return baseService.getById(id);
    }

    @Override
    public Object edit(T entity) {
        return baseService.updateById(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        List<String> ids = (List<String>)params.get("ids") ;
        return baseService.removeByIds(ids) ;
    }
}



