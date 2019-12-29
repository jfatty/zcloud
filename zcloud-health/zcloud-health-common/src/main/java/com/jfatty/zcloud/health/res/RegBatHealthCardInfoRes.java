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
@ApiModel(description = "批量注册响应实体")
public class RegBatHealthCardInfoRes extends HCSHealthCardInfoDTO<RegBatHealthCardInfoRes> {

    /**
     * 二维码文本
     */
    @ApiModelProperty(name = "qrCodeText", position = 0, value = "二维码文本",required = true ,example = "C220AE414CE6EE581037C311AE24518FCFE19C429BECD478C1A13976260FXXXX:1")
    private String qrCodeText;
    @ApiModelProperty(name = "idNumber", position = 0, value = "证件号码",required = true ,example = "432624198888883116")
    private String idNumber;
    /**
     * 健康卡ID
     */
    @ApiModelProperty(name = "healthCardId", position = 0, value = "健康卡ID",required = true ,example = "C220AE414CE6EE581037C311AE24518FCFE19C429BECD478C1A13976260FXXXX")
    private String healthCardId;

}
