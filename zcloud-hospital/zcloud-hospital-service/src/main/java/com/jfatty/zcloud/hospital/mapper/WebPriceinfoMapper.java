package com.jfatty.zcloud.hospital.mapper;

import com.jfatty.zcloud.hospital.vo.WebPriceinfo;

import java.util.List;
import java.util.Map;

/**
 * 描述 物价查询
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
public interface WebPriceinfoMapper {

    /**
     * 描述  物价查询
     * @author jfatty
     * 创建时间：2018年4月17日
     */
    List<WebPriceinfo> getWebPriceinfo(Map<String,Object> map);

}
