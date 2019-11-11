package com.jfatty.zcloud.alipay.filter;

import org.springframework.core.Ordered;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述 自定义EncodingFilter，实现多字符集的处理
 * @author jfatty on 2019/4/23
 * @email jfatty@163.com
 */
public class MutiCharacterEncodingFilter extends CharacterEncodingFilter implements Ordered {


    //最高优先级
    private int order = Integer.MIN_VALUE;

    private List<String> mutiUrls = new ArrayList<String>();

    private String mutiCharset =  "GBK";


    public List<String> getMutiUrls() {
        return mutiUrls;
    }

    public void setMutiUrls(List<String> mutiUrls) {
        this.mutiUrls = mutiUrls;
    }

    public String getMutiCharset() {
        return mutiCharset;
    }

    public void setMutiCharset(String mutiCharset) {
        this.mutiCharset = mutiCharset;
    }


    /**
     * @param charset
     * @param mutiCharset
     * @param mutiUrls
     * @param forceRequest
     * @param forceResponse
     */
    public MutiCharacterEncodingFilter(String charset, String mutiCharset , List<String> mutiUrls, boolean forceRequest, boolean forceResponse) {
        super(charset,forceRequest,forceResponse);
        this.mutiUrls = mutiUrls;
        this.mutiCharset = mutiCharset;

    }

    public MutiCharacterEncodingFilter() {
        super();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String path = request.getRequestURI();
        //如果是这个链接 执行mutyEncoding方法
        if(matchAny(mutiUrls,path)){
            if (mutiCharset != null) {
                if (isForceRequestEncoding() || request.getCharacterEncoding() == null) {
                    request.setCharacterEncoding(mutiCharset);
                }
                if (isForceResponseEncoding()) {
                    response.setCharacterEncoding(mutiCharset);
                }
            }
            filterChain.doFilter(request,response);
            return ;
        }

        //否则 使用默认方法
        super.doFilterInternal(request,response,filterChain);

    }

    @Override
    public int getOrder() {
        return order ;
    }

    /**
     * 编码路径匹配
     * @param mutiUrls 需要重新编码的路径地址
     * @param path  URI路径
     * @return
     */
    private boolean matchAny(List<String> mutiUrls , String path){
        for (String url : mutiUrls){
            if (path.contains(url))
                return true ;
        }
        return false ;
    }
}
