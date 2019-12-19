package com.jfatty.zcloud.hospital.service;

import com.jfatty.zcloud.hospital.vo.ElectronicCard;
import com.jfatty.zcloud.hospital.vo.WebRegPatient;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
public interface ElectronicCardService {

    /**
     * 获取电子就诊卡信息
     * @param list
     * @return
     */
    List<ElectronicCard> getECards(List<WebRegPatient> list);

}
