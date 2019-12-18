package com.jfatty.zcloud.hospital.mapper;

import com.jfatty.zcloud.hospital.vo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
public interface ReportViewMapper {

    /**
     * 描述  报告任务
     * @author jfatty
     * @return
     * 创建时间：2018年11月05日
     */
    List<WebReportMission> getWebReportMission(@Param("openId") String openId,@Param("openIdType")  Integer openIdType);

    /**
     * 描述  检验  检查 报告列表  返回结果是列表
     * @author jfatty
     * @return
     *  创建时间：2018年11月05日
     */
    List<WebReportList> getWebReportList(@Param("openId") String openId,@Param("openIdType")  Integer openIdType,@Param("bglx")  String bglx,@Param("brbh")  String brbh);

    /**
     * 描述 检查报告内容  一条信息
     * @author jfatty
     * @return
     *  创建时间：2018年11月05日
     */
    WebPacsReport getWebPacsReport(@Param("openId") String openId,@Param("openIdType")  Integer openIdType,@Param("djh") String djh);

    /**
     * 描述  检验  检查 报告列表  返回结果是列表
     * @author jfatty
     * @return
     *  创建时间：2018年11月05日
     */
    WebReportLisHead getWebReportListHead(@Param("openId") String openId,@Param("openIdType")  Integer openIdType,@Param("sn") String sn);

    /**
     * 描述  检验  检查 报告列表  返回结果是列表
     * @author jfatty
     * @return
     *  创建时间：2018年11月05日
     */
    List<WebReportLisDetail> getWebReportListDetail(@Param("openId") String openId,@Param("openIdType")  Integer openIdType,@Param("sn") String sn);
}
