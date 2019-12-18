package com.jfatty.zcloud.hospital.mapper;

import com.jfatty.zcloud.hospital.vo.ElectronicDoc;
import com.jfatty.zcloud.hospital.vo.ElectronicDocDetail;

import java.util.List;
import java.util.Map;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
public interface ElectronicDocMapper {


    /**
     * 获取我的服务单列表信息
     * @author jfatty
     * 创建时间：2018年4月12日
     * @param map
     * @return
     */
    List<ElectronicDoc> getElectronicDocList(Map<String,Object> map);

    /**
     * 获取门诊缴费详情列表
     * @param map
     * @return
     */
    List<ElectronicDocDetail> getElectronicDocDetail(Map<String,Object> map);
}
