package com.jfatty.zcloud.health.req;

import com.jfatty.zcloud.health.dto.HCSAddressDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/30
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "公用地址信息请求实体")
public class HCSAddressReq extends HCSAddressDTO<HCSAddressReq> {

    /**
     * 省
     */
    @ApiModelProperty(name = "province", position = 0, value = "省 name:::areaCode:::id " , example = "湖北省:::420000000000:::420824")
    private String province;

    /**
     * 市州
     */
    @ApiModelProperty(name = "city", position = 1, value = "市州 name:::areaCode:::id " , example = "利川市:::422802000000:::447495")
    private String city;

    /**
     * 区县
     */
    @ApiModelProperty(name = "area", position = 2, value = "区县 name:::areaCode:::id " , example = "业州镇:::422822100000:::448100")
    private String area;

    @ApiModelProperty(name = "household", position = 3, value = "地址详情" , example = "红土乡茶店子村5组18号")
    private String household;



}
