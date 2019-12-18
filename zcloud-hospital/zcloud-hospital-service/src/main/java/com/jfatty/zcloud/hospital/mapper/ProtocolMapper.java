package com.jfatty.zcloud.hospital.mapper;

import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.hospital.entity.Protocol;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 协议或用户需知表 Mapper 接口
 * </p>
 *
 * @author jfatty
 * @since 2019-12-12
 */
public interface ProtocolMapper extends IBaseMapper<Protocol> {

    List<Protocol> getByDiffs(@Param("version") String version,@Param("opcode")  String opcode);
}
