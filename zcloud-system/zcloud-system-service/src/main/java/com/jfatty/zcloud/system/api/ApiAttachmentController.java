package com.jfatty.zcloud.system.api;


import com.jfatty.zcloud.system.entity.Attachment;
import com.jfatty.zcloud.system.interfaces.IAttachment;
import com.jfatty.zcloud.system.req.AttachmentReq;
import com.jfatty.zcloud.system.res.AttachmentRes;
import com.jfatty.zcloud.system.service.AttachmentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述
 *
 * @author jfatty on 2019/11/1
 * @email jfatty@163.com
 */
@Api(tags = "系统附件API" ,value = "系统附件")
@RestController
@RequestMapping(value={"/api/attachment"})
public class ApiAttachmentController extends ApiBaseSystemController<Attachment,AttachmentReq,AttachmentRes>  implements IAttachment {

    private AttachmentService attachmentService ;

    @Autowired
    public void setAttachmentService(AttachmentService attachmentService) {
        super.setBaseService(attachmentService);
        this.attachmentService = attachmentService;
    }

}
