package com.jfatty.zcloud.system.service.impl;

import com.jfatty.zcloud.system.entity.Dictionary;
import com.jfatty.zcloud.system.mapper.DictionaryMapper;
import com.jfatty.zcloud.system.service.DictionaryService;
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
public class DictionaryServiceImpl extends BaseSystemServiceImpl<Dictionary,DictionaryMapper> implements DictionaryService {

    private DictionaryMapper dictionaryMapper ;


    @Autowired
    public void setDictionaryMapper(DictionaryMapper dictionaryMapper) {
        super.setBaseMapper(dictionaryMapper);
        this.dictionaryMapper = dictionaryMapper;
    }
}
