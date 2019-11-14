package com.jfatty.zcloud.system.api;


import com.jfatty.zcloud.system.entity.Attachment;
import com.jfatty.zcloud.system.interfaces.IAttachment;
import com.jfatty.zcloud.system.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述
 *
 * @author jfatty on 2019/11/1
 * @email jfatty@163.com
 */
@RestController
@RequestMapping(value={"/api/attachment"})
public class ApiAttachmentController extends ApiBaseSystemController<Attachment>  implements IAttachment {

    private AttachmentService attachmentService ;

    @Autowired
    public void setAttachmentService(AttachmentService attachmentService) {
        super.setBaseService(attachmentService);
        this.attachmentService = attachmentService;
    }

}
