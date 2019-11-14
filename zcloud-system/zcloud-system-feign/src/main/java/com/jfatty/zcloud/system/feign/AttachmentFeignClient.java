package com.jfatty.zcloud.system.feign;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.system.entity.Attachment;
import org.springframework.cloud.openfeign.FeignClient;


/**
 * 描述
 *
 * @author jfatty on 2019/11/12
 * @email jfatty@163.com
 */
@FeignClient(value = "zcloud-system-service" , path = "/api/attachment")
public interface AttachmentFeignClient extends BInterface<Attachment> {


}
