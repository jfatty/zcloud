package com.jfatty.zcloud.health.service;

import com.jfatty.zcloud.health.entity.HCSHealthCardInfo;
import com.jfatty.zcloud.health.vo.RegHealthCardInfoVO;

/**
 * 描述 电子健康卡信息同步HIS接口
 *
 * @author jfatty on 2020/5/11
 * @email jfatty@163.com
 */
public interface HealthCard2HISService {


    RegHealthCardInfoVO regHealthCardInfo(HCSHealthCardInfo hcsHealthCardInfo) throws Exception ;
}
