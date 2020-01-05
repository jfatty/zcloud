package com.jfatty.zcloud.wechat.mapper;

import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.wechat.entity.TplMsgParams;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 微信模板消息参数配置表 Mapper 接口
 * </p>
 *
 * @author jfatty
 * @since 2020-01-05
 */
public interface TplMsgParamsMapper extends IBaseMapper<TplMsgParams> {


    List<TplMsgParams> getTplById(@Param("tplId") String tplId) ;
}
