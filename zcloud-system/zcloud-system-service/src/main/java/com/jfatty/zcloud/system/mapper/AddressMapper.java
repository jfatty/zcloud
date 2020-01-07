package com.jfatty.zcloud.system.mapper;

import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.system.entity.Address;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 公用地址表 Mapper 接口
 * </p>
 *
 * @author jfatty
 * @since 2019-12-13
 */
public interface AddressMapper extends IBaseMapper<Address> {

    Address getByBelongId(@Param("belongId") String belongId);
}
