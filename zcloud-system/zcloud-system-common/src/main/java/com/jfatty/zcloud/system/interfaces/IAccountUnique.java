package com.jfatty.zcloud.system.interfaces;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.system.entity.AccountUnique;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @author jfatty on 2019/11/7
 * @email jfatty@163.com
 */
@RequestMapping(value={"/accountUnique"})
public interface IAccountUnique  extends BInterface<AccountUnique> {



}
