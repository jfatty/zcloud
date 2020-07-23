package com.jfatty.zcloud.health.mapper;

import com.jfatty.zcloud.health.entity.HCSHealthCardInfo;
import com.jfatty.zcloud.health.vo.RegHealthCardInfoVO;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 描述 电子健康卡信息同步HIS Mapper 接口
 *
 * @author jfatty on 2020/5/11
 * @email jfatty@163.com
 */
public interface HealthCard2HISMapper {


    RegHealthCardInfoVO regHealthCardInfo(HCSHealthCardInfo hcsHealthCardInfo);

}
