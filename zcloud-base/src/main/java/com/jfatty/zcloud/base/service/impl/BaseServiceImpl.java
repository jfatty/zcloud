package com.jfatty.zcloud.base.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.base.service.BaseService;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import lombok.extern.slf4j.Slf4j;

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
public class BaseServiceImpl<T extends Model, M extends BaseMapper<T>> extends ServiceImpl<M, T> implements BaseService<T> {

    protected IBaseMapper<T> baseMapper;

    public void setBaseMapper(IBaseMapper<T> baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Override
    public RELResultUtils<T> getTable(String v, Integer pageIndex, Integer pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        //一定要注意起始数据是从第几条开始的
        map.put("pageIndex", (pageIndex - 1) * pageSize);
        map.put("pageSize", pageSize);
        List<T> list = baseMapper.getTable(map);
        Integer count = baseMapper.getTableCount(map);
        if(CollectionUtils.isNotEmpty(list))
            return new RELResultUtils<T>(200,RELResultUtils.SUCCESS, list, count);
        return new RELResultUtils<T>(400, "没有查询到数据!", list);
    }
}
