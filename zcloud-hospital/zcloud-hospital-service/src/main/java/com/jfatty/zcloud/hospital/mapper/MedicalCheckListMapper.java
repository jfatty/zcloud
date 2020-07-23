package com.jfatty.zcloud.hospital.mapper;

import com.jfatty.zcloud.hospital.vo.WebCyfyqd;
import com.jfatty.zcloud.hospital.vo.WebCyqdList;
import com.jfatty.zcloud.hospital.vo.WebZyrqd;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述 住/出院清单查看
 *
 * @author jfatty on 2020/7/15
 * @email jfatty@163.com
 */
public interface MedicalCheckListMapper {


    List<WebZyrqd> getWebZyrqd(@Param("openId") String openId, @Param("openIdType") Integer openIdType,//
                               @Param("brid")String brid,@Param("startTime") String startTime,//
                               @Param("endTime") String endTime,//
                               @Param("Ext1")  String Ext1,@Param("Ext2")   String Ext2, @Param("Ext3")   String Ext3);

    List<WebCyqdList> getWebCyqdList(@Param("openId") String openId, @Param("openIdType") Integer openIdType,//
                                     @Param("brid")String brid,//
                                     @Param("Ext1")  String Ext1,@Param("Ext2")   String Ext2, @Param("Ext3")   String Ext3);

    List<WebCyfyqd> getWebCyfyqd(@Param("openId") String openId, @Param("openIdType") Integer openIdType,//
                                 @Param("zybh") String zybh,//
                                 @Param("Ext1")  String Ext1,@Param("Ext2")   String Ext2, @Param("Ext3")   String Ext3);
}
