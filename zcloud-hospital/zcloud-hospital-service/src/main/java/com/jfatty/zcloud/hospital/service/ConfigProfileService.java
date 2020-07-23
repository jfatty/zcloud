package com.jfatty.zcloud.hospital.service;

import com.jfatty.zcloud.hospital.entity.ConfigProfile;

/**
 * <p>
 * 智慧医疗系统配置配置 服务类
 * </p>
 *
 * @author jfatty
 * @since 2020-05-20
 */
public interface ConfigProfileService extends BaseHospitalService<ConfigProfile> {


    /**
     * 根据appId获取配置信息
     * @param appId
     * @return
     */
    ConfigProfile getConfigProfileByAppId(String appId);

}
