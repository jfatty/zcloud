package com.jfatty.zcloud.hospital.service.impl;

import com.jfatty.zcloud.hospital.datasource.TargetDataSource;
import com.jfatty.zcloud.hospital.mapper.MedicalCheckListMapper;
import com.jfatty.zcloud.hospital.service.MedicalCheckListService;
import com.jfatty.zcloud.hospital.vo.WebCyfyqd;
import com.jfatty.zcloud.hospital.vo.WebCyqdList;
import com.jfatty.zcloud.hospital.vo.WebZyrqd;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述 住/出院清单查看
 *
 * @author jfatty on 2020/7/15
 * @email jfatty@163.com
 */
@Slf4j
@Service
public class MedicalCheckListServiceImpl implements MedicalCheckListService {

    @Autowired
    private MedicalCheckListMapper medicalCheckListMapper ;


    @TargetDataSource(name="mssql")
    @Override
    public List<WebZyrqd> getWebZyrqd(String openId, Integer openIdType, String brid, String startTime, String endTime) {
        return medicalCheckListMapper.getWebZyrqd(openId,openIdType,brid,startTime,endTime,"","","");
    }

    @TargetDataSource(name="mssql")
    @Override
    public List<WebCyqdList> getWebCyqdList(String openId, Integer openIdType, String brid) {
        return medicalCheckListMapper.getWebCyqdList(openId,openIdType,brid,"","","");
    }

    @TargetDataSource(name="mssql")
    @Override
    public List<WebCyfyqd> getWebCyfyqd(String openId, Integer openIdType, String zybh) {
        return medicalCheckListMapper.getWebCyfyqd(openId,openIdType,zybh,"","","");
    }
}
