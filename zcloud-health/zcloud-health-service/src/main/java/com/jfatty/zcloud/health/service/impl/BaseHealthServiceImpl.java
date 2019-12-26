package com.jfatty.zcloud.health.service.impl;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.base.service.impl.BaseServiceImpl;
import com.jfatty.zcloud.health.service.BaseHealthService;
import lombok.extern.slf4j.Slf4j;

/**
 * 描述
 *
 * @author jfatty on 2019/12/26
 * @email jfatty@163.com
 */
@Slf4j
public class BaseHealthServiceImpl<T extends Model, M extends IBaseMapper<T>>   extends BaseServiceImpl<T,M> implements BaseHealthService<T> {



}
