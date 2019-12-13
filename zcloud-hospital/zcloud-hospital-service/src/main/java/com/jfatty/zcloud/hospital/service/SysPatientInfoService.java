package com.jfatty.zcloud.hospital.service;


import com.jfatty.zcloud.hospital.entity.SysPatientInfo;

import java.util.List;
import java.util.Map;

/**
 * 描述
 *
 * @author jfatty on 2019/12/12
 * @email jfatty@163.com
 */
public interface SysPatientInfoService extends BaseHospitalService<SysPatientInfo> {

    List<Map<String,Object>> getMap(Integer pageIndex, Integer pageSize);

}
