package com.jfatty.zcloud.hospital.mapper;

import com.jfatty.zcloud.hospital.vo.HosClazz;
import com.jfatty.zcloud.hospital.vo.HosDept;
import com.jfatty.zcloud.hospital.vo.HosHoliday;
import com.jfatty.zcloud.hospital.vo.PreRegistered;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/12/18
 * @email jfatty@163.com
 */
public interface RegistrationMapper {

    List<HosDept> getHosDepts(@Param("openId") String openId,@Param("openIdType")  Integer openIdType);

    List<HosClazz> getHosClazzs(@Param("openId") String openId,@Param("openIdType")  Integer openIdType);

    /**
     * 检验用户选择的日期是否为节假日
     * @param openId
     * @param openIdType
     * @param checkTime
     * @return
     */
    HosHoliday checkHoliday(@Param("openId") String openId,@Param("openIdType")  Integer openIdType, @Param("checkTime") String checkTime);

    /**
     * 挂号预约
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
    PreRegistered preRegistered(@Param("openId") String openId,@Param("openIdType") Integer openIdType, @Param("brid") String brid, @Param("name")String name,//
                                @Param("sex") String sex, @Param("idCard") String idCard, @Param("tel") String tel, @Param("ksid") String ksid,//
                                @Param("preDate") String preDate, @Param("preTime") String preTime);
}
