package com.jfatty.zcloud.hospital.service.impl;

import com.jfatty.zcloud.hospital.datasource.TargetDataSource;
import com.jfatty.zcloud.hospital.mapper.ElectronicDocMapper;
import com.jfatty.zcloud.hospital.service.ElectronicDocService;
import com.jfatty.zcloud.hospital.vo.ElectronicDoc;
import com.jfatty.zcloud.hospital.vo.ElectronicDocDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
@Slf4j
@Service
public class ElectronicDocServiceImpl implements ElectronicDocService {

    @Autowired
    private ElectronicDocMapper electronicDocMapper ;

    @TargetDataSource(name="mssql")
    @Override
    public List<ElectronicDoc> getElectronicDocList(String openId, Integer openIdType, String startTime, String endTime) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("openId", openId);
        map.put("openIdType", openIdType);
        map.put("startTime", startTime);
        map.put("endTime", endTime);
        return electronicDocMapper.getElectronicDocList(map);
    }

    @TargetDataSource(name="mssql")
    @Override
    public List<ElectronicDocDetail> getElectronicDocDetail(String openId, Integer openIdType, String brbh, String sfh) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("openId", openId);
        map.put("openIdType", openIdType);
        map.put("brbh", brbh);
        map.put("sfh", sfh);
        return electronicDocMapper.getElectronicDocDetail(map);
    }
}
