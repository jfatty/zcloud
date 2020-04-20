package com.jfatty.zcloud.hospital.service;

import com.jfatty.zcloud.hospital.entity.Protocol;

import java.util.List;

/**
 * <p>
 * 协议或用户需知表 服务类
 * </p>
 *
 * @author jfatty
 * @since 2019-12-12
 */
public interface ProtocolService extends BaseHospitalService<Protocol> {

    List<Protocol> getByDiffs(String appId, String version, String opcode);

    List<Protocol> getProtocol(String appId, String version, String pageId);
}
