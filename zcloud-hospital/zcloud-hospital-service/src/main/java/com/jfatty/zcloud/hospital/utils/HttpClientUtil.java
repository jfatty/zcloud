package com.jfatty.zcloud.hospital.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 描述 建行支付http请求工具类
 *
 * @author jfatty on 2020/7/15
 * @email jfatty@163.com
 */
@Slf4j
public class HttpClientUtil implements Serializable {

    private static HttpClient httpClient = new DefaultHttpClient();

    /**
     * 发送 get 请求
     *
     * @param url
     * @return
     */
    public static String get(String url) {
        String body = null;
        try {
            // get 请求
            HttpGet httpGet = new HttpGet(url);
            // 发送请求
            HttpResponse httpresponse = httpClient.execute(httpGet);
            // 获取返回数据
            HttpEntity entity = httpresponse.getEntity();
            body = EntityUtils.toString(entity, "UTF-8");
            if (entity != null) {
                entity.consumeContent();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return body;
    }

    /**
     * 发送get 请求
     *
     * @param url
     * @param params
     * @return
     */
    public static String get(String url, List<NameValuePair> params) {
        String body = null;
        try {
            HttpGet httpGet = new HttpGet(url);
            String data = EntityUtils.toString(new UrlEncodedFormEntity(params));
            httpGet.setURI(new URI(httpGet.getURI().toString() + "?" + data));
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity entity = httpResponse.getEntity();
            body = EntityUtils.toString(entity, "UTF-8");
            if (entity != null) {
                entity.consumeContent();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return body;
    }

    /**
     * post
     *
     * @param url
     * @param params
     * @return
     */
    public static String post(String url, List<NameValuePair> params) {
        String body = null;
        try {
            if (httpClient == null) {
                httpClient = new DefaultHttpClient();
            }
            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity entity = httpResponse.getEntity();
            body = EntityUtils.toString(entity, "UTF-8");
            if (entity != null) {
                entity.consumeContent();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return body;
    }

    /**
     * 以 closeableHttpClient方式 发送get 请求
     *
     * @param url
     * @return
     */
    public static String getCloseableHttpResponse(String url) {
        String body = null;
        try {
            CloseableHttpClient client = HttpClients.custom().build();
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse chr = client.execute(httpGet);
            String data = EntityUtils.toString(chr.getEntity(), "UTF-8");
            JSONObject json = JSON.parseObject(data);
            body = json.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return body;
    }

    /**
     * post 请求
     * @param url
     * @param param
     * @return
     */
    public static String doPost(String url, Map<String, String> param) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            HttpPost httpPost = new HttpPost(url);
            if (param != null) {
                List<NameValuePair> paramList = new ArrayList<>();
                for (String key : param.keySet()) {
                    paramList.add(new BasicNameValuePair(key, param.get(key)));
                }
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList, "utf-8");
                httpPost.setEntity(entity);
            }
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            log.error("====>  向建行服务端发起请求时出现异常[{}]",e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                log.error("====>  关闭建行服务端响应流时出现异常[{}]",e.getMessage());
                e.printStackTrace();
            }
        }
        return resultString;
    }

}
