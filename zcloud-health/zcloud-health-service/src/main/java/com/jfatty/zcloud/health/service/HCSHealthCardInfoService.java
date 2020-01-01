package com.jfatty.zcloud.health.service;

import com.jfatty.zcloud.health.entity.HCSHealthCardInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jfatty
 * @since 2019-12-26
 */
public interface HCSHealthCardInfoService extends BaseHealthService<HCSHealthCardInfo> {

    HCSHealthCardInfo getByIdCardNumber(String idNumber);

    String getNationDicStr(String source);

    List<HCSHealthCardInfo> getBatchHealthCardByInfoIds(List<String> healthCardInfoIds, String hospitalId);
}
