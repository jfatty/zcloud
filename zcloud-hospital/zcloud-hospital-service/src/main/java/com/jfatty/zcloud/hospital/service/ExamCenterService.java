package com.jfatty.zcloud.hospital.service;

import com.jfatty.zcloud.hospital.vo.ExamReserve;
import com.jfatty.zcloud.hospital.vo.ReserveRecord;
import com.jfatty.zcloud.hospital.vo.WebExamDetail;
import com.jfatty.zcloud.hospital.vo.WebExamPackage;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2020/4/15
 * @email jfatty@163.com
 */
public interface ExamCenterService {

    /**
     * 获取体检套餐
     * @param openId 微信 支付宝 openId
     * @param openIdType 微信 2 支付宝 1 APP 3 openId 类型
     * @return
     */
    List<WebExamPackage> getWebExamPackages(String openId, Integer openIdType);

    /**
     *
     * @param openId 微信 支付宝 openId
     * @param openIdType 微信 2 支付宝 1 APP 3 openId 类型
     * @param tcid 套餐ID
     * @return
     */
    List<WebExamDetail> getWebExamDetails(String openId, Integer openIdType, String tcid);

    /**
     * 预约挂号
     * @param yyrq 预约日期
     * @param tdbz 团队标志 0表示个人 1表示团队
     * @param yydw 预约单位
     * @param yyrs 预约人数
     * @param brid 病人ID
     * @param yytc 预约套餐ID
     * @param lxr 联系人
     * @param lxfs 联系方式
     * @param lxdz 联系地址
     * @param beizhu 备注
     * @param sfzh  身份证号
     * @param rjys  人均预算
     * @param tcmc 套餐名称
     * @param czr 操作人
     * @return
     */
    ExamReserve examReserve(String yyrq,Integer tdbz ,String yydw , Integer yyrs , String brid ,String yytc ,String lxr, String lxfs , String lxdz ,String beizhu , String sfzh , String rjys, String tcmc ,String czr  );

    List<ReserveRecord> getReserveRecords(String openId, Integer openIdType);

    ReserveRecord getReserveRecord(String openId, Integer openIdType, String yyh);
}
