package com.jfatty.zcloud.hospital.mapper;


import com.jfatty.zcloud.hospital.entity.HealthPatient;
import com.jfatty.zcloud.hospital.vo.WebRecordsMz;
import com.jfatty.zcloud.hospital.vo.WebRecordsZy;
import com.jfatty.zcloud.hospital.vo.WebVerifyUserinfo;
import org.apache.ibatis.annotations.Param;

/**
 * 描述 健康卡病人信息
 *
 * @author jfatty on 2020/5/21
 * @email jfatty@163.com
 */
public interface HealthPatientMapper {


    HealthPatient getHealthPatient(@Param("brid") String brid, @Param("sfzh")  String sfzh);

    WebRecordsZy getWebRecordsZy(@Param("brid") String brid);

    WebRecordsMz getWebRecordsMz(@Param("brid") String brid);

    WebVerifyUserinfo verifyUserinfo(@Param("phone") String phone);
}
