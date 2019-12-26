package com.jfatty.zcloud.health.service;

import com.jfatty.zcloud.health.entity.HealthCardSettings;
import com.jfatty.zcloud.health.vo.HCSIDCardInfoVO;

/**
 * 描述
 *
 * @author jfatty on 2019/12/26
 * @email jfatty@163.com
 */
public interface HealthCardStationService extends BaseHealthService<HealthCardSettings> {

    HCSIDCardInfoVO ocrInfo(String appId,String imageContent) throws Exception ;

}
