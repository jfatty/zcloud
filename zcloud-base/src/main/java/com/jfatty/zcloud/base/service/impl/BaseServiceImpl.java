package com.jfatty.zcloud.base.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.base.service.BaseService;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.base.utils.UUIDGenerator;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
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

    /**
     * 通用给实体类获取
     * ID属性
     * @param entity 传入poji实体
     * @return 返回id
     * @throws Exception 抛出异常
     */
    private String getId(T entity) throws Exception {
        String mname = "getId" ;
        Method m = entity.getClass().getMethod(mname, null);
        String id = (m.invoke(entity, null)).toString();
        return id;
    }

    /**
     * 通用给实体类设置
     * ID属性
     * @param entity  传入poji实体
     * @return  设置id属性后返回实体pojo
     * @throws Exception 抛出异常
     */
    private T setId(T entity) throws Exception {
        String value = UUIDGenerator.uuid() ;
        String mname = "setId" ;
        log.info("类:"+entity.getClass().getName()+" 当前生成的ID为:"+value);
        Method m = entity.getClass().getMethod(mname,String.class);
        m.invoke(entity, value);
        return entity;
    }


    private T setCreateTime(T entity) {
        LocalDateTime createTime = LocalDateTime.now();
        String mname = "setCreateTime" ;
        log.info("类:[{}] 当前生成的创建时间:[{}]",entity.getClass().getName(),createTime);
        try {
            Method m = entity.getClass().getMethod(mname,LocalDateTime.class);
            try {
                m.invoke(entity, createTime);
            } catch (IllegalAccessException e) {
                log.error("类:[{}] 设置创建时间:[{}]失败 属性有些权限保护",entity.getClass().getName(),createTime);
            } catch (InvocationTargetException e) {
                log.error("类:[{}] 设置创建时间:[{}]失败 没有找到目标对象",entity.getClass().getName(),createTime);
            }
        } catch (NoSuchMethodException e) {
            log.error("类:[{}] 设置创建时间:[{}]失败 没有找到对应方法",entity.getClass().getName(),createTime);
        }
        return entity;
    }

    private T setUpdateTime(T entity) {
        LocalDateTime updateTime = LocalDateTime.now();
        String mname = "setUpdateTime" ;
        log.info("类:[{}] 当前生成的更新时间:[{}]",entity.getClass().getName(),updateTime);
        try {
            Method m = entity.getClass().getMethod(mname,LocalDateTime.class);
            try {
                m.invoke(entity, updateTime);
            } catch (IllegalAccessException e) {
                log.error("类:[{}] 设置更新时间:[{}]失败 属性有些权限保护",entity.getClass().getName(),updateTime);
            } catch (InvocationTargetException e) {
                log.error("类:[{}] 设置更新时间:[{}]失败 没有找到目标对象",entity.getClass().getName(),updateTime);
            }
        } catch (NoSuchMethodException e) {
            log.error("类:[{}] 设置更新时间:[{}]失败 没有找到对应方法",entity.getClass().getName(),updateTime);
        }
        return entity;
    }

    @Override
    public boolean save(T entity, Map<String, Object> params) throws Exception {
        /**
         * 首先判断id是否存在
         */
        entity = this.setId(entity) ;
        entity = this.setCreateTime(entity) ;
        return super.save(entity);
    }

    @Override
    public String saveId(T entity) throws Exception {
        /**
         * 首先判断id是否存在
         */
        entity = this.setId(entity) ;
        entity = this.setCreateTime(entity) ;
        super.save(entity);
        return getId(entity);
    }

    @Override
    public boolean updateById(T entity) {
        entity = this.setUpdateTime(entity);
        return super.updateById(entity);
    }

    @Override
    public RELResultUtils<T> getTable(String v, Integer pageIndex, Integer pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        return  getTable(v,pageIndex,pageSize,map) ;
    }

    @Override
    public RELResultUtils<T> getTable(String v, Integer pageIndex, Integer pageSize, Map<String, Object> params) {
        Map<String, Object> map = new HashMap<String, Object>();
        for ( Map.Entry<String, Object> entry : params.entrySet() ) {
            log.error(" ===============================>   根据 Map 参数分页查询  参数名 key: " + entry.getKey() + " 参数值 value: " + entry.getValue());
            map.put(entry.getKey(), entry.getValue());
        }
        //一定要注意起始数据是从第几条开始的
        map.put("pageIndex", (pageIndex - 1) * pageSize);
        map.put("pageSize", pageSize);
        List<T> list = baseMapper.getTable(map);
        Integer count = baseMapper.getTableCount(map);
        if (list != null && list.size() > 0) {
            return new RELResultUtils<T>(200,RELResultUtils.SUCCESS, list, count);
        }
        return new RELResultUtils<T>(400, "没有查询到数据!", list);
    }
}
