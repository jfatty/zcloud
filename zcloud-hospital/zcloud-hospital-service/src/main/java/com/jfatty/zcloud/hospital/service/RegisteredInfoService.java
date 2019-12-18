package com.jfatty.zcloud.hospital.service;

import com.jfatty.zcloud.hospital.entity.RegisteredInfo;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/12/18
 * @email jfatty@163.com
 */
public interface RegisteredInfoService {

    List<RegisteredInfo> getRegisteredInfo(String name, String idCard, String dateTime);

}
