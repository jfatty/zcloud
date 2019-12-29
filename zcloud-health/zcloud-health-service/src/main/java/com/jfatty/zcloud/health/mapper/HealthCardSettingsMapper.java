package com.jfatty.zcloud.health.mapper;

import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.health.entity.HealthCardSettings;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 电子健康卡平台配置信息表 Mapper 接口
 * </p>
 *
 * @author jfatty
 * @since 2019-12-26
 */
public interface HealthCardSettingsMapper extends IBaseMapper<HealthCardSettings> {


    HealthCardSettings getByAppId( @Param("appId") String appId);

    HealthCardSettings getByHospitalId( @Param("hospitalId") String hospitalId);
}
