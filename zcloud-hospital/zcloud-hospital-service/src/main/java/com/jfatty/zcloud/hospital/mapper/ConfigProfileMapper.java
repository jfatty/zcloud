package com.jfatty.zcloud.hospital.mapper;

import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.hospital.entity.ConfigProfile;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 智慧医疗系统配置配置 Mapper 接口
 * </p>
 *
 * @author jfatty
 * @since 2020-05-20
 */
public interface ConfigProfileMapper extends IBaseMapper<ConfigProfile> {

    /**
     * 根据appId获取配置信息
     * @param appId
     * @return
     */
    ConfigProfile getConfigProfileByAppId(@Param("appId") String appId);

}
