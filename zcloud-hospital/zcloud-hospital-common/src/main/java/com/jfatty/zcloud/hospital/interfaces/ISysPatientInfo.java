package com.jfatty.zcloud.hospital.interfaces;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.hospital.entity.SysPatientInfo;
import com.jfatty.zcloud.hospital.req.SysPatientInfoReq;
import com.jfatty.zcloud.hospital.res.SysPatientInfoRes;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @author jfatty on 2019/12/12
 * @email jfatty@163.com
 */
@RequestMapping(value={"/sysPatientInfo"})
public interface ISysPatientInfo extends BInterface<SysPatientInfo,SysPatientInfoReq,SysPatientInfoRes> {


}
