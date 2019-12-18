package com.jfatty.zcloud.hospital.service.impl;

import com.jfatty.zcloud.hospital.datasource.TargetDataSource;
import com.jfatty.zcloud.hospital.mapper.ComplexPayMapper;
import com.jfatty.zcloud.hospital.service.ComplexPayService;
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
    public OutpatientDetail getWebmzDetail(String openId, Integer openIdType, String fydh) {
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
}
