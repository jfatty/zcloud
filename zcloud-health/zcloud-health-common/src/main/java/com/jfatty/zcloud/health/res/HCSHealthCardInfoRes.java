package com.jfatty.zcloud.health.res;

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
@ApiModel(description = "身份证信息响应实体")
public class HCSHealthCardInfoRes extends HCSHealthCardInfoDTO<HCSHealthCardInfoRes> {

    /**
     * 姓名
     */
    @ApiModelProperty(name = "name", position = 0, value = "姓名",required = true ,example = "小邓")
    private String name;

    /**
     * 性别
     */
    @ApiModelProperty(name = "gender", position = 0, value = "性别",required = true ,example = "男")
    private String gender;

    /**
     * 证件号码
     */
    @ApiModelProperty(name = "idNumber", position = 0, value = "证件号码",required = true ,example = "432624198888883116")
    private String idNumber;

    /**
     * 证件类型
     */
    @ApiModelProperty(name = "idType", position = 0, value = "证件类型",required = true ,example = "01-居民身份证")
    private String idType ;

    /**
     * 民族
     */
    @ApiModelProperty(name = "nation", position = 0, value = "民族",required = true ,example = "汉族")
    private String nation;

    /**
     * 出生年月日
     */
    @ApiModelProperty(name = "birthday", position = 0, value = "出生年月日",required = true ,example = "1996-01-23")
    private String birthday ;

    /**
     * 地址
     */
    @ApiModelProperty(name = "address", position = 0, value = "地址",required = true ,example = "广东省深圳市腾讯大厦")
    private String address;

    /**
     * 联系方式1
     */
    @ApiModelProperty(name = "phone1", position = 0, value = "联系方式1",required = true ,example = "18565818888")
    private String phone1;
    /**
     * 联系方式2
     */
    @ApiModelProperty(name = "phone2", position = 0, value = "联系方式2",required = true ,example = "18565818899")
    private String phone2;

    /**
     * 院内ID
     */
    @ApiModelProperty(name = "patid", position = 0, value = "院内ID",required = true ,example = "1003243")
    private String patid;

    /**
     * 微信身份码
     */
    @ApiModelProperty(name = "wechatCode", position = 0, value = "微信身份码",required = true ,example = "73EFA6796D3869FF82FAE7E81E9XXXX")
    private String wechatCode;

    /**
     * 健康卡主索引
     */
    @ApiModelProperty(name = "phid", position = 0, value = "健康卡主索引",required = true ,example = "584AF4B1D110B8BB7CBAC978C03B657191DF84863144E436B5CA38C0F0E2XXXX")
    private String phid;

    /**
     * 二维码文本
     */
    @ApiModelProperty(name = "qrCodeText", position = 0, value = "二维码文本",required = true ,example = "C220AE414CE6EE581037C311AE24518FCFE19C429BECD478C1A13976260FXXXX:1")
    private String qrCodeText;

    /**
     * 健康卡ID
     */
    @ApiModelProperty(name = "healthCardId", position = 0, value = "健康卡ID",required = true ,example = "C220AE414CE6EE581037C311AE24518FCFE19C429BECD478C1A13976260FXXXX")
    private String healthCardId;

    /**
     * 扩展字段
     */
    //@ApiModelProperty(name = "adminExt", position = 0, value = "扩展字段",example = "{\"qr_code\":\"C220AE414CE6EE581037C311AE24518FCFE19C429BECD478C1A13976260FXXXX:1\",\"ecardId\":\"C220AE414CE6EE581037C311AE24518FCFE19C429BECD478C1A13976260FXXXX\",\"main_index\":\"584AF4B1D110B8BB7CBAC978C03B657191DF84863144E436B5CA38C0F0E2XXXX\",\"id_type\":\"居民身份证\",\"id_number\":\"身份证号码\",\"name\":\"姓名\",\"sex\":\"性别\",\"birthday\":\\\"1998-09-08\",\"telephone\":\"手机号码\",\"nation\":\"民族\",\"unit\":\"null\",\"address\":\"地址\"}")
    //private String adminExt;

}
