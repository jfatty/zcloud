package com.jfatty.zcloud.hospital.service.impl;

import com.jfatty.zcloud.hospital.datasource.TargetDataSource;
import com.jfatty.zcloud.hospital.entity.HealthPatient;
import com.jfatty.zcloud.hospital.mapper.HealthPatientMapper;
import com.jfatty.zcloud.hospital.service.HealthPatientService;
import com.jfatty.zcloud.hospital.vo.WebRecordsMz;
import com.jfatty.zcloud.hospital.vo.WebRecordsZy;
import com.jfatty.zcloud.hospital.vo.WebVerifyUserinfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述
 *
 * @author jfatty on 2020/5/21
 * @email jfatty@163.com
 */
@Slf4j
@Service
public class HealthPatientServiceImpl  implements HealthPatientService {


    @Autowired
    private HealthPatientMapper healthPatientMapper ;

    @TargetDataSource(name="mssql")
    @Override
    public HealthPatient getHealthPatient(String brid, String sfzh) {
        return healthPatientMapper.getHealthPatient(brid,sfzh);
    }

    @TargetDataSource(name="mssql")
    @Override
    public WebRecordsZy getWebRecordsZy(String brid) {
        return healthPatientMapper.getWebRecordsZy(brid);
    }

    @TargetDataSource(name="mssql")
    @Override
    public WebRecordsMz getWebRecordsMz(String brid) {
        return healthPatientMapper.getWebRecordsMz(brid);
    }


    @TargetDataSource(name="mssql")
    @Override
    public WebVerifyUserinfo verifyUserinfo(String phone) {
        return healthPatientMapper.verifyUserinfo(phone);
    }
}
