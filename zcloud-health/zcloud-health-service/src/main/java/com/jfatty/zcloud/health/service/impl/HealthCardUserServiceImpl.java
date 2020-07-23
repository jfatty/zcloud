package com.jfatty.zcloud.health.service.impl;

import com.jfatty.zcloud.health.entity.HealthCardUser;
import com.jfatty.zcloud.health.mapper.HealthCardUserMapper;
import com.jfatty.zcloud.health.service.HealthCardUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 电子健康卡微信用户信息表 服务实现类
 * </p>
 *
 * @author jfatty
 * @since 2019-12-31
 */
@Slf4j
@Service
public class HealthCardUserServiceImpl extends BaseHealthServiceImpl<HealthCardUser,HealthCardUserMapper> implements HealthCardUserService {


    private HealthCardUserMapper healthCardUserMapper ;

    @Autowired
    public void setHealthCardUserMapper(HealthCardUserMapper healthCardUserMapper) {
        super.setBaseMapper(healthCardUserMapper);
        this.healthCardUserMapper = healthCardUserMapper;
    }

    @Override
    public List<String> getByOpenId(String openId, Integer openIdType) {
        return healthCardUserMapper.getByOpenId(openId,openIdType);
    }

    @Override
    public Boolean tieHealthCard(String openId, Integer openIdType, String hospitalId, String healthCardInfoId) throws Exception {
        return healthCardUserMapper.tieHealthCard(openId,openIdType,hospitalId,healthCardInfoId) > 0;
    }

    @Override
    public Boolean untieHealthCard(String openId, Integer openIdType, String hospitalId, String healthCardInfoId) throws Exception {
        return healthCardUserMapper.untieHealthCard(openId,openIdType,hospitalId,healthCardInfoId) > 0;
    }

    @Override
    public HealthCardUser getByOpts(String appId, String hospitalId, String openId, Integer openIdType) {
        return healthCardUserMapper.getByOpts(appId,hospitalId,openId,openIdType);
    }

    @Override
    public boolean bindDefaultHealthCard(String openId, Integer openIdType, String hospitalId ,String healthCardInfoId, Integer bindStatus) throws Exception {
        if (bindStatus == 0)
            healthCardInfoId = "" ;
        int count = healthCardUserMapper.bindDefaultHealthCard(openId,openIdType,hospitalId,healthCardInfoId);
        return (count > 0);
    }
}
