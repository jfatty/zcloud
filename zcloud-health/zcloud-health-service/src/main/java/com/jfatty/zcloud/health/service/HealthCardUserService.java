package com.jfatty.zcloud.health.service;

import com.jfatty.zcloud.health.entity.HealthCardUser;

import java.util.List;

/**
 * <p>
 * 电子健康卡微信用户信息表 服务类
 * </p>
 *
 * @author jfatty
 * @since 2019-12-31
 */
public interface HealthCardUserService extends BaseHealthService<HealthCardUser> {


    List<String> getByOpenId(String openId,  Integer openIdType);

    Boolean untieHealthCard(String openId, Integer openIdType, String hospitalId, String healthCardInfoId) throws Exception;
}
