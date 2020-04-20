package com.jfatty.zcloud.hospital.interfaces;

import com.jfatty.zcloud.base.interfaces.BInterface;
import com.jfatty.zcloud.hospital.entity.IconPicture;
import com.jfatty.zcloud.hospital.req.IconPictureReq;
import com.jfatty.zcloud.hospital.res.IconPictureRes;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @author jfatty on 2020/4/12
 * @email jfatty@163.com
 */
@RequestMapping(value={"/iconPicture"})
public interface IIconPicture extends BInterface<IconPicture,IconPictureReq,IconPictureRes> {

}
