package com.jfatty.zcloud.hospital.req;

import com.jfatty.zcloud.hospital.dto.MenuDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "智慧医疗菜单请求实体")
public class MenuReq extends MenuDTO<MenuReq> {

    /**
     * icon图标二进制文件
     */
    //private MultipartFile iconImg;


    /**
     * 导航图标激活状态二进制文件
     */
    //private MultipartFile actIconImg;
}
