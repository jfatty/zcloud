package com.jfatty.zcloud.system.service.impl;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.base.service.impl.BaseServiceImpl;
import com.jfatty.zcloud.system.service.BaseSystemService;
import lombok.extern.slf4j.Slf4j;


/**
 * 描述
 *
 * @author jfatty on 2019/11/1
 * @email jfatty@163.com
 */
@Slf4j
public class BaseSystemServiceImpl<T extends Model, M extends IBaseMapper<T>>   extends BaseServiceImpl<T,M> implements BaseSystemService<T> {



}
