package com.jfatty.zcloud.auth.utils;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 描述
 *
 * @author jfatty on 2019/12/20
 * @email jfatty@163.com
 */
public class PhoneNumUtil implements Serializable {

    public static String  isPhone(String phone) {
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        if (phone.length() != 11) {
            return "手机号应为11位";
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            boolean isMatch = m.matches();
            if (!isMatch) {
                return "请填入正确的手机号";
            }
            return "";
        }
    }
}
