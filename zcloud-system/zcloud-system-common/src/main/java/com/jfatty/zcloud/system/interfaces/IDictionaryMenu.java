package com.jfatty.zcloud.system.interfaces;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.system.entity.DictionaryMenu;
import com.jfatty.zcloud.system.req.DictionaryMenuReq;
import com.jfatty.zcloud.system.res.DictionaryMenuRes;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @author jfatty on 2019/11/13
 * @email jfatty@163.com
 */
@RequestMapping(value={"/dictionaryMenu"})
public interface IDictionaryMenu extends BInterface<DictionaryMenu,DictionaryMenuReq,DictionaryMenuRes> {
}
