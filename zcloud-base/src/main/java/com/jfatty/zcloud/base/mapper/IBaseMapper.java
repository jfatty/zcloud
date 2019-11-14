package com.jfatty.zcloud.base.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.util.List;
import java.util.Map;

/**
 * 描述
 *
 * @author jfatty on 2019/11/7
 * @email jfatty@163.com
 */
public interface IBaseMapper<T extends Model> extends BaseMapper<T> {

    /**
     * 描述 获取表格数据
     * @author jfatty
     * 创建时间：2018年5月6日
     */
    List<T> getTable(Map<String, Object> map);

    /**
     * 描述  获取表格数据条数
     * @author jfatty
     * 创建时间：2018年5月6日
     */
    Integer getTableCount(Map<String, Object> map);

}
