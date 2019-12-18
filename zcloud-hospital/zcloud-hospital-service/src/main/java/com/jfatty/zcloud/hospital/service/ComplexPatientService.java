package com.jfatty.zcloud.hospital.service;

import com.jfatty.zcloud.hospital.res.NumoPatientDeatilRes;
import com.jfatty.zcloud.hospital.res.WebRegPatientRes;
import com.jfatty.zcloud.hospital.vo.NumoPatientInfo;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
public interface ComplexPatientService {

    /**
     * 查询微信/支付宝用户绑定的就诊人的信息
     * @param openId
     * @param openIdType
     * @return
     */
    List<WebRegPatientRes> getWebRegList(String openId, Integer openIdType);
    /**
     * 查询微信/支付宝用户绑定的就诊人的信息
     * @param openId
     * @param openIdType
     * @param pageIndex
     * @param pageSize
     * @return
     */
    List<WebRegPatientRes> getWebRegList(String openId, Integer openIdType, Integer pageIndex, Integer pageSize);

    /**
     *
     * @param openId
     * @param openIdType
     * @param name
     * @param idCard
     * @param tel
     * @param address
     * @param nation
     * @param hisCardNo
     * @param hisCardType
     * @return
     */
    boolean saveComplexPatient(String openId, Integer openIdType, String name, String idCard, String tel, String address, String nation, String hisCardNo, String hisCardType) throws Exception ;

    //查看就诊人详情 身份证加星操作
    /**
     * 查询单个就诊人详情  jfatty 2017-10-24
     * @param brid 病人ID
     * @return
     */
    NumoPatientDeatilRes getNumoPatientInfo(String brid);

    //删除就诊人  抛出异常
    /**
     * 删除就诊人  抛出异常
     * @param idCard 身份证号码
     * @param name 姓名
     * @param openId 微信支付宝openId
     * @param openIdType 微信支付宝openId类型
     * @return
     * @throws Exception
     */
    boolean deleteComplexPatient(Long pid, String idCard, String name, String openId, Integer openIdType) throws Exception ;

    NumoPatientInfo getNumoPatientInfoByBrid(String brid);
}
