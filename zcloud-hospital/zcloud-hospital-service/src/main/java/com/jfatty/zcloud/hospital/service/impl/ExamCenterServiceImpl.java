package com.jfatty.zcloud.hospital.service.impl;

import com.jfatty.zcloud.hospital.datasource.TargetDataSource;
import com.jfatty.zcloud.hospital.mapper.ExamCenterMapper;
import com.jfatty.zcloud.hospital.service.ExamCenterService;
import com.jfatty.zcloud.hospital.vo.ExamReserve;
import com.jfatty.zcloud.hospital.vo.ReserveRecord;
import com.jfatty.zcloud.hospital.vo.WebExamDetail;
import com.jfatty.zcloud.hospital.vo.WebExamPackage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2020/4/15
 * @email jfatty@163.com
 */
@Slf4j
@Service
public class ExamCenterServiceImpl implements ExamCenterService {


    @Autowired
    private ExamCenterMapper examCenterMapper ;

    @TargetDataSource(name="mssql")
    @Override
    public List<WebExamPackage> getWebExamPackages(String openId, Integer openIdType) {
        return examCenterMapper.getWebExamPackages() ;
    }

    @TargetDataSource(name="mssql")
    @Override
    public List<WebExamDetail> getWebExamDetails(String openId, Integer openIdType, String tcid) {
        return examCenterMapper.getWebExamDetails( tcid );
    }

    @TargetDataSource(name="mssql")
    @Override
    public ExamReserve examReserve(String yyrq, Integer tdbz, String yydw, Integer yyrs, String brid, String yytc, String lxr, String lxfs,String lxdz , String beizhu, String sfzh, String rjys, String tcmc, String czr) {
        return examCenterMapper.examReserve(yyrq,tdbz,yydw,yyrs,brid,yytc,lxr,lxfs,lxdz,beizhu,sfzh,rjys,tcmc,czr);
    }

    @TargetDataSource(name="mssql")
    @Override
    public List<ReserveRecord> getReserveRecords(String openId, Integer openIdType) {
        return examCenterMapper.getReserveRecords(openId);
    }

    @TargetDataSource(name="mssql")
    @Override
    public ReserveRecord getReserveRecord(String openId, Integer openIdType, String yyh) {
        return examCenterMapper.getReserveRecord(openId,yyh);
    }
}
