package com.jfatty.zcloud.alipay.mapper;

import com.jfatty.zcloud.alipay.entity.AlipayNewsitem;
import com.jfatty.zcloud.base.mapper.IBaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/11/8
 * @email jfatty@163.com
 */
public interface AlipayNewsitemMapper extends IBaseMapper<AlipayNewsitem> {

    List<AlipayNewsitem> getAlipayNewsitemByTemplateId(@Param("newsTemplateId") String newsTemplateId);

}
