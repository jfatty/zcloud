package com.jfatty.zcloud.hospital.service;

import com.jfatty.zcloud.hospital.res.WebPriceinfoRes;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
public interface WebPriceinfoService {

    /**
     * 物价查询
     * @param openId
     * @param openIdType
     * @param pageIndex
     * @param pageSize
     * @param xmmc
     * @param cxlb
     * @return
     */
    List<WebPriceinfoRes> getWebPriceinfo(String openId, Integer openIdType, Integer pageIndex, Integer pageSize, String xmmc, Integer cxlb);

}
