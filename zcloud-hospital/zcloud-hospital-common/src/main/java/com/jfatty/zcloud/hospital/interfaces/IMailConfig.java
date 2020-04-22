package com.jfatty.zcloud.hospital.interfaces;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.hospital.entity.MailConfig;
import com.jfatty.zcloud.hospital.req.MailConfigReq;
import com.jfatty.zcloud.hospital.res.MailConfigRes;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述 智慧医疗邮件发送配置
 *
 * @author jfatty on 2020/4/22
 * @email jfatty@163.com
 */
@RequestMapping(value={"/mailConfig"})
public interface IMailConfig extends BInterface<MailConfig,MailConfigReq,MailConfigRes> {
}
