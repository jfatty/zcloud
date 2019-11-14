package com.jfatty.zcloud.system.service.impl;

import com.jfatty.zcloud.system.entity.DictionaryMenu;
import com.jfatty.zcloud.system.mapper.DictionaryMenuMapper;
import com.jfatty.zcloud.system.service.DictionaryMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述
 *
 * @author jfatty on 2019/11/13
 * @email jfatty@163.com
 */
@Slf4j
@Service
public class DictionaryMenuServiceImpl extends BaseSystemServiceImpl<DictionaryMenu,DictionaryMenuMapper> implements DictionaryMenuService {

    private DictionaryMenuMapper dictionaryMenuMapper ;

    @Autowired
    public void setDictionaryMenuMapper(DictionaryMenuMapper dictionaryMenuMapper) {
        super.setBaseMapper(dictionaryMenuMapper);
        this.dictionaryMenuMapper = dictionaryMenuMapper;
    }
}
