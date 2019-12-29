package com.jfatty.zcloud.auth.service.impl;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.jfatty.zcloud.auth.service.BaseAuthService;
import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.base.service.impl.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * 描述
 *
 * @author jfatty on 2019/12/27
 * @email jfatty@163.com
 */
@Slf4j
public class BaseAuthServiceImpl<T extends Model, M extends IBaseMapper<T>>   extends BaseServiceImpl<T,M> implements BaseAuthService<T> {

}
