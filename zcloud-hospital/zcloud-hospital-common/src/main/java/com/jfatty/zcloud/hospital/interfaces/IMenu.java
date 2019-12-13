package com.jfatty.zcloud.hospital.interfaces;


import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.hospital.entity.Menu;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @author jfatty on 2019/12/12
 * @email jfatty@163.com
 */
@RequestMapping(value={"/menu"})
public interface IMenu extends BInterface<Menu> {

}
