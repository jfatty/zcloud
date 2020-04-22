package com.jfatty.zcloud.hospital.controller;

import com.jfatty.zcloud.base.controller.IBaseController;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.hospital.entity.MailConfig;
import com.jfatty.zcloud.hospital.feign.MailConfigFeignClient;
import com.jfatty.zcloud.hospital.req.MailConfigReq;
import com.jfatty.zcloud.hospital.res.MailConfigRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 描述 智慧医疗邮件发送配置
 *
 * @author jfatty on 2020/4/22
 * @email jfatty@163.com
 */

@Slf4j
@RestController
@RequestMapping("/mailConfig")
public class MailConfigController implements IBaseController<MailConfig,MailConfigReq,MailConfigRes> {


    @Autowired
    private MailConfigFeignClient mailConfigFeignClient ;

    @Override
    public RELResultUtils<MailConfigRes> table(Map<String, Object> params) {
        return mailConfigFeignClient.table(params);
    }

    @Override
    public RELResultUtils<MailConfigRes> table(String v, Integer pageIndex, Integer pageSize) {
        return mailConfigFeignClient.table(v,pageIndex,pageSize);
    }

    @Override
    public Object list() {
        return mailConfigFeignClient.list();
    }

    @Override
    public List<MailConfigRes> list(Long v) {
        return mailConfigFeignClient.list(v);
    }

    @Override
    public Object save(MailConfigReq entity) {
        return mailConfigFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return mailConfigFeignClient.view(id);
    }

    @Override
    public Object edit(MailConfigReq entity) {
        return mailConfigFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return mailConfigFeignClient.delete(params);
    }
}
