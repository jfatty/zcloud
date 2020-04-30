package com.jfatty.zcloud.hospital.interfaces;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.hospital.entity.TreatGuide;
import com.jfatty.zcloud.hospital.req.TreatGuideReq;
import com.jfatty.zcloud.hospital.res.TreatGuideRes;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述 就诊指南
 *
 * @author jfatty on 2020/4/28
 * @email jfatty@163.com
 */
@RequestMapping(value={"/treatGuide"})
public interface ITreatGuide extends BInterface<TreatGuide,TreatGuideReq,TreatGuideRes> {



}
