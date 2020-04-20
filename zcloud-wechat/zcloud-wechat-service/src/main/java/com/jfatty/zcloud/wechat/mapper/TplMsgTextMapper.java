package com.jfatty.zcloud.wechat.mapper;


import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.wechat.entity.TplMsgText;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 微信模板消息 Mapper 接口
 * </p>
 *
 * @author jfatty
 * @since 2019-04-23
 */
public interface TplMsgTextMapper extends IBaseMapper<TplMsgText> {

    TplMsgText getByAccount(@Param("account") String account, @Param("kw") String kw);
}
