package com.jfatty.zcloud.system.interfaces;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.system.entity.Attachment;
import com.jfatty.zcloud.system.req.AttachmentReq;
import com.jfatty.zcloud.system.res.AttachmentRes;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @author jfatty on 2019/11/1
 * @email jfatty@163.com
 */
@RequestMapping(value={"/attachment"})
public interface IAttachment  extends BInterface<Attachment,AttachmentReq,AttachmentRes> {

}
