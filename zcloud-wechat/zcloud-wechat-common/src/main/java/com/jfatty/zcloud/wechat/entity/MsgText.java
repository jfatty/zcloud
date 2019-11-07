/*
 * FileName：MsgText.java 
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

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * MsgBase
 * @author jfatty
 * @version 2.0
 * @date 2018-04-17 10:54:58
 */
@Data
@TableName("wxcms_msg_text")
public class MsgText extends Model<MsgText> {

	private String title;//消息标题

	private String content;//消息内容

	private String baseId;//消息主表id
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
	private LocalDateTime createTime;

	/**
	 * 更新人
	 */
	private String updateOperator;

	/**
	 * 更新时间
	 */
	private LocalDateTime updateTime;



	/*********************************************************************/


	private String inputcode;//关注者发送的消息

	private String id ;

}
