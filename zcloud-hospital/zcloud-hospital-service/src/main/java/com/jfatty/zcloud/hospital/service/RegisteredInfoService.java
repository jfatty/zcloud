package com.jfatty.zcloud.hospital.service;

import com.jfatty.zcloud.hospital.entity.RegisteredInfo;
import com.jfatty.zcloud.hospital.vo.AppointmentRecord;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/12/18
 * @email jfatty@163.com
 */
public interface RegisteredInfoService {

    List<RegisteredInfo> getRegisteredInfo(String name, String idCard, String dateTime);

    List<AppointmentRecord> appointmentRecord(String openId, Integer openIdType, String brid, String beginTime, String endTime);
}
