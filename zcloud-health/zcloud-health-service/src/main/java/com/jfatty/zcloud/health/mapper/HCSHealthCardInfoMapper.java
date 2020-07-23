package com.jfatty.zcloud.health.mapper;

import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.health.entity.HCSHealthCardInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jfatty
 * @since 2019-12-26
 */
public interface HCSHealthCardInfoMapper extends IBaseMapper<HCSHealthCardInfo> {

    HCSHealthCardInfo getByIdCardNumber(@Param("idNumber") String idNumber);

    String getNationDicStr(@Param("sourceNation") String sourceNation);

    List<HCSHealthCardInfo> getBatchHealthCardByInfoIds(@Param("healthCardInfoIds") List<String> healthCardInfoIds,@Param("hospitalId")  String hospitalId);

    int verification(@Param("idCard") String idCard,@Param("brid")  String brid,@Param("hospitalId")  String hospitalId);
}
