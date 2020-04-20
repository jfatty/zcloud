package com.jfatty.zcloud.hospital.mapper;

import com.jfatty.zcloud.hospital.vo.ExamReserve;
import com.jfatty.zcloud.hospital.vo.ReserveRecord;
import com.jfatty.zcloud.hospital.vo.WebExamDetail;
import com.jfatty.zcloud.hospital.vo.WebExamPackage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2020/4/15
 * @email jfatty@163.com
 */
public interface ExamCenterMapper {

    /**
     * 获取套餐列表
     * @return
     */
    List<WebExamPackage> getWebExamPackages();

    /**
     * 获取套餐明细
     * @param tcid 套餐ID
     * @return
     */
    List<WebExamDetail> getWebExamDetails(@Param("tcid") String tcid);

    /**
     * 预约挂号
     * @param yyrq 预约日期
     * @param tdbz 团队标志 0表示个人
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
    ExamReserve examReserve( @Param("yyrq") String yyrq,//
                             @Param("tdbz") Integer tdbz,//
                             @Param("yydw") String yydw,//
                             @Param("yyrs") Integer yyrs,//
                             @Param("brid") String brid,//
                             @Param("yytc") String yytc,//
                             @Param("lxr") String lxr,//
                             @Param("lxfs") String lxfs,//
                             @Param("lxdz") String lxdz,//
                             @Param("beizhu") String beizhu,//
                             @Param("sfzh") String sfzh,//
                             @Param("rjys") String rjys,//
                             @Param("tcmc") String tcmc,//
                             @Param("czr") String czr);//


    List<ReserveRecord> getReserveRecords(@Param("openId") String openId);

    ReserveRecord getReserveRecord(@Param("openId") String openId, @Param("yyh") String yyh);
}
