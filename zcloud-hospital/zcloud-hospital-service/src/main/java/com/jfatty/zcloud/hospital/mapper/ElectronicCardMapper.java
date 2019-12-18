package com.jfatty.zcloud.hospital.mapper;

import com.jfatty.zcloud.hospital.res.WebRegPatientRes;
import com.jfatty.zcloud.hospital.vo.ElectronicCard;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
public interface ElectronicCardMapper {

    /**
     * 获取电子就诊卡列表信息
     * @param list
     * @return
     */
    List<ElectronicCard> getECards(List<WebRegPatientRes> list);
}
