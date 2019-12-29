package com.jfatty.zcloud.auth.service;

import com.jfatty.zcloud.auth.entity.AuthSmsConfig;

/**
 * 描述
 *
 * @author jfatty on 2019/12/20
 * @email jfatty@163.com
 */
public interface SmsService {

    String sendSms(String phone,String code) throws Exception ;

    String sendSms(AuthSmsConfig authSmsConfig,String phone,String code) throws Exception ;




}
