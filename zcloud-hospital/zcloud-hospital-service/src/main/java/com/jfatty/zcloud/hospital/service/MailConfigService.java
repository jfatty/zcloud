package com.jfatty.zcloud.hospital.service;

import com.jfatty.zcloud.hospital.entity.MailConfig;

/**
 * <p>
 * 智慧医疗邮件发送配置 服务类
 * </p>
 *
 * @author jfatty
 * @since 2020-04-22
 */
public interface MailConfigService extends BaseHospitalService<MailConfig> {

    void sendErrorMail(String title, String content);
}
