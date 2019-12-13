package com.jfatty.zcloud.hospital.service.impl;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.base.service.impl.BaseServiceImpl;
import com.jfatty.zcloud.hospital.service.BaseHospitalService;
import lombok.extern.slf4j.Slf4j;

/**
 * 描述
 *
 * @author jfatty on 2019/12/12
 * @email jfatty@163.com
 */
@Slf4j
public class BaseHospitalServiceImpl<T extends Model, M extends IBaseMapper<T>>   extends BaseServiceImpl<T,M> implements BaseHospitalService<T> {


}
