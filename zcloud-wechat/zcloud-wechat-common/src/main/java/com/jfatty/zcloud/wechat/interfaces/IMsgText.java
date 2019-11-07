package com.jfatty.zcloud.wechat.interfaces;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.wechat.entity.MsgText;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @author jfatty on 2019/11/7
 * @email jfatty@163.com
 */
@RequestMapping(value={"/msgText"})
public interface IMsgText   extends BInterface<MsgText> {
}
