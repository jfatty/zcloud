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
@ApiModel(description = "注册健康卡响应实体")
public class RegHealthCardInfoRes extends HCSHealthCardInfoDTO<RegHealthCardInfoRes> {

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
