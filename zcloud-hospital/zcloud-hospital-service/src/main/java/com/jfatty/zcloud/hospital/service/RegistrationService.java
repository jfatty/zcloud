package com.jfatty.zcloud.hospital.service;

import com.jfatty.zcloud.hospital.vo.*;

import java.util.List;

/**
 * 描述 门诊挂号
 *
 * @author jfatty on 2019/12/18
 * @email jfatty@163.com
 */
public interface RegistrationService {

    /**
     * 获取医院 可预约挂号科室信息
     * @param openId
     * @param openIdType
     * @return
     */
    List<HosDept> getHosDepts(String openId, Integer openIdType);

    /**
     * 获取医院 值班班次 信息
     * @param openId
     * @param openIdType
     * @return
     */
    List<HosClazz> getHosClazzs(String openId, Integer openIdType);

    /**
     * 检验用户选择的日期是否为节假日
     * @param openId
     * @param openIdType
     * @param checkTime
     * @return
     */
    HosHoliday checkHoliday(String openId, Integer openIdType, String checkTime);

    /**
     * 预约挂号
     * @param openId
     * @param openIdType
     * @param brid
     * @param name
     * @param sex
     * @param idCard
     * @param tel
     * @param ksid
     * @param preDate
     * @param preTime
     * @return
     */
    PreRegistered preRegistered(String openId, Integer openIdType, String brid, String name, String sex, String idCard, String tel, String ksid, String preDate, String preTime) throws Exception;

    /**
     * 取消预约挂号
     * @param openId
     * @param openIdType
     * @param brid
     * @param yyh
     * @return
     */
    CancelRegistered cancelRegistered(String openId, Integer openIdType, String brid, String yyh);
}
