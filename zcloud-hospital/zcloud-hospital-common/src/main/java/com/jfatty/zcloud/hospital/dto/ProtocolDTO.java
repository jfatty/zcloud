package com.jfatty.zcloud.hospital.dto;


import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
@Data
public class ProtocolDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id ;

    /**
     * 协议标题
     */
    private String title;

    /**
     * 协议内容
     */
    private String content;

    /**
     * 协议署名
     */
    private String signature;

    /**
     * 协议类型
     */
    private String type;

    /**
     * 版本
     */
    private String version;

    /**
     * 使用方唯一码
     */
    private String user;

    /**
     * 操作码例如 绑定就诊卡 预约挂号
     */
    private String opcode;

    /**
     * 备注或者描述
     */
    private String description;

    /**
     * 使用状态
     */
    private Integer state;

}
