package com.jfatty.zcloud.hospital.service.impl;

import com.jfatty.zcloud.hospital.datasource.TargetDataSource;
import com.jfatty.zcloud.hospital.entity.RegisteredInfo;
import com.jfatty.zcloud.hospital.mapper.RegisteredInfoMapper;
import com.jfatty.zcloud.hospital.service.RegisteredInfoService;
import com.jfatty.zcloud.hospital.vo.AppointmentRecord;
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
public class RegisteredInfoServiceImpl implements RegisteredInfoService {

    @Autowired
    private RegisteredInfoMapper registeredInfoMapper ;

    @TargetDataSource(name="mssql")
    @Override
    public List<RegisteredInfo> getRegisteredInfo(String name, String idCard, String dtme) {
        return registeredInfoMapper.getRegisteredInfo(name,idCard,dtme);
    }

    @TargetDataSource(name="mssql")
    @Override
    public List<AppointmentRecord> appointmentRecord(String openId, Integer openIdType, String brid, String beginTime, String endTime) {
        return registeredInfoMapper.appointmentRecord(openId,openIdType,brid,beginTime,endTime);
    }
}
