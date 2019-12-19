package com.jfatty.zcloud.hospital.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * 描述
 *
 * @author jfatty on 2019/12/19
 * @email jfatty@163.com
 */
public class IPUtil implements Serializable {

    /**
     * 获取request中的真实IP
     *
     * @param request
     * @return
     */
    public static String getRealIp(HttpServletRequest request) {
        try {
            String ip = "";
            ip = request.getHeader("X-Forwarded-For");
            if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
                int index = ip.indexOf(",");                                        //多次反向代理后会有多个ip值，第一个ip才是真实ip
                if (index != -1) {
                    return ip.substring(0, index);
                } else {
                    return ip;
                }
            }
            ip = request.getHeader("X-Real-IP");
            if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
                int index = ip.indexOf(",");
                if (index != -1) {
                    return ip.substring(0, index);
                } else {
                    return ip;
                }
            }
            ip = request.getHeader("Proxy-Client-IP");
            if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
                int index = ip.indexOf(",");
                if (index != -1) {
                    return ip.substring(0, index);
                } else {
                    return ip;
                }
            }
            ip = request.getHeader("WL-Proxy-Client-IP");
            if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
                int index = ip.indexOf(",");
                if (index != -1) {
                    return ip.substring(0, index);
                } else {
                    return ip;
                }
            }
            ip = request.getRemoteAddr();
            return ip;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

}
