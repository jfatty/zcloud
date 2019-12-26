package com.jfatty.zcloud.hospital.mapper;

import com.jfatty.zcloud.hospital.vo.NumoPatientInfo;
import com.jfatty.zcloud.hospital.vo.NumoUserInfo;
import com.jfatty.zcloud.hospital.vo.WebRegPatient;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
public interface ComplexPatientMapper {


    /**
     * 调用存储过程
     * @description:获取已经绑定病人信息列表
     * @author jfatty
     * @date 2019年1月26日
     * @version 1.0.0
     * @param map
     * @return
     */
    List<WebRegPatient> getWebRegPatientList(Map<String,Object> map);

    /**
     * 调用存储过程 添加就诊人
     * @param map
     * @return
     */
    List<WebRegPatient> webRegPatient(Map<String,Object> map);

    /**
     * 调用存储过程 添加就诊人 携带就诊卡号
     * @param map
     * @return
     */
    List<WebRegPatient> webRegOtherPatient(Map<String,Object> map);

    /**
     * 操作numo库
     * 添加就诊人，且绑定用户和就诊人  jfatty  2017-10-26
     * 注： 以用户身份证为依据判断——若就诊人在系统中已经存在，则更新就诊人信息，若不存在，则新增就诊人信息。
     * @param numoPatientInfo 病人信息对象
     * @param openId 微信支付宝openId
     * @param openIdType 微信支付宝openId类型
     */
    Integer addNumoPatientInfo(@Param("numoPatientInfo") NumoPatientInfo numoPatientInfo, @Param("openId") String openId, @Param("openIdType")Integer openIdType);

    /**
     * 通过HIS系统中的病人ID 查询单个就诊人详情
     * @param brid
     * @return
     */
    NumoPatientInfo getNumoPatientInfo(@Param("brid") String brid);

    /**
     * 删除就诊人
     * @return
     */
    WebRegPatient webUnReg(@Param("idCard") String idCard,@Param("name")  String name,@Param("openId")  String openId,@Param("openIdType")  Integer openIdType);

    /**
     * 解绑用户和就诊人
     * @param openId 微信支付宝openId
     * @param openIdType 微信支付宝openId类型
     * @param pid
     */
    void localUnBind(@Param("openId") String openId,@Param("openIdType")  Integer openIdType,@Param("pid")  Long pid);

    /**
     * 查询此就诊人和对应用户是否为绑定默认就诊人关系
     * @param
     * @return
     */
    Integer checkDefaultPatByBrid(@Param("openId") String openId,@Param("openIdType")  Integer openIdType,@Param("brid")  String brid);

    /**
     * 查询用户有无操作就诊人的权限
     * @param
     * @return
     */
    Integer checkRightByBrid(@Param("openId") String openId,@Param("openIdType")  Integer openIdType,@Param("brid")  String brid);

    /**
     * 绑定默认就诊人
     * @param openId 微信支付宝openId
     * @param openIdType 微信支付宝openId类型
     * @param brid
     * @return
     */
    Integer bindDefaultPat(@Param("openId") String openId,@Param("openIdType")  Integer openIdType,@Param("brid")  String brid);

    /**
     * 查询用户是否存在
     * @param openId 微信支付宝openId
     * @param openIdType 微信支付宝openId类型
     * @param attention
     * @return
     */
    Integer isExist(@Param("openId") String openId,@Param("openIdType")  Integer openIdType,@Param("attention") int attention);

    /**
     * 关注公众号事件,添加用户信息
     * @param openId 微信支付宝openId
     * @param openIdType 微信支付宝openId类型
     * @param attention
     */
    void subscribeEvent(@Param("openId") String openId,@Param("openIdType")  Integer openIdType,@Param("attention") int attention);

    /**
     *
     * @param openId 微信支付宝openId
     * @param openIdType 微信支付宝openId类型
     * @return
     */
    NumoUserInfo getNumoUserInfo(String openId, Integer openIdType);
}
