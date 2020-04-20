package com.jfatty.zcloud.system.dto;

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
public class OrgDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id ;

    /**
     * 上级组织机构ID
     */
    @ApiModelProperty(name = "parentId", position = 2 , value = "上级组织机构ID" , example = "JIUJDSJSJ251" )
    private String parentId;

    /**
     * 组织结构全称
     */
    @ApiModelProperty(name = "name", position = 3 , value = "组织结构全称" , example = "武汉志软科技有限公司" )
    private String name;

    /**
     * 组织结构简称
     */
    @ApiModelProperty(name = "simpleName", position = 3 , value = "组织结构简称" , example = "武汉志软" )
    private String simpleName;

    /**
     * 组织机构代码
     */
    @ApiModelProperty(name = "orgCode", position = 3 , value = "组织机构代码" , example = "9412536998558458B" )
    private String orgCode;

    /**
     * 法人姓名
     */
    @ApiModelProperty(name = "legal", position = 3 , value = "法人姓名" , example = "习大大" )
    private String legal;

    /**
     * 联系人
     */
    @ApiModelProperty(name = "contact", position = 3 , value = "联系人" , example = "武大郎" )
    private String contact;

    /**
     * 联系电话
     */
    @ApiModelProperty(name = "tel", position = 3 , value = "联系电话" , example = "0718-8642158" )
    private String tel;

    /**
     * 机构地址
     */
    @ApiModelProperty(name = "address", position = 3 , value = "机构地址" , example = "武汉江城大道" )
    private String address;

    /**
     * 邮箱
     */
    @ApiModelProperty(name = "email", position = 3 , value = "邮箱" , example = "zz@163.com" )
    private String email;

    /**
     * 官网
     */
    @ApiModelProperty(name = "www", position = 3 , value = "官网" , example = "www.baidu.com" )
    private String www;

    /**
     * 对外QQ号码
     */
    @ApiModelProperty(name = "qq", position = 3 , value = "对外QQ号码" , example = "123321" )
    private String qq;

    /**
     * 对外微信号
     */
    @ApiModelProperty(name = "wx", position = 3 , value = "对外微信号" , example = "wx56789" )
    private String wx;

    /**
     * 备注或者描述
     */
    @ApiModelProperty(name = "remark", position = 3 , value = "备注或者描述" , example = "备注123" )
    private String remark;

    /**
     * 最大层级
     */
    @ApiModelProperty(name = "levelMax", position = 2 , value = "最大层级" , example = "N" )
    private Integer levelMax;

    /**
     * 当前层级
     */
    @ApiModelProperty(name = "level", position = 2 , value = "当前层级" , example = "5" )
    private Integer level;

    /**
     * 排序号
     */
    @ApiModelProperty(name = "sortNum", position = 2 , value = "排序号" , example = "13" )
    private Integer sortNum;

    /**
     * 使用状态
     */
    @ApiModelProperty(name = "state", position = 11,required = true,value = "正常使用 1 停用 0 使用状态" , example = "1" ,allowableValues = "0,1")
    private Integer state;


    /**
     * 域值
     */
    @ApiModelProperty(name = "realm", position = 12 , value = "域值" )
    private String realm;
}
