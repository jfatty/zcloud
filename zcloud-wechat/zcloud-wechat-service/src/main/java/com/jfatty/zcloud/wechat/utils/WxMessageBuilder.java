package com.jfatty.zcloud.wechat.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jfatty.zcloud.wechat.entity.Article;
import com.jfatty.zcloud.wechat.entity.MsgNews;
import com.jfatty.zcloud.wechat.entity.MsgText;
import com.jfatty.zcloud.wechat.vo.MsgRequest;
import com.jfatty.zcloud.wechat.vo.MsgResponseNews;
import com.jfatty.zcloud.wechat.vo.MsgResponseText;
import org.apache.commons.lang3.StringUtils;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 描述 消息builder工具类
 * @author jfatty on 2019/4/7
 * @email jfatty@163.com
 */
public class WxMessageBuilder implements Serializable {

    //客服文本消息
    public static String prepareCustomText(String openid,String content){
        JSONObject jsObj = new JSONObject();
        jsObj.put("touser", openid);
        jsObj.put("msgtype", MsgType.Text.name());
        JSONObject textObj = new JSONObject();
        textObj.put("content", content);
        jsObj.put("text", textObj);
        return jsObj.toString();
    }


    //获取 MsgResponseText 对象
    public static MsgResponseText getMsgResponseText(MsgRequest msgRequest, MsgText msgText){
        if(msgText != null){
            MsgResponseText reponseText = new MsgResponseText();
            reponseText.setToUserName(msgRequest.getFromUserName());
            reponseText.setFromUserName(msgRequest.getToUserName());
            reponseText.setMsgType(MsgType.Text.toString());
            reponseText.setCreateTime(new Date().getTime());
            reponseText.setContent(msgText.getContent());
            return reponseText;
        }else{
            return null;
        }
    }

    //获取 MsgResponseNews 对象
    public static MsgResponseNews getMsgResponseNews(MsgRequest msgRequest, List<MsgNews> msgNews){
        if(msgNews != null && msgNews.size() > 0){
            MsgResponseNews responseNews = new MsgResponseNews();
            responseNews.setToUserName(msgRequest.getFromUserName());
            responseNews.setFromUserName(msgRequest.getToUserName());
            responseNews.setMsgType(MsgType.News.toString());
            responseNews.setCreateTime(new Date().getTime());
            responseNews.setArticleCount(msgNews.size());
            List<Article> articles = new ArrayList<Article>(msgNews.size());
            for(MsgNews n : msgNews){
                Article a = new Article();
                a.setTitle(n.getTitle());
                a.setPicUrl(n.getPicPath());
                if(StringUtils.isEmpty(n.getFromUrl())){
                    a.setUrl(n.getUrl());
                }else{
                    a.setUrl(n.getFromUrl());
                }
                a.setDescription(n.getBrief());
                articles.add(a);
            }
            responseNews.setArticles(articles);
            return responseNews;
        }else{
            return null;
        }
    }

    //客服图文消息
    public static String prepareCustomNews(String openid,MsgNews msgNews){
        JSONObject jsObj = new JSONObject();
//		List<MsgArticle> arts = msgNews.getArticles();
//		jsObj.put("touser", openid);
//		jsObj.put("msgtype", MsgType.News.toString().toLowerCase());
//		JSONObject articles = new JSONObject();
//		JSONArray articleArray = new JSONArray();
//		//支持多图文
//		arts.forEach((a)->{
//			JSONObject newsObj = new JSONObject();
//			newsObj.put("title", a.getTitle());
//			newsObj.put("description", a.getDigest());
//			newsObj.put("url", a.getUrl());
//			newsObj.put("picurl", a.getPicUrl());
//			articleArray.add(newsObj);
//		});
//		articles.put("articles", articleArray);
//		jsObj.put("news", articles);
//		第二种方式
        jsObj.put("touser", openid);
        jsObj.put("msgtype", MsgType.MPNEWS.toString().toLowerCase());
        JSONObject media = new JSONObject();
        media.put("media_id", msgNews.getMediaId());
        jsObj.put("mpnews", media);
        return jsObj.toString();
    }


    public static void main(String[] args) {
        JSONObject jsObj = new JSONObject();
        jsObj.put("touser", 1);
        jsObj.put("msgtype", 2);
        JSONObject articles = new JSONObject();
        JSONArray articleArray = new JSONArray();
        JSONObject newsObj = new JSONObject();
        newsObj.put("title", 3);
        newsObj.put("description", 4);
        articleArray.add(newsObj);
        articles.put("articles", articleArray);
        jsObj.put("news", articles);
        System.out.println(jsObj.toString());
    }

}
