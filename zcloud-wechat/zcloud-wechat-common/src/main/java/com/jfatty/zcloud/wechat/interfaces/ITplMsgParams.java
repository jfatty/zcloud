package com.jfatty.zcloud.wechat.interfaces;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.wechat.entity.TplMsgParams;
import com.jfatty.zcloud.wechat.req.TplMsgParamsReq;
import com.jfatty.zcloud.wechat.res.TplMsgParamsRes;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @author jfatty on 2020/1/5
 * @email jfatty@163.com
 */

@RequestMapping(value={"/tplMsgParams "})
public interface ITplMsgParams   extends BInterface<TplMsgParams,TplMsgParamsReq,TplMsgParamsRes> {

}
