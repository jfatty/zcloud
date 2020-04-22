package com.jfatty.zcloud.hospital.service.impl;

import com.jfatty.zcloud.base.holder.ApplicationContextHolder;
import com.jfatty.zcloud.hospital.entity.MailConfig;
import com.jfatty.zcloud.hospital.mapper.MailConfigMapper;
import com.jfatty.zcloud.hospital.service.MailConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 智慧医疗邮件发送配置 服务实现类
 * </p>
 *
 * @author jfatty
 * @since 2020-04-22
 */
@Slf4j
@Service
public class MailConfigServiceImpl extends BaseHospitalServiceImpl<MailConfig, MailConfigMapper> implements MailConfigService {

    private MailConfigMapper mailConfigMapper ;

    @Autowired
    public void setMailConfigMapper(MailConfigMapper mailConfigMapper) {
        super.setBaseMapper(mailConfigMapper);
        this.mailConfigMapper = mailConfigMapper;
    }

    @Override
    public void sendErrorMail(String title, String content) {
        MailConfig mailConfig = mailConfigMapper.getActMailConfig();
        if ( mailConfig != null ){
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(mailConfig.getSenderAccount());
            mailMessage.setTo(mailConfig.getReceiverAccount());
            mailMessage.setSubject(title);
            mailMessage.setText(content);
            JavaMailSenderImpl javaMailSender = ApplicationContextHolder.getBean(JavaMailSenderImpl.class);
            javaMailSender.send(mailMessage);
            log.error("===>邮件发送成功 邮件标题[{}] 邮件内容[{}]",title,content);
        } else {
            log.error("===>邮件发送失败 未激活默认邮件发送配置 失败邮件标题[{}] 失败邮件内容[{}]",title,content);
        }

    }
}
