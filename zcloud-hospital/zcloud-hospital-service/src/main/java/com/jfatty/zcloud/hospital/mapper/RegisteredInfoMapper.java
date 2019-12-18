package com.jfatty.zcloud.hospital.mapper;

import com.jfatty.zcloud.hospital.entity.RegisteredInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/12/18
 * @email jfatty@163.com
 */
public interface RegisteredInfoMapper {


    List<RegisteredInfo> getRegisteredInfo(@Param("name") String name, @Param("idCard")  String idCard, @Param("dtme")  String dtme);

}
