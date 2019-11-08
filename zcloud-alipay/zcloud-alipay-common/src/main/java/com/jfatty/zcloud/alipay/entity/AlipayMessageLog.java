package com.jfatty.zcloud.alipay.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

/**
 * 描述：</b>QywxMessagelog:<br>
 * 实体定义规则
 * 字段不允许存在基本类型，必须都是包装类型(因为基本类型有默认值)
 * 基本数据类型  包装类 byte Byte boolean Boolean short Short char Character int Integer long Long float Float double  Double
 */
@Data
@TableName("alipay_message_log")
public class AlipayMessageLog  extends Model<AlipayMessageLog> {
	
	/**
	 *id
	 */
	private String id;
	/**
	 *消息类型
	 */
	private String messageType;
	/**
	 *文本内容
	 */
	private String messageContent;
	/**
	 *内容id
	 */
	private String contentId;
	
	private String receiveMessage;
	/**
	 *创建时间
	 */
	// update-start--Author:chenchunpeng  Date:20160715 for：添加根据时间段查询的查询条件
	private Date createDate;
	//查询开始时间
	private Date startDate;
	//查询结束时间
	private Date endDate;

	public AlipayMessageLog() {
		// TODO Auto-generated constructor stub
	}
	// update-end--Author:chenchunpeng  Date:20160715 for：添加根据时间段查询的查询条件

	public AlipayMessageLog(String id, String messageType, String messageContent, String contentId,
			String receiveMessage, Date createDate) {
		super();
		this.id = id;
		this.messageType = messageType;
		this.messageContent = messageContent;
		this.contentId = contentId;
		this.receiveMessage = receiveMessage;
		this.createDate = createDate;
	}


}

