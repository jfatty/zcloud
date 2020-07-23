package com.jfatty.zcloud.hospital.service;

import com.jfatty.zcloud.hospital.entity.HealthPatient;
import com.jfatty.zcloud.hospital.vo.WebRecordsMz;
import com.jfatty.zcloud.hospital.vo.WebRecordsZy;
import com.jfatty.zcloud.hospital.vo.WebVerifyUserinfo;

/**
 * 描述
 *
 * @author jfatty on 2020/5/21
 * @email jfatty@163.com
 */
public interface HealthPatientService {

    HealthPatient getHealthPatient(String brid,String sfzh);

    WebRecordsZy getWebRecordsZy(String brid) ;

    WebRecordsMz getWebRecordsMz(String brid) ;

    WebVerifyUserinfo verifyUserinfo(String phone) ;

}
