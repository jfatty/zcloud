package com.jfatty.zcloud.alipay.mapper;

import com.jfatty.zcloud.alipay.entity.AlipayAutoresponseDefault;
import com.jfatty.zcloud.base.mapper.IBaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/11/8
 * @email jfatty@163.com
 */
public interface AlipayAutoresponseDefaultMapper extends IBaseMapper<AlipayAutoresponseDefault> {


    List<AlipayAutoresponseDefault> getAutoresponseDefault(@Param("accountId") String accountId, @Param("isWork") String isWork);

}
