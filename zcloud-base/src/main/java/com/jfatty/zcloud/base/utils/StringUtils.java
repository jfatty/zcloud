package com.jfatty.zcloud.base.utils;

import java.io.Serializable;

/**
 * 描述
 *
 * @author jfatty on 2019/2/17
 * @email jfatty@163.com
 */
public class StringUtils implements Serializable {


    public static String likeStrSQL(String source){
        source = verifyStrSQL(source);
        if (isNotEmptyAndBlank(source))
            source = "%" + source + "%" ;
        return source;
    }
    /**
     * 校验查询语句中的SQL注入问题
     * @param source
     * @return
     */
    public static String  verifyStrSQL(String source){
        if (isNotEmptyAndBlank(source)){
            if (source.contains("#"))
                source = source.replaceAll("#","");
            if (source.contains("-"))
                source = source.replaceAll("-","");
            return source;
        } else {
            return null ;
        }

    }

    /**
     * 为空或者是空字符串
     * @param cs
     * @return
     */
    public static boolean isEmptyOrBlank(CharSequence cs){
        return org.apache.commons.lang3.StringUtils.isEmpty(cs) || org.apache.commons.lang3.StringUtils.isBlank(cs);
    }

    /**
     * 非空
     * @param cs
     * @return
     */
    public static boolean isNotEmptyAndBlank(CharSequence cs){
        return org.apache.commons.lang3.StringUtils.isNotEmpty(cs) && org.apache.commons.lang3.StringUtils.isNotBlank(cs);
    }

    /**
     * 为空
     * @param cs
     * @return
     */
    public static boolean isEmpty(CharSequence cs){
        return org.apache.commons.lang3.StringUtils.isEmpty(cs) ;
    }

    /**
     * 不为空
     * @param cs
     * @return
     */
    public static boolean isNotEmpty(CharSequence cs){
        return !isEmpty(cs) ;
    }

    /**
     * 为空字符串
     * @param cs
     * @return
     */
    public static boolean isBlank(CharSequence cs){
        return org.apache.commons.lang3.StringUtils.isBlank(cs) ;
    }


    /**
     * 不为空字符串
     * @param cs
     * @return
     */
    public static boolean isNotBlank(CharSequence cs){
        return !isBlank(cs) ;
    }

}
