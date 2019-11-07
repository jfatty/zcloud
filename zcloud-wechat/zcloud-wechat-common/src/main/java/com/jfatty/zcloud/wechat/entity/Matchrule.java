package com.jfatty.zcloud.wechat.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 描述
 *
 * @author jfatty on 2019/4/15
 * @email jfatty@163.com
 */
@Data
public class Matchrule implements Serializable {

    private String group_id;//用户分组ID
    private String sex;//性别：男（1）女（2），不填则不做匹配
    private String country;//国家,不填则不做匹配
    private String province;//省份,不填则不做匹配
    private String city;//城市，不填则不做匹配
    private String client_platform_type;//客户端版本，当前只具体到系统型号：IOS(1), Android(2),Others(3)，不填则不做匹配

}
