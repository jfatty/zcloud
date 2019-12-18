package com.jfatty.zcloud.hospital.service;

import com.jfatty.zcloud.hospital.vo.ElectronicDoc;
import com.jfatty.zcloud.hospital.vo.ElectronicDocDetail;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
public interface ElectronicDocService {

    /**
     * 获取我的服务单列表信息
     * @author jfatty 2018-04-12
     * @param openId 支付宝 微信 openId
     * @param openIdType 业务类型
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    List<ElectronicDoc> getElectronicDocList(String openId, Integer openIdType, String startTime, String endTime);

    /**
     * 获取门诊缴费详情列表
     * @param openId  支付宝 微信 openId
     * @param openIdType  业务类型
     * @param brbh 病人编号
     * @param sfh 收费号
     * @return
     */
    List<ElectronicDocDetail> getElectronicDocDetail(String openId, Integer openIdType, String brbh, String sfh);
}
