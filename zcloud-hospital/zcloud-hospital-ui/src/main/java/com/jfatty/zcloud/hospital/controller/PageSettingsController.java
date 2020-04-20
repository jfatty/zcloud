package com.jfatty.zcloud.hospital.controller;

import com.jfatty.zcloud.base.controller.IBaseController;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.hospital.entity.HOSPageSettings;
import com.jfatty.zcloud.hospital.feign.PageSettingsFeignClient;
import com.jfatty.zcloud.hospital.req.HOSPageSettingsReq;
import com.jfatty.zcloud.hospital.res.HOSPageSettingsRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 描述 智慧医疗页面配置信息表 前端控制器
 *
 * @author jfatty on 2020/4/17
 * @email jfatty@163.com
 */
@Slf4j
@RestController
@RequestMapping("/pageSettings")
public class PageSettingsController implements IBaseController<HOSPageSettings,HOSPageSettingsReq,HOSPageSettingsRes> {

    @Autowired
    private PageSettingsFeignClient pageSettingsFeignClient ;

    @Override
    public RELResultUtils<HOSPageSettingsRes> table(Map<String, Object> params) {
        return pageSettingsFeignClient.table(params);
    }

    @Override
    public RELResultUtils<HOSPageSettingsRes> table(String v, Integer pageIndex, Integer pageSize) {
        return pageSettingsFeignClient.table(v,pageIndex,pageSize);
    }

    @Override
    public Object list() {
        return pageSettingsFeignClient.list();
    }

    @Override
    public List<HOSPageSettingsRes> list(Long v) {
        return pageSettingsFeignClient.list(v);
    }

    @Override
    public Object save(HOSPageSettingsReq entity) {
        return pageSettingsFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return pageSettingsFeignClient.view(id);
    }

    @Override
    public Object edit(HOSPageSettingsReq entity) {
        return pageSettingsFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return pageSettingsFeignClient.delete(params);
    }

}
