package com.jfatty.zcloud.system.controller;

import com.jfatty.zcloud.base.controller.IBaseController;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.base.utils.ResultUtils;
import com.jfatty.zcloud.system.entity.AccountUnique;
import com.jfatty.zcloud.system.entity.Dictionary;
import com.jfatty.zcloud.system.entity.DictionaryMenu;
import com.jfatty.zcloud.system.feign.DictionaryMenuFeignClient;
import com.jfatty.zcloud.system.interfaces.IDictionaryMenu;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping(value={"/dictionaryMenu"})
public class DictionaryMenuController implements IBaseController<DictionaryMenu> {

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
    public Object list() {
        return dictionaryMenuFeignClient.list();
    }

    @Override
    public List<DictionaryMenu> list(Long v) {
        return dictionaryMenuFeignClient.list(v);
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
