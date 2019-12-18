package com.jfatty.zcloud.hospital.mapper;

import com.jfatty.zcloud.hospital.vo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 描述
 *
 * @author jfatty on 2019/12/17
 * @email jfatty@163.com
 */
public interface ComplexPayMapper {


    /**
     * 查询住院预交与门诊缴费人员名单
     * @return
     */
    List<WebMission> getWebMissionList(@Param("openId") String openId, @Param("openIdType") Integer openIdType);

    /**
     * 描述 查询就诊人当前住院详情 就是之前已经缴费的详细信息
     * @author jfatty
     * 创建时间：2018年3月27日
     */
    InHospitalInfo getZYPre(Map<String,Object> map);

    /**
     * 调用存储过程 查询门诊缴费单详情 通过费用单号
     * @return
     */
    OutpatientDetail getWebmzDetail(@Param("openId") String openId, @Param("openIdType") Integer openIdType, @Param("fydh") String fydh);
    /**
     * 调用存储过程 查询就诊人待缴费单信息
     * @return
     */
    List<WebmzList> getWebmzList(@Param("openId") String openId, @Param("openIdType") Integer openIdType, @Param("djh")String djh);

    /**
     * 通过  outTradeNo 查询订单情况  jfatty 2017-11-19
     * @param outTradeNo
     * @return
     */
    ComplexPay getPayRecordByOutTradeNo(@Param("outTradeNo") String outTradeNo);
}
