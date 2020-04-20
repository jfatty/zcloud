package com.jfatty.zcloud.hospital.service;

import com.jfatty.zcloud.hospital.vo.EreportBase;
import com.jfatty.zcloud.hospital.vo.ExamReportTask;
import com.jfatty.zcloud.hospital.vo.ReportJcxx;
import com.jfatty.zcloud.hospital.vo.ReportZjjy;

import java.util.List;

/**
 * 描述 体检报告
 *
 * @author jfatty on 2020/4/16
 * @email jfatty@163.com
 */
public interface ExamReportService {

    List<ExamReportTask> getExamReportTasks(String brid);

    /**
     * 根据单据号获取 体检人基础细信息
     * @param djh
     * @return
     */
    ReportJcxx getReportJcxx(String djh);

    /**
     * 根据单据号获取 体检报告总结建议 部分
     * @param djh
     * @return
     */
    ReportZjjy getReportZjjy(String djh);

    List<EreportBase> getEreportResponse(String djh);


}
