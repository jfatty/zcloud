package com.jfatty.zcloud.hospital.service.impl;

import com.jfatty.zcloud.hospital.datasource.TargetDataSource;
import com.jfatty.zcloud.hospital.mapper.ReportViewMapper;
import com.jfatty.zcloud.hospital.service.ReportViewService;
import com.jfatty.zcloud.hospital.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
@Slf4j
@Service
public class ReportViewServiceImpl implements ReportViewService {

    @Autowired
    private ReportViewMapper reportViewMapper ;

    @TargetDataSource(name="mssql")
    @Override
    public List<WebReportMission> getWebReportMission(String openId, Integer openIdType) {
        return reportViewMapper.getWebReportMission(openId,openIdType);
    }

    @TargetDataSource(name="mssql")
    @Override
    public List<WebReportList> getWebReportList(String openId, Integer openIdType, String bglx, String brbh) {
        log.warn("检验检查报告列表  ====> exec dbo.pro_web_report_list " + openId + " ," + openIdType + " ,"+ bglx + " ,"+ brbh  );
        return reportViewMapper.getWebReportList(openId,openIdType,bglx,brbh);
    }

    @TargetDataSource(name="mssql")
    @Override
    public WebPacsReport getWebPacsReport(String openId, Integer openIdType, String djh) {
        return reportViewMapper.getWebPacsReport(openId,openIdType,djh);
    }

    @TargetDataSource(name="mssql")
    @Override
    public WebReportLisHead getWebReportListHead(String openId, Integer openIdType, String sn) {
        return reportViewMapper.getWebReportListHead(openId,openIdType,sn);
    }

    @TargetDataSource(name="mssql")
    @Override
    public List<WebReportLisDetail> getWebReportListDetail(String openId, Integer openIdType, String sn) {
        return reportViewMapper.getWebReportListDetail(openId,openIdType,sn);
    }
}
