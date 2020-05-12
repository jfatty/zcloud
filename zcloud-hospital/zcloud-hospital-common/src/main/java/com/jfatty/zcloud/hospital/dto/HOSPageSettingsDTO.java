package com.jfatty.zcloud.hospital.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 描述
 *
 * @author jfatty on 2019/12/30
 * @email jfatty@163.com
 */
@Data
public class HOSPageSettingsDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 主键ID
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id;

    /**
     * 应用ID APPID
     */
    @ApiModelProperty(name = "appid", position = 1, required = true, value = "应用ID APPID" , example = "wxe3336a60d2685379")
    private String appid;

    /**
     * 医院名称
     */
    @ApiModelProperty(name = "hosName", position = 1, required = true, value = "医院名称" , example = "鹤峰县中心医院")
    private String hosName;

    /**
     * 医院口号标语
     */
    @ApiModelProperty(name = "hosSlogan", position = 1, required = true, value = "医院口号标语" , example = "诚信 精湛 务实 创新")
    private String hosSlogan;

    /**
     * 医院logoUrl地址
     */
    @ApiModelProperty(name = "hosLogoUrl", position = 1, required = true, value = "医院logoUrl地址" , example = "http://dev.jfatty.com/4.0.0/hf_menu_icon/personal.png")
    private String hosLogoUrl;

    /**
     * 技术支持方名称
     */
    @ApiModelProperty(name = "techSupport", position = 1, required = true, value = "技术支持方名称" , example = "技术支持：武汉志软")
    private String techSupport;

    /**
     * 技术支持服务电话
     */
    @ApiModelProperty(name = "techSupportPhone", position = 1, required = true, value = "技术支持服务电话" , example = "027-8132-8686")
    private String techSupportPhone;

    /**
     * 技术支持官网地址
     */
    @ApiModelProperty(name = "techSupportWww", position = 1, required = true, value = "技术支持官网地址" , example = "https://www.zealsoft.com.cn/")
    private String techSupportWww;

    /**
     * 图标 类型 0 表示图片地址 1 表示二进制文件
     */
    @ApiModelProperty(name = "iconType", position = 1, required = true, value = "图标 类型 0 表示图片地址 1 表示二进制文件" )
    private Integer iconType;

    /**
     * 配置描述
     */
    @ApiModelProperty(name = "description", position = 1, required = true, value = "配置描述" , example = "鹤峰县中心医院始建于1953年，前身为鹤峰县人民医院，2000年10月由原县人民医院和县中医院合并而成，为鹤峰县唯一一所集医疗、教学、科研、康复、预防保健为一体的二级甲等优秀综合性公立医院，是本县及邻县周边乡镇医疗急救中心，系“恩施州文明单位”。属湖北民族大学附属民大医院医疗联合体及规培协同基地医院，是华中科技大学附属协和医院、杭州市临安区人民医院、襄阳市中心医院对口支援医院，也是湖北民族大学医学院、恩施州卫校的教学实习医院。同9个乡镇卫生院组建成为了县域医共体。")
    private String description;

    /**
     * 地址
     */
    @ApiModelProperty(name = "address", position = 1, required = true, value = "地址" , example = "湖北省鹤峰县容美镇城墙路18号。")
    private String address;

    /**
     * 地址地图链接地址
     */
    @ApiModelProperty(name = "addressHref", position = 1, required = true, value = "地址地图链接地址" , example = "https://map.baidu.com")
    private String addressHref ;

    /**
     * 激活状态地址图标地址
     */
    @ApiModelProperty(name = "actAddressIconUrl", position = 1, required = true, value = "激活状态地址图标地址" , example = "http://dev.jfatty.com/4.0.0/hf_menu_icon/personal.png")
    private String actAddressIconUrl;
    /**
     * 地址图标地址
     */
    @ApiModelProperty(name = "addressIconUrl", position = 1, required = true, value = "地址图标地址" , example = "http://dev.jfatty.com/4.0.0/hf_menu_icon/personal.png")
    private String addressIconUrl;


    /**
     * 电话
     */
    @ApiModelProperty(name = "phone", position = 1, required = true, value = "电话" , example = "0718—5282450。")
    private String phone;

    /**
     * 激活状态电话图标地址
     */
    @ApiModelProperty(name = "actPhoneIconUrl", position = 1, value = "激活状态电话图标地址" , example = "http://dev.jfatty.com/4.0.0/hf_menu_icon/personal.png")
    private String actPhoneIconUrl;
    /**
     * 电话图标地址
     */
    @ApiModelProperty(name = "phoneIconUrl", position = 1, value = "电话图标地址" , example = "http://dev.jfatty.com/4.0.0/hf_menu_icon/personal.png")
    private String phoneIconUrl;

    /**
     * 菜单版本
     */
    @ApiModelProperty(name = "version", position = 1, required = true, value = "菜单版本" , example = "4.0.0")
    private String version;

    /**
     * 使用状态0表示正常使用-1表示维护中-2表示建设中...
     */
    @ApiModelProperty(name = "status", position = 1, required = true, value = "使用状态0表示正常使用-1表示维护中-2表示建设中..." , example = "0")
    private Integer status;




}
