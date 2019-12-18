package com.jfatty.zcloud.system.controller;

import com.jfatty.zcloud.base.controller.IBaseController;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.system.entity.Attachment;
import com.jfatty.zcloud.system.feign.AttachmentFeignClient;
import com.jfatty.zcloud.system.req.AttachmentReq;
import com.jfatty.zcloud.system.res.AttachmentRes;
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
public class AttachmentController implements IBaseController<Attachment,AttachmentReq,AttachmentRes> {

    @Autowired
    private AttachmentFeignClient attachmentFeignClient ;

    @Override
    public RELResultUtils<AttachmentRes> table(Map<String, Object> params) {
        return attachmentFeignClient.table(params);
    }

    @Override
    public RELResultUtils<AttachmentRes> table(String v, Integer pageIndex, Integer pageSize) {
        return attachmentFeignClient.table(v, pageIndex, pageSize);
    }

    @Override
    public Object list() {
        return attachmentFeignClient.list();
    }

    @Override
    public List<AttachmentRes> list(Long v) {
        return attachmentFeignClient.list(v);
    }

    @Override
    public Object save(AttachmentReq entity) {
        return attachmentFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return attachmentFeignClient.view(id);
    }

    @Override
    public Object edit(AttachmentReq entity) {
        return attachmentFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return attachmentFeignClient.delete(params);
    }
}
