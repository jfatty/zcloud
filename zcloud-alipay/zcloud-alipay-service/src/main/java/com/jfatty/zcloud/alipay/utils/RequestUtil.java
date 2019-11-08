package com.jfatty.zcloud.alipay.utils;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 描述 解析HttpServletRequest参数
 *
 * @author jfatty on 2019/11/8
 * @email jfatty@163.com
 */
@Slf4j
public class RequestUtil {

    /**
     * 获取所有request请求参数key-value
     *
     * @param request
     * @return
     */
    public static Map<String, String> getRequestParams(HttpServletRequest request){
        log.error("CharacterEncoding ============================> " + request.getCharacterEncoding());
        Map<String, String> params = new HashMap<String, String>();
        if(null != request){
            Set<String> paramsKey = request.getParameterMap().keySet();
            for(String key : paramsKey){
                params.put(key, request.getParameter(key));
            }
        }
        return params;
    }
}
