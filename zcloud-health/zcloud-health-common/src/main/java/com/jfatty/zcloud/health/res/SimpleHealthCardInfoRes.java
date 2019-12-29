package com.jfatty.zcloud.health.res;

import com.jfatty.zcloud.health.dto.HCSHealthCardInfoDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/29
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "电子健康卡列表响应实体")
public class SimpleHealthCardInfoRes extends HCSHealthCardInfoDTO<SimpleHealthCardInfoRes> {

    //系统健康卡ID
    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 证件号码
     */
    private String idNumber;
    /**
     * 二维码文本
     */
    private String qrCodeText;


}
