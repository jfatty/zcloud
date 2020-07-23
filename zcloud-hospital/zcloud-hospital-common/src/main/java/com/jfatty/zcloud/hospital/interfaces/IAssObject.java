package com.jfatty.zcloud.hospital.interfaces;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.hospital.entity.AssObject;
import com.jfatty.zcloud.hospital.req.AssObjectReq;
import com.jfatty.zcloud.hospital.res.AssObjectRes;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述 量表关联对象
 *
 * @author jfatty on 2020/6/10
 * @email jfatty@163.com
 */
@RequestMapping(value={"/assObject"})
public interface IAssObject  extends BInterface<AssObject,AssObjectReq,AssObjectRes> {

}
