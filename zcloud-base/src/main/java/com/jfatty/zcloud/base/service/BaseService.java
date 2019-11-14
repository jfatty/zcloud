package com.jfatty.zcloud.base.service;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jfatty.zcloud.base.utils.RELResultUtils;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/11/5
 * @email jfatty@163.com
 */
public interface BaseService<T  extends Model> extends IService<T> {


    RELResultUtils<T> getTable(String v, Integer pageIndex, Integer pageSize);


}
