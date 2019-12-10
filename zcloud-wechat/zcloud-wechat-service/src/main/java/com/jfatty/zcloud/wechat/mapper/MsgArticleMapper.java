package com.jfatty.zcloud.wechat.mapper;


import com.jfatty.zcloud.wechat.entity.MsgArticle;

import java.io.Serializable;

/**
 * <p>
 * 微信文章 Mapper 接口
 * </p>
 *
 * @author jfatty
 * @since 2019-08-22
 */
public interface MsgArticleMapper  {


    MsgArticle getById(Serializable id);

}
