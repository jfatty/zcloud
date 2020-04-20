package com.jfatty.zcloud.hospital.mapper;

import com.jfatty.zcloud.hospital.vo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2020/4/16
 * @email jfatty@163.com
 */
public interface ExamReportMapper {


    List<ExamReportTask> getExamReportTasks(@Param("brid") String brid);

    /**
     * 根据单据号获取 体检人基础细信息
     * @param djh
     * @return
     */
    ReportJcxx getReportJcxx(@Param("djh") String djh);

    /**
     *  根据单据号获取 体检报告总结建议 部分
     * @param djh
     * @return
     */
    ReportZjjy getReportZjjy(@Param("djh") String djh);

    List<EreportResponse> getEreportZero(@Param("djh") String djh);

    List<EreportResponse> getEreportOne(@Param("djh") String djh);

    List<EreportResponse> getEreportTwo(@Param("djh") String djh);

    List<EreportPic> getEreportPic(@Param("djh") String djh,@Param("zhid")  String zhid);

    /**
     * 心电图数据
     * @param djh
     * @return
     */
    List<EreportResponse> getEreportXdt(@Param("djh") String djh);

    /**
     * 骨密度数据
     * @param djh
     * @return
     */
    List<EreportResponse> getEreportGmd(@Param("djh") String djh);


}
