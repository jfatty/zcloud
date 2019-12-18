package com.jfatty.zcloud.hospital.interfaces;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.hospital.entity.Protocol;
import com.jfatty.zcloud.hospital.req.ProtocolReq;
import com.jfatty.zcloud.hospital.res.ProtocolRes;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @author jfatty on 2019/12/12
 * @email jfatty@163.com
 */
@RequestMapping(value={"/protocol"})
public interface IProtocol extends BInterface<Protocol,ProtocolReq,ProtocolRes> {

}
