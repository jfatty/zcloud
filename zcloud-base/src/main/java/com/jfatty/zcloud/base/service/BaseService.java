package com.jfatty.zcloud.base.service;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/11/5
 * @email jfatty@163.com
 */
public interface BaseService<T  extends Model> extends IService<T> {


    List<T> getTable(String v, Integer pageIndex, Integer pageSize);


}
