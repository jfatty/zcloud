/*
 * FileName：MsgBase.java 
 * <p>
 * Copyright (c) 2017-2020, <a href="http://www.webcsn.com">jfatty (794890569@qq.com)</a>.
 * <p>
 * Licensed under the GNU General Public License, Version 3 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/gpl-3.0.html
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package com.jfatty.zcloud.wechat.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author jfatty
 * @version 2.0
 * @date 2018-04-17 10:54:58
 */
@Data
public class MsgBase implements Serializable {
	private String id;
	private String msgtype;//消息类型;
	private String inputcode;//关注者发送的消息
	@JsonIgnore
	private String rule;//规则，目前是 “相等”
	@JsonIgnore
	private Integer enable;//是否可用
	@JsonIgnore
	private Integer readcount;//消息阅读数
	@JsonIgnore
	private Integer favourcount;//消息点赞数

	/**
	 * 微信原始账号ID
	 */
	private String account;

	/**
	 * 域值
	 */
	private String realm;

	/**
	 * 使用状态
	 */
	private Integer state;

	/**
	 * 创建人
	 */
	private String createOperator;

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm",iso= DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime createTime ;

	/**
	 * 更新人
	 */
	private String updateOperator;

	/**
	 * 更新时间
	 */
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime updateTime;
}
