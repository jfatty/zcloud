package com.jfatty.zcloud.system.controller;

import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.system.entity.DictionaryMenu;
import com.jfatty.zcloud.system.feign.DictionaryMenuFeignClient;
import com.jfatty.zcloud.system.interfaces.IDictionaryMenu;
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
public class DictionaryMenuController implements IDictionaryMenu {

    @Autowired
    private DictionaryMenuFeignClient dictionaryMenuFeignClient ;

    @Override
    public RELResultUtils<DictionaryMenu> table(Map<String, Object> params) {
        return dictionaryMenuFeignClient.table(params);
    }

    @Override
    public RELResultUtils<DictionaryMenu> table(String v, Integer pageIndex, Integer pageSize) {
        return dictionaryMenuFeignClient.table(v, pageIndex, pageSize);
    }

    @Override
    public List<DictionaryMenu> list() {
        return dictionaryMenuFeignClient.list();
    }

    @Override
    public Object save(DictionaryMenu entity) {
        return dictionaryMenuFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return dictionaryMenuFeignClient.view(id);
    }

    @Override
    public Object edit(DictionaryMenu entity) {
        return dictionaryMenuFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return dictionaryMenuFeignClient.delete(params);
    }
}
