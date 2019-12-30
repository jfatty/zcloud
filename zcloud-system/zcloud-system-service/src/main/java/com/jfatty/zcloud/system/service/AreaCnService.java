package com.jfatty.zcloud.system.service;

import com.jfatty.zcloud.system.entity.AreaCn;

import java.util.List;

/**
 * <p>
 * 中国行政地区表 服务类
 * </p>
 *
 * @author jfatty
 * @since 2019-12-27
 */
public interface AreaCnService extends BaseSystemService<AreaCn> {

    List<AreaCn> getLevelList(String parentId, Integer level, String name, String shortName);
}
