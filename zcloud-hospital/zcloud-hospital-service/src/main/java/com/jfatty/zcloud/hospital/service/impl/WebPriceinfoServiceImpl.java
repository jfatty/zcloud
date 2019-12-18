package com.jfatty.zcloud.hospital.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.jfatty.zcloud.hospital.datasource.TargetDataSource;
import com.jfatty.zcloud.hospital.mapper.WebPriceinfoMapper;
import com.jfatty.zcloud.hospital.res.WebPriceinfoRes;
import com.jfatty.zcloud.hospital.service.WebPriceinfoService;
import com.jfatty.zcloud.hospital.vo.WebPriceinfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
@Slf4j
@Service
public class WebPriceinfoServiceImpl implements WebPriceinfoService {

    @Autowired
    private WebPriceinfoMapper webPriceinfoMapper;

    @TargetDataSource(name="mssql")
    @Override
    public List<WebPriceinfoRes> getWebPriceinfo(String openId, Integer openIdType, Integer pageIndex, Integer pageSize, String xmmc, Integer cxlb) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("xmmc", xmmc);
        map.put("openId", openId);
        map.put("openIdType", openIdType);
        map.put("cxlb", cxlb);
        List<WebPriceinfo> list = webPriceinfoMapper.getWebPriceinfo(map);
        if( CollectionUtils.isNotEmpty(list) ){
            List<WebPriceinfoRes> results = new ArrayList<WebPriceinfoRes>();
            list.forEach(
                    webPriceinfo -> {
                        WebPriceinfoRes webPriceinfoRes = new WebPriceinfoRes();
                        BeanUtils.copyProperties(webPriceinfo,webPriceinfoRes);
                        results.add(webPriceinfoRes);
                    }
            );
            return results;
        }
        return null;
    }
}
