package com.jfatty.zcloud.system.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
@Data
public class UserDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id ;
    /**
     * 用户姓名
     */
    @ApiModelProperty(name = "name", position = 2 , value = "用户姓名" ,required = true , example = "李四" )
    private String name;

    /**
     * 性别 0：未知、1：男、2：女
     * 性别在这里定义的字段与微信中保持统一
     */
    @ApiModelProperty(name = "gender", position = 2 , value = "性别" ,required = true , example = "1" )
    private Integer gender;

    /**
     * 年龄
     */
    @ApiModelProperty(name = "age", position = 2 , value = "年龄" ,required = true , example = "15" )
    private Integer age;

    /**
     * 可选字段组织机构id
     */
    @ApiModelProperty(name = "orgId", position = 2 , value = "可选字段组织机构id" ,required = true , example = "SSSS55858" )
    private String orgId;

    /**
     * 可选字段组织机构名称
     */
    @ApiModelProperty(name = "org", position = 2 , value = "可选字段组织机构名称" ,required = true , example = "达乐科技" )
    private String org;

    /**
     * 可选字段部门id
     */
    @ApiModelProperty(name = "deptId", position = 2 , value = "可选字段部门id" ,required = true , example = "SSSS55858" )
    private String deptId;

    /**
     * 可选字段部门名称
     */
    @ApiModelProperty(name = "dept", position = 2 , value = "可选字段部门名称" ,required = true , example = "财务部" )
    private String dept;

    /**
     * 可选字段科室id
     */
    @ApiModelProperty(name = "officeId", position = 2 , value = "可选字段科室id" ,required = true , example = "SSS5688" )
    private String officeId;

    /**
     * 可选字段科室名称
     */
    @ApiModelProperty(name = "office", position = 2 , value = "可选字段科室名称" ,required = true , example = "产科" )
    private String office;

    /**
     * 个人备注
     */
    @ApiModelProperty(name = "remark", value = "个人备注",  position = 2, example = "个人备注个人备注个人备注")
    private String remark;

    /**
     * 头像地址
     */
    @ApiModelProperty(name = "avatar", value = "头像地址",  position = 2, example = "头像地址头像地址")
    private String avatar;

    /**
     * 用户编码
     */
    @ApiModelProperty(name = "userCode", value = "用户编码",  position = 2, example = "USERCODE")
    private String userCode;
    /**
     * 用户身份维修员ITUSER报修员ITWORKER管理员ITMANAGER
     */
    @ApiModelProperty(name = "identity", value = "用户身份",  position = 2, example = "管理员")
    private String identity;
    /**
     * 职务
     */
    @ApiModelProperty(name = "post", value = "职务",  position = 2, example = "经理")
    private String post;

    /**
     * 账号类型  个人、企业、单位(机构) 关联数据字典ID
     */
    @ApiModelProperty(name = "type", value = "职务",  position = 2, example = "经理")
    private String type;


    /**
     * 用户注册系统后是否通过认证的状态0表示尚未通过认证1表示已经通过认证
     */
    @ApiModelProperty(name = "auth", value = "用户注册系统后是否通过认证的状态",  position = 2, example = "0")
    private Integer auth = 0 ;

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

    /**
     * 更新人
     */
    @ApiModelProperty(name = "updateOperator", position = 12 , value = "更新人" , example = "张三" )
    private String updateOperator;

    /**
     * 更新时间
     */
    @ApiModelProperty(name = "updateTime", position = 13 , value = "更新时间" ,allowableValues = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}
