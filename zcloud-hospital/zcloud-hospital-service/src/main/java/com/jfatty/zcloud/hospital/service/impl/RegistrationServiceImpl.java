package com.jfatty.zcloud.hospital.service.impl;

import com.jfatty.zcloud.hospital.datasource.TargetDataSource;
import com.jfatty.zcloud.hospital.mapper.RegistrationMapper;
import com.jfatty.zcloud.hospital.service.RegistrationService;
import com.jfatty.zcloud.hospital.vo.HosClazz;
import com.jfatty.zcloud.hospital.vo.HosDept;
import com.jfatty.zcloud.hospital.vo.HosHoliday;
import com.jfatty.zcloud.hospital.vo.PreRegistered;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/12/18
 * @email jfatty@163.com
 */
@Slf4j
@Service
public class RegistrationServiceImpl implements RegistrationService {


    @Autowired
    private RegistrationMapper registrationMapper ;

    @TargetDataSource(name="mssql")
    @Override
    public List<HosDept> getHosDepts(String openId, Integer openIdType) {
        return registrationMapper.getHosDepts(openId,openIdType);
    }

    @TargetDataSource(name="mssql")
    @Override
    public List<HosClazz> getHosClazzs(String openId, Integer openIdType) {
        return registrationMapper.getHosClazzs(openId,openIdType);
    }

    @TargetDataSource(name="mssql")
    @Override
    public HosHoliday checkHoliday(String openId, Integer openIdType, String checkTime) {
        return registrationMapper.checkHoliday(openId,openIdType,checkTime);
    }

    @TargetDataSource(name="mssql")
    @Override
    public PreRegistered preRegistered(String openId, Integer openIdType, String brid, String name, String sex, String idCard, String tel, String ksid, String preDate, String preTime) throws Exception {
        return registrationMapper.preRegistered(openId,openIdType,brid,name,sex,idCard,tel,ksid,preDate,preTime);
    }
}
