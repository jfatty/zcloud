package com.jfatty.zcloud.hospital.service.impl;

import com.jfatty.zcloud.hospital.datasource.TargetDataSource;
import com.jfatty.zcloud.hospital.mapper.ExamReportMapper;
import com.jfatty.zcloud.hospital.service.ExamReportService;
import com.jfatty.zcloud.hospital.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 描述
 *
 * @author jfatty on 2020/4/16
 * @email jfatty@163.com
 */
@Slf4j
@Service
public class ExamReportServiceImpl implements ExamReportService {

    @Autowired
    private ExamReportMapper examReportMapper ;



    @TargetDataSource(name="mssql")
    @Override
    public List<ExamReportTask> getExamReportTasks(String brid) {
        return examReportMapper.getExamReportTasks(brid);
    }


    @TargetDataSource(name="mssql")
    @Override
    public ReportJcxx getReportJcxx(String djh) {
        return examReportMapper.getReportJcxx(djh);
    }


    @TargetDataSource(name="mssql")
    @Override
    public ReportZjjy getReportZjjy(String djh) {
        return examReportMapper.getReportZjjy(djh);
    }


    @TargetDataSource(name="mssql")
    @Override
    public List<EreportBase> getEreportResponse(String djh) {
        List<EreportResponse> ereportZeros = examReportMapper.getEreportZero(djh);
        List<EreportResponse> ereportOnes = examReportMapper.getEreportOne(djh);
        List<EreportResponse> ereportTwos = examReportMapper.getEreportTwo(djh);
        ereportZeros.addAll(ereportOnes) ;
        ereportZeros.addAll(ereportTwos) ;
        Map<String,EreportBase> map = new HashMap<String,EreportBase>();
        List<EreportBase> baseList = new ArrayList<EreportBase>();
        for ( EreportResponse ereport : ereportZeros ){
            EreportBase bs = map.get(ereport.getZhid()) ;
            List<EreportSecond> seconds = null;
            if(bs == null ){
                bs = new EreportBase();
                bs.setZhid(ereport.getZhid());
                bs.setZhmc(ereport.getZhmc());
                bs.setTjsj(ereport.getTjsj());
                bs.setTjysid(ereport.getTjysid());
                bs.setTjysmc(ereport.getTjysmc());
                bs.setTjysqm(ereport.getTjysqm());
                bs.setTxsl(ereport.getTxsl());
                bs.setEtype(ereport.getEtype());
                if(ereport.getTxsl() > 0){
                    bs.setEtype(3);//数据类型为带图片数据
                    List<EreportPic> pics = examReportMapper.getEreportPic(djh,ereport.getZhid());
                    bs.setPics(new ArrayList<EreportPic>(pics));
                }
                seconds = new ArrayList<EreportSecond>();
            } else {
                seconds = bs.getSeconds() ;
            }
            EreportSecond second = new EreportSecond() ;
            second.setXmmc(replaceBlank(ereport.getXmmc()));
            second.setXmjg(ereport.getXmjg());
            second.setXmdw(replaceBlank(ereport.getXmdw()));
            second.setCkz(replaceBlank(ereport.getCkz()));
            second.setJgsm(replaceBlank(ereport.getJgsm()));
            seconds.add(second);
            bs.setSeconds(seconds);
            map.put(ereport.getZhid(),bs);
        }
        List<EreportResponse> ereportXdts = examReportMapper.getEreportXdt(djh);
        map = xdtAgmd(map,ereportXdts);
        List<EreportResponse> ereportGmds = examReportMapper.getEreportGmd(djh);
        map = xdtAgmd(map,ereportGmds);
        for (Map.Entry<String, EreportBase> entry : map.entrySet()) {
            //log.error("key: " + entry.getKey() + " value: " + entry.getValue());
            baseList.add(entry.getValue());
        }
        Collections.sort(baseList);
        return baseList;
    }


    private Map<String,EreportBase> xdtAgmd(Map<String,EreportBase> map , List<EreportResponse> ereports ){
        if( !CollectionUtils.isEmpty(ereports) ){
            EreportBase bs = new EreportBase();
            bs.setZhid(ereports.get(0).getZhid());
            bs.setZhmc(ereports.get(0).getZhmc());
            bs.setEtype(ereports.get(0).getEtype());
            List<EreportSecond> seconds = new ArrayList<EreportSecond>();
            List<EreportPic> pics = new ArrayList<EreportPic>();
            for ( EreportResponse ereport : ereports ){
                EreportSecond second = new EreportSecond() ;
                EreportPic pic = new EreportPic();
                second.setXmmc(ereport.getXmmc());
                second.setXmjg(ereport.getXmjg());
                pic.setXh(ereport.getXh());
                pic.setTx(ereport.getTx());
                seconds.add(second);
                pics.add(pic);
            }
            bs.setSeconds(seconds);
            bs.setPics(pics);
            map.put(ereports.get(0).getZhid(),bs);
        }
        return map ;
    }

    private String replaceBlank(String source){
        String dest = "";
        if(source == null){
            return dest;
        }else{
            Pattern p = Pattern.compile("\\s*|\t|\r|\n|&nbsp;");
            Matcher m = p.matcher(source);
            dest = m.replaceAll("");
            return dest;
        }
    }
}
