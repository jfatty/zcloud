package com.jfatty.zcloud.system.controller;

import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.system.entity.Dictionary;
import com.jfatty.zcloud.system.feign.DictionaryFeignClient;
import com.jfatty.zcloud.system.interfaces.IDictionary;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 描述
 *
 * @author jfatty on 2019/11/13
 * @email jfatty@163.com
 */
@Slf4j
@RestController
public class DictionaryController implements IDictionary {

    @Autowired
    private DictionaryFeignClient dictionaryFeignClient ;


    @Override
    public RELResultUtils<Dictionary> table(Map<String, Object> params) {
        return dictionaryFeignClient.table(params);
    }

    @Override
    public RELResultUtils<Dictionary> table(String v, Integer pageIndex, Integer pageSize) {
        return dictionaryFeignClient.table(v, pageIndex, pageSize);
    }

    @Override
    public List<Dictionary> list() {
        return dictionaryFeignClient.list();
    }

    @Override
    public Object save(Dictionary entity) {
        return dictionaryFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return dictionaryFeignClient.view(id);
    }

    @Override
    public Object edit(Dictionary entity) {
        return dictionaryFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return dictionaryFeignClient.delete(params);
    }
}
