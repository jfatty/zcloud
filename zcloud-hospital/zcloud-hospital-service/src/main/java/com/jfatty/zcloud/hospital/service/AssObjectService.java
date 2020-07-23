package com.jfatty.zcloud.hospital.service;


import com.jfatty.zcloud.hospital.entity.AssObject;

import java.util.List;

/**
 * <p>
 * 量表关联对象表 服务类
 * </p>
 *
 * @author jfatty
 * @since 2020-06-03
 */
public interface AssObjectService extends BaseHospitalService<AssObject> {

    List<AssObject> getAssObjects(String surveyId);
}
