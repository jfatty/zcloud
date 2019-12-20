package com.jfatty.zcloud.auth.service;

/**
 * 描述
 *
 * @author jfatty on 2019/12/20
 * @email jfatty@163.com
 */
public interface SmsService {

    String sendSms(String phone,String code) throws Exception ;


}
