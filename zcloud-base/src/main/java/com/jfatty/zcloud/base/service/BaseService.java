package com.jfatty.zcloud.base.service;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jfatty.zcloud.base.utils.RELResultUtils;

import java.util.List;
import java.util.Map;

/**
 * 描述
 *
 * @author jfatty on 2019/11/5
 * @email jfatty@163.com
 */
public interface BaseService<T  extends Model> extends IService<T> {

    boolean save(T entity, Map<String,Object> params) throws Exception ;

    RELResultUtils<T> getTable(String v, Integer pageIndex, Integer pageSize);

    /**
     * 描述 页面表格数据获取
     * @param v
     * @param pageIndex
     * @param pageSize
     * @param  params  封装参数
     * @return
     */
    RELResultUtils<T> getTable(String v, Integer pageIndex, Integer pageSize, Map<String, Object> params);

}
