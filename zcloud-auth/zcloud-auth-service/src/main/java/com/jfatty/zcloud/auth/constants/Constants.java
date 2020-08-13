package com.jfatty.zcloud.auth.constants;

public class Constants {

    /**
     * 散列算法
     */
    public static final String ALGORITHM_NAME = "md5";

    /**
     * 循环次数
     */
    public static final int HASH_ITERATIONS = 2 ;

    public static final String LOGIN_URL = "/login";

    public static final  String SUCCESS_URL = "/index";

    public static final  String UNAUTHORIZED_URL = "/errorView/403_error.html";

    /**
     * 这个是服务端要返回给客户端，
     */
    public final static String TOKEN_NAME = "TOKEN";
    /**
     * 这个是客户端请求给服务端带的header
     */
    public final static String HEADER_TOKEN_NAME = "token";
    /**
     *
     */
    private static final String REFERENCED_SESSION_ID_SOURCE = "mp request";



}
