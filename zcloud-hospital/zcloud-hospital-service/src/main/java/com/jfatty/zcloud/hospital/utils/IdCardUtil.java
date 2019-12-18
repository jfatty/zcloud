package com.jfatty.zcloud.hospital.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * 身份证信息处理工具类
 */
public class IdCardUtil implements Serializable {


    /**
     * 身份证号加星操作
     * @param source
     * @return
     */
    public static  String coverStarts(String source,int start, int end){
        if(StringUtils.isNotBlank(source) && StringUtils.isNotEmpty(source) && source.length() > 11){
            StringBuilder sb = new StringBuilder(source);
            sb.replace(start, end, "********");
            return sb.toString();
        }
        return source ;
    }

    /**
     * 用户身份证号码的打码隐藏加星号加*
     * <p>18位和非18位身份证处理均可成功处理</p>
     * <p>参数异常直接返回null</p>
     * @param idCardNum 身份证号码
     * @param front     需要显示前几位
     * @param end       需要显示末几位
     * @return 处理完成的身份证
     */
    public static String idMask(String idCardNum, int front, int end) {
        //身份证不能为空
        if (StringUtils.isEmpty(idCardNum)) {
            return null;
        }
        //需要截取的长度不能大于身份证号长度
        if ((front + end) > idCardNum.length()) {
            return null;
        }
        //需要截取的不能小于0
        if (front < 0 || end < 0) {
            return null;
        }
        //计算*的数量
        int asteriskCount = idCardNum.length() - (front + end);
        StringBuffer asteriskStr = new StringBuffer();
        for (int i = 0; i < asteriskCount; i++) {
            asteriskStr.append("*");
        }
        String regex = "(\\w{" + String.valueOf(front) + "})(\\w+)(\\w{" + String.valueOf(end) + "})";
        return idCardNum.replaceAll(regex, "$1" + asteriskStr + "$3");
    }


}