package com.jfatty.zcloud.base.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.base.service.BaseService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

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
    public List<T> getTable(String v, Integer pageIndex, Integer pageSize) {
        return null;
    }
}
