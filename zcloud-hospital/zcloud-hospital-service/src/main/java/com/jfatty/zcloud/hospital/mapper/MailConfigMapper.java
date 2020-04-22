package com.jfatty.zcloud.hospital.mapper;

import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.hospital.entity.MailConfig;

/**
 * <p>
 * 智慧医疗邮件发送配置 Mapper 接口
 * </p>
 *
 * @author jfatty
 * @since 2020-04-22
 */
public interface MailConfigMapper extends IBaseMapper<MailConfig> {

    MailConfig getActMailConfig();
}
