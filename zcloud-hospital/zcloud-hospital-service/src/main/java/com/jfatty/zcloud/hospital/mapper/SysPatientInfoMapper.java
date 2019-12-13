package com.jfatty.zcloud.hospital.mapper;


import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.hospital.entity.SysPatientInfo;

import java.util.List;
import java.util.Map;

/**
 * 描述
 *
 * @author jfatty on 2019/12/12
 * @email jfatty@163.com
 */

public interface SysPatientInfoMapper extends IBaseMapper<SysPatientInfo> {


    Integer getTableCount(Map<String,Object> map);

    List<Map<String,Object>> getMap(Map<String,Object> map);
}
