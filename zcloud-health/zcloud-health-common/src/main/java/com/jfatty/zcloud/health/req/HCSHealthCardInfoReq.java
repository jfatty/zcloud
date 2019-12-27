package com.jfatty.zcloud.health.req;

import com.jfatty.zcloud.health.dto.HCSHealthCardInfoDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/26
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "身份证信息请求实体")
public class HCSHealthCardInfoReq extends HCSHealthCardInfoDTO<HCSHealthCardInfoReq> {


    @ApiModelProperty(name = "birthday", position = 0, value = "出生年月日",required = true ,example = "1996-01-23")
    private String birthday ;
    @ApiModelProperty(name = "idType", position = 0, value = "证件类型",required = true ,example = "01-居民身份证")
    private String idType ;
    @ApiModelProperty(name = "address", position = 0, value = "地址",required = true ,example = "广东省深圳市腾讯大厦")
    private String address;
    @ApiModelProperty(name = "gender", position = 0, value = "性别",required = true ,example = "男")
    private String gender;
    @ApiModelProperty(name = "nation", position = 0, value = "民族",required = true ,example = "汉族")
    private String nation;
    @ApiModelProperty(name = "name", position = 0, value = "姓名",required = true ,example = "小邓")
    private String name;
    //@ApiModelProperty(name = "wechatCode", position = 0, value = "微信身份码",required = true ,example = "73EFA6796D3869FF82FAE7E81E9XXXX")
    //private String wechatCode;
    @ApiModelProperty(name = "idNumber", position = 0, value = "证件号码",required = true ,example = "432624198888883116")
    private String idNumber;
    @ApiModelProperty(name = "phone1", position = 0, value = "联系方式1",required = true ,example = "18565818888")
    private String phone1;
    @ApiModelProperty(name = "phone2", position = 0, value = "联系方式2",required = true ,example = "18565818899")
    private String phone2;
    @ApiModelProperty(name = "patid", position = 0, value = "院内ID",required = true ,example = "1003243")
    private String patid;

}
