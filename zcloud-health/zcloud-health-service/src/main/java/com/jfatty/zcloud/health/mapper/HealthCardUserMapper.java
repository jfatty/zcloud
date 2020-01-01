package com.jfatty.zcloud.health.mapper;

import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.health.entity.HealthCardUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 电子健康卡微信用户信息表 Mapper 接口
 * </p>
 *
 * @author jfatty
 * @since 2019-12-31
 */
public interface HealthCardUserMapper extends IBaseMapper<HealthCardUser> {

    List<String> getByOpenId(@Param("openId") String openId,@Param("openIdType")  Integer openIdType);

}
