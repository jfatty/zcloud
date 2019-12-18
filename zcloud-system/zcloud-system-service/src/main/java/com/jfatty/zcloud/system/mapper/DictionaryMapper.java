package com.jfatty.zcloud.system.mapper;

import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.system.entity.Dictionary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/11/13
 * @email jfatty@163.com
 */
public interface DictionaryMapper  extends IBaseMapper<Dictionary> {

    List<Dictionary> getByDictionaryMenu(@Param("dictionaryMenuId") String dictionaryMenuId);

}
