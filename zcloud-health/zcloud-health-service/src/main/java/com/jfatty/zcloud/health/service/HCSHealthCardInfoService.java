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

    /**
     * 通过身份证号获取电子健康卡信息
     * @param idNumber 身份证号码
     * @return
     */
    HCSHealthCardInfo getByIdCardNumber(String idNumber);

    String getNationDicStr(String source);

    List<HCSHealthCardInfo> getBatchHealthCardByInfoIds(List<String> healthCardInfoIds, String hospitalId);

    /**
     * 校验对应用户是否已经完成 批量建卡操作
     * @param idCard
     * @param brid
     * @param hospitalId
     * @return
     */
    boolean verification(String idCard, String brid,String hospitalId);
}
