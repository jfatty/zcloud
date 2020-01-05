package com.jfatty.zcloud.hospital.mapper;

import com.jfatty.zcloud.hospital.entity.RegisteredInfo;
import com.jfatty.zcloud.hospital.vo.AppointmentRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/12/18
 * @email jfatty@163.com
 */
public interface RegisteredInfoMapper {


    List<RegisteredInfo> getRegisteredInfo(@Param("name") String name, @Param("idCard")  String idCard, @Param("dtme")  String dtme);

    List<AppointmentRecord> appointmentRecord(@Param("openId") String openId,@Param("openIdType")  Integer openIdType,@Param("brid")  String brid,@Param("beginTime")  String beginTime,@Param("endTime")  String endTime);
}
