package com.jfatty.zcloud.system.controller;

import com.jfatty.zcloud.base.controller.IBaseController;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.system.entity.Dictionary;
import com.jfatty.zcloud.system.feign.DictionaryFeignClient;
import com.jfatty.zcloud.system.req.DictionaryReq;
import com.jfatty.zcloud.system.res.DictionaryRes;
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
@RequestMapping(value={"/dictionary"})
public class DictionaryController implements IBaseController<Dictionary,DictionaryReq,DictionaryRes> {

    @Autowired
    private DictionaryFeignClient dictionaryFeignClient ;


    @Override
    public RELResultUtils<DictionaryRes> table(Map<String, Object> params) {
        return dictionaryFeignClient.table(params);
    }

    @Override
    public RELResultUtils<DictionaryRes> table(String v, Integer pageIndex, Integer pageSize) {
        return dictionaryFeignClient.table(v, pageIndex, pageSize);
    }

    @Override
    public Object list() {
        return dictionaryFeignClient.list();
    }

    @Override
    public List<DictionaryRes> list(Long v) {
        return dictionaryFeignClient.list(v);
    }

    @Override
    public Object save(DictionaryReq entity) {
        return dictionaryFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return dictionaryFeignClient.view(id);
    }

    @Override
    public Object edit(DictionaryReq entity) {
        return dictionaryFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return dictionaryFeignClient.delete(params);
    }
}
