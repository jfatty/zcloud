package com.jfatty.zcloud.hospital.service;

import com.jfatty.zcloud.hospital.vo.*;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
public interface ReportViewService {


    /**
     * 获取报告任务
     * @param openId 微信支付宝openId
     * @param openIdType  微信支付宝openId类型
     * @return
     */
    List<WebReportMission> getWebReportMission(String openId, Integer openIdType);

    /**
     * 描述 检验 检查 报告列表 返回结果是列表
     * @param openId 微信支付宝openId
     * @param openIdType 微信支付宝openId类型
     * @param bglx 报告类型 1 检验 2 检查
     * @param brbh 病人编号
     * @return
     */
    List<WebReportList> getWebReportList(String openId, Integer openIdType, String bglx, String brbh);

    /**
     * 检查报告内容 一条信息
     * @param openId 微信支付宝openId
     * @param openIdType 微信支付宝openId类型
     * @param djh 流水号
     * @return
     */
    WebPacsReport getWebPacsReport(String openId, Integer openIdType, String djh);

    /**
     * 检验报告表头 一条信息
     * @param openId
     * @param openIdType
     * @param sn
     * @return
     */
    WebReportLisHead getWebReportListHead(String openId, Integer openIdType, String sn);
    /**
     * 检验 检查 报告列表 返回结果是列表
     * @param openId
     * @param openIdType
     * @param sn
     * @return
     */
    List<WebReportLisDetail> getWebReportListDetail(String openId, Integer openIdType, String sn);
}
