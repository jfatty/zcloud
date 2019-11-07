package com.jfatty.zcloud.system.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jfatty.zcloud.system.converter.LocalDateTimeConverter;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统文件(附件)
 * </p>
 *
 * @author jfatty
 * @since 2019-03-25
 */
@Data
@TableName("sys_attachment")
public class Attachment extends Model<Attachment> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;

    /**
     * 关联对象id
     */
    private String relationId;

    /**
     * 原名称
     */
    private String originalName;

    /**
     * 当前名称
     */
    private String currentName;

    /**
     * 文件路径
     */
    private String filePath;

    /**
     * 文件大小
     */
    private String fileSize;

    /**
     * 上传时间
     */
    private String uploadTime;

    /**
     * 附件排序号
     */
    private Integer number;

    /**
     * 文件类型
     */
    private String attaFileFat;

    /**
     * 域值
     */
    private String realm;

    /**
     * 使用状态
     */
    private Integer state;

    /**
     * 创建人
     */
    private String createOperator;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    private String updateOperator;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;


    public Attachment() {
    }

    public Attachment(String relationId, String originalName, String currentName, String filePath, String fileSize , Integer number, String attaFileFat) {
        super();
        this.relationId = relationId;
        this.originalName = originalName;
        this.currentName = currentName;
        this.filePath = filePath;
        this.fileSize = fileSize;
        this.number = number;
        this.attaFileFat = attaFileFat;
    }

    public Attachment(String id, String createOperator, String originalName, String currentName, String filePath, String fileSize, Integer number, String attaFileFat) {
        this.id = id ;
        this.state = 1 ;
        this.originalName = originalName;
        this.currentName = currentName;
        this.filePath = filePath;
        this.fileSize = fileSize;
        this.number = number;
        this.attaFileFat = attaFileFat;
        this.createOperator = createOperator ;
    }

    public Attachment(String id, String createOperator,String realm, String originalName, String currentName, String filePath, String fileSize, Integer number, String attaFileFat) {
        this.id = id ;
        this.state = 1 ;
        this.originalName = originalName;
        this.currentName = currentName;
        this.filePath = filePath;
        this.fileSize = fileSize;
        this.number = number;
        this.attaFileFat = attaFileFat;
        this.createOperator = createOperator ;
        this.realm = realm ;
    }


}
