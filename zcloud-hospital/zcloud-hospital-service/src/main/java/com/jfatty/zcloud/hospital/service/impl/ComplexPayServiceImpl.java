package com.jfatty.zcloud.hospital.service.impl;

import com.jfatty.zcloud.hospital.datasource.TargetDataSource;
import com.jfatty.zcloud.hospital.mapper.ComplexPayMapper;
import com.jfatty.zcloud.hospital.service.ComplexPayService;
import com.jfatty.zcloud.hospital.utils.Sync2HISPayResultUtil;
import com.jfatty.zcloud.hospital.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 描述
 *
 * @author jfatty on 2019/12/17
 * @email jfatty@163.com
 */
@Slf4j
@Service
public class ComplexPayServiceImpl implements ComplexPayService {

    @Autowired
    private ComplexPayMapper complexPayMapper ;

    @TargetDataSource(name="mssql")
    @Override
    public List<WebMission> getWebMissionList(String openId, Integer openIdType) {
        return complexPayMapper.getWebMissionList(openId,openIdType);
    }

    @TargetDataSource(name="mssql")
    @Override
    public InHospitalInfo getZYPre(String openId, Integer openIdType, String djh) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("openId", openId);
        map.put("openIdType", openIdType);
        map.put("djh", djh);
        map.put("Ext1", "");
        map.put("Ext2", "");
        map.put("Ext3", "");
        return complexPayMapper.getZYPre(map);
    }

    @TargetDataSource(name="mssql")
    @Override
    public List<OutpatientDetail> getWebmzDetail(String openId, Integer openIdType, String fydh) {
        return complexPayMapper.getWebmzDetail(openId,openIdType,fydh);
    }

    @TargetDataSource(name="mssql")
    @Override
    public List<WebmzList> getWebmzList(String openId, Integer openIdType, String djh) {
        return complexPayMapper.getWebmzList(openId,openIdType,djh);
    }

    @TargetDataSource(name="mssql")
    @Override
    public TotalUnPayOutpatient getMZPay(String openId, Integer openIdType, String djh, String brid) {
        List<WebmzList> list = complexPayMapper.getWebmzList(openId,openIdType,djh);
        TotalUnPayOutpatient totalUnPayOutpatient = new TotalUnPayOutpatient();
        // 科室名称
        List<String> ksmcs = new ArrayList<String>();
        String ksmc = "";
        // 费用单号
        String fydh = "";
        // 合计总金额
        Double totoal = new Double(0.00);
        // 病人信息
        totalUnPayOutpatient.setXmmc("门诊缴费");
        log.info("=================>  门诊缴费 开始记录收费项目详情 "  );
        // 循环迭代
        for (WebmzList wmz : list) {
            // 迭代科室名称
            ksmcs.add(wmz.getKsmc());
            // 金额
            BigDecimal je = new BigDecimal(wmz.getJe());
            // 临时金额
            BigDecimal tmp = new BigDecimal(Double.toString(totoal));
            // 累计金额
            totoal = je.add(tmp).doubleValue();
            // 拼接费用单号
            fydh += wmz.getFydh() + ",";
            //日志记录本次门诊缴费项目查询
            log.info("=================> 收费项目名称 " + wmz.getSfxmmc() + " 收费金额 " + wmz.getJe() );
        }
        log.info("=================>  门诊缴费 结束记录收费项目详情 "  );
        ksmcs = ksmcs.stream().distinct().collect(Collectors.toList());
        // 设置总金额
        totalUnPayOutpatient.setZfje(totoal);
        ksmc = String.join(",", ksmcs);
        // 设置科室名称
        totalUnPayOutpatient.setKsmc(ksmc);
        // 截取费用单号最后一个,
        if (!"".equals(fydh) && fydh.endsWith(",")) {
            fydh = fydh.substring(0, fydh.lastIndexOf(","));
        }
        // 设置费用单号
        totalUnPayOutpatient.setFydh(fydh);
        totalUnPayOutpatient.setPayState(ComplexPay.PAY_STATE_UNNKNOWN);
        return totalUnPayOutpatient;
    }

    @TargetDataSource(name="mssql")
    @Override
    public ComplexPay getPayRecordByOutTradeNo(String outTradeNo) {
        return complexPayMapper.getPayRecordByOutTradeNo(outTradeNo);
    }

    @TargetDataSource(name="mssql")
    @Override
    public ComplexPay getLatestPayRecord(String hisNo, int feeType, String brid, int payWay,int payChannel) {
        log.error("根据 HIS系统中的 '唯一订单号' [{}] 和 支付类型 [{}]和 支付渠道 [{}] 和 病人id [{}] 查询 最新的那一条支付记录 " ,hisNo,payWay,payChannel,brid );
        ComplexPay latestPayOrder = complexPayMapper.getLatestPayRecord( hisNo,feeType,payWay,brid,payChannel );
        log.error("根据 查询结果  "+latestPayOrder);
        return latestPayOrder;
    }

    @TargetDataSource(name="mssql")
    @Override
    public SyncMZPay syncMZPay(String openId, Integer openIdType, String outTradeNo, String brid, String fydh, Integer fkfs, String ssje, String ext1, String ext2, String ext3) throws Exception  {
        log.error("门诊缴费----传入----参数 openId [{}] openIdType [{}] outTradeNo [{}] brid [{}] fydh [{}] fkfs [{}] ssje [{}] ext1 [{}] ext2 [{}] ext3 [{}] " ,openId,openIdType,outTradeNo,brid,fydh,fkfs,ssje,ext1,ext2,ext3);
        SyncMZPay syncMZPay =  complexPayMapper.syncMZPay(openId,openIdType,outTradeNo,brid,fydh,fkfs,ssje,ext1,ext2,ext3);
        log.error("门诊缴费------his-------返回数据" + syncMZPay.toString());
        return syncMZPay;
    }

    @TargetDataSource(name="mssql")
    @Override
    public void syncHisFeeBack(String outTradeNo, int hisSync, String hisNo) throws Exception {
        complexPayMapper.syncHisFeeBack(outTradeNo,hisSync,hisNo);
    }

    @TargetDataSource(name="mssql")
    @Override
    public SyncZYPay syncZYPay(String openId, Integer openIdType, String outTradeNo, String brid, String zybh, Integer fkfs, String yjje, String ext1, String ext2, String ext3) throws Exception {
        log.error("住院预缴-----传入-------数据 openId [{}] openIdType [{}] outTradeNo [{}] brid [{}] zybh [{}] fkfs [{}] yjje [{}]  ext1 [{}] ext2 [{}] ext3 [{}] ",openId,openIdType,outTradeNo,brid,zybh,fkfs,yjje,ext1,ext2,ext3 );
        SyncZYPay syncZYPay = complexPayMapper.syncZYPay(openId,openIdType,outTradeNo,brid,zybh,fkfs,yjje,ext1,ext2,ext3);
        log.error("住院预缴--------------his------------返回数据" + syncZYPay.toString());
        return syncZYPay;
    }

    @TargetDataSource(name="mssql")
    @Override
    public void syncHisInHospitalFeeBack(String outTradeNo, int hisSync, String yjh) throws Exception {
        //预缴号
        complexPayMapper.syncHisInHospitalFeeBack(outTradeNo,hisSync,yjh);
    }

    @TargetDataSource(name="mssql")
    @Override
    public void saveOrderRecord(ComplexPay complexPay) throws Exception {
        complexPayMapper.saveOrderRecord(complexPay);
    }

    @TargetDataSource(name="mssql")
    @Override
    public void confirmAsyncStatus(String openId, Integer openIdType, ComplexPay payOrder) throws Exception {
        switch (payOrder.getFeeType()) {
            case ComplexPay.FEE_TYPE_MZ:
                Sync2HISPayResultUtil.syncHisFeeResult(payOrder.getOpenId(),
                        openIdType,
                        payOrder.getOutTradeNo(),
                        payOrder.getFeeType(),
                        payOrder.getPatientId(),
                        payOrder.getDjh(), payOrder.getPayWay(), payOrder.getCreatedTime(), payOrder.getFeeAmount(), ComplexPay.PAY_STATE_SUCCESS, null, "", "", "");
                break;
            case ComplexPay.FEE_TYPE_ZY:
                Sync2HISPayResultUtil.syncHisFeeResult(payOrder.getOpenId(),
                        openIdType,
                        payOrder.getOutTradeNo(),
                        payOrder.getFeeType(),
                        payOrder.getPatientId(),
                        payOrder.getDjh(), payOrder.getPayWay(), payOrder.getCreatedTime(), payOrder.getFeeAmount(), ComplexPay.PAY_STATE_SUCCESS, null, "", "", "");
                break;
            default:
                break;
        }
    }

    @TargetDataSource(name="mssql")
    @Override
    public void payAsync(ComplexPay complexPayOrder) throws Exception {
        complexPayMapper.payAsync(complexPayOrder);
    }
}
