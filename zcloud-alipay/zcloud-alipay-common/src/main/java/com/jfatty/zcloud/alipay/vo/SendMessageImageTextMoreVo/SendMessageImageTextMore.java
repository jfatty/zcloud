package com.jfatty.zcloud.alipay.vo.SendMessageImageTextMoreVo;


import com.jfatty.zcloud.alipay.vo.SendMessageImageTextOneVo.Articles;

import java.util.List;

public class SendMessageImageTextMore {

	private String msgType;//消息类型，image
	private List<Articles> articles;
	
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public List<Articles> getArticles() {
		return articles;
	}
	public void setArticles(List<Articles> articles) {
		this.articles = articles;
	}
	
	
}
