package com.jfatty.zcloud.system.controller;

import com.jfatty.zcloud.base.controller.IBaseController;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.base.utils.ResultUtils;
import com.jfatty.zcloud.system.entity.AccountUnique;
import com.jfatty.zcloud.system.entity.Attachment;
import com.jfatty.zcloud.system.feign.AttachmentFeignClient;
import com.jfatty.zcloud.system.interfaces.IAttachment;
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
@RequestMapping(value={"/attachment"})
public class AttachmentController implements IBaseController<Attachment> {

    @Autowired
    private AttachmentFeignClient attachmentFeignClient ;

    @Override
    public RELResultUtils<Attachment> table(Map<String, Object> params) {
        return attachmentFeignClient.table(params);
    }

    @Override
    public RELResultUtils<Attachment> table(String v, Integer pageIndex, Integer pageSize) {
        return attachmentFeignClient.table(v, pageIndex, pageSize);
    }

    @Override
    public Object list() {
        return attachmentFeignClient.list();
    }

    @Override
    public List<Attachment> list(Long v) {
        return attachmentFeignClient.list(v);
    }

    @Override
    public Object save(Attachment entity) {
        return attachmentFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return attachmentFeignClient.view(id);
    }

    @Override
    public Object edit(Attachment entity) {
        return attachmentFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return attachmentFeignClient.delete(params);
    }
}
