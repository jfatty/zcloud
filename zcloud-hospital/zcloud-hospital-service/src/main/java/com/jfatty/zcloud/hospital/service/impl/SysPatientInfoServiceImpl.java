package com.jfatty.zcloud.hospital.service.impl;

import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.hospital.datasource.TargetDataSource;
import com.jfatty.zcloud.hospital.entity.SysPatientInfo;
import com.jfatty.zcloud.hospital.mapper.SysPatientInfoMapper;
import com.jfatty.zcloud.hospital.service.SysPatientInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述
 *
 * @author jfatty on 2019/12/12
 * @email jfatty@163.com
 */
@Slf4j
@Service
public class SysPatientInfoServiceImpl extends BaseHospitalServiceImpl<SysPatientInfo, SysPatientInfoMapper> implements SysPatientInfoService {

    private SysPatientInfoMapper sysPatientInfoMapper ;

    @Autowired
    public void setSysPatientInfoMapper(SysPatientInfoMapper sysPatientInfoMapper) {
        super.setBaseMapper(sysPatientInfoMapper);
        this.sysPatientInfoMapper = sysPatientInfoMapper;
    }

    @TargetDataSource(name="hfxzxyy")
    @Override
    public RELResultUtils<SysPatientInfo> getTable(String v, Integer pageIndex, Integer pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        return  getTable(v,pageIndex,pageSize,map) ;
    }

    @TargetDataSource(name="hfxzxyy")
    @Override
    public RELResultUtils<SysPatientInfo> getTable(String v, Integer pageIndex, Integer pageSize, Map<String, Object> params) {
        Map<String, Object> map = new HashMap<String, Object>();
        for ( Map.Entry<String, Object> entry : params.entrySet() ) {
            log.error(" ===============================>   根据 Map 参数分页查询  参数名 key: " + entry.getKey() + " 参数值 value: " + entry.getValue());
            map.put(entry.getKey(), entry.getValue());
        }
        //一定要注意起始数据是从第几条开始的
        map.put("pageIndex", pageIndex * pageSize);
        map.put("pageSize", pageSize);
        List<SysPatientInfo> list = baseMapper.getTable(map);
        Integer count = baseMapper.getTableCount(map);
        if (list != null && list.size() > 0) {
            return new RELResultUtils<SysPatientInfo>(200,RELResultUtils.SUCCESS, list, count);
        }
        return new RELResultUtils<SysPatientInfo>(400, "没有查询到数据!", list);
    }

    @TargetDataSource(name="hfxzxyy")
    @Override
    public List<Map<String, Object>> getMap(Integer pageIndex, Integer pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        //一定要注意起始数据是从第几条开始的
        map.put("pageIndex", pageIndex * pageSize);
        map.put("pageSize", pageSize);
        Integer count = sysPatientInfoMapper.getTableCount(map);
        System.out.println("数据条数:" + count);
        return sysPatientInfoMapper.getMap(map);
    }
}
