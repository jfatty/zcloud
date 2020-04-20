package com.jfatty.zcloud.hospital.vo;

import lombok.Data;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/9/30
 * @email jfatty@163.com
 */
@Data
public class EreportBase implements Comparable<EreportBase> {

    private String zhid = "" ;

    private String zhmc  = "" ;

    /**
     * 图像数量
     */
    private Integer txsl = 0 ;

    /**
     * 体检医生ID
     */
    private String tjysid = "" ;
    /**
     * 体检医生名称
     */
    private String tjysmc = "" ;
    /**
     * 体检医生签名
     */
    private byte[] tjysqm ;
    /**
     * 体检时间
     */
    private String tjsj = "" ;

    private Integer etype  ;

    List<EreportSecond> seconds ;

    List<EreportPic> pics ;


    @Override
    public int compareTo(EreportBase o) {
        return this.getZhid().compareTo(o.getZhid());
    }
}
