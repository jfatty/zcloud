package com.jfatty.zcloud.hospital.service.impl;

import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.hospital.datasource.TargetDataSource;
import com.jfatty.zcloud.hospital.entity.ComplexPayOrder;
import com.jfatty.zcloud.hospital.mapper.ComplexPayOrderMapper;
import com.jfatty.zcloud.hospital.service.ComplexPayOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述
 *
 * @author jfatty on 2020/4/21
 * @email jfatty@163.com
 */
@Slf4j
@Service
public class ComplexPayOrderServiceImpl extends BaseHospitalServiceImpl<ComplexPayOrder, ComplexPayOrderMapper>  implements ComplexPayOrderService {



    private ComplexPayOrderMapper complexPayOrderMapper ;

    @Autowired
    public void setComplexPayOrderMapper(ComplexPayOrderMapper complexPayOrderMapper) {
        super.setBaseMapper(complexPayOrderMapper);
        this.complexPayOrderMapper = complexPayOrderMapper;
    }

    @TargetDataSource(name="mssql")
    @Override
    public RELResultUtils<ComplexPayOrder> getTable(String v, Integer pageIndex, Integer pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        return  getTable(v,pageIndex,pageSize,map) ;
    }

    @TargetDataSource(name="mssql")
    @Override
    public RELResultUtils<ComplexPayOrder> getTable(String v, Integer pageIndex, Integer pageSize, Map<String, Object> params) {
        Map<String, Object> map = new HashMap<String, Object>();
        for ( Map.Entry<String, Object> entry : params.entrySet() ) {
            log.error(" ===============================>   根据 Map 参数分页查询  参数名 key: " + entry.getKey() + " 参数值 value: " + entry.getValue());
            map.put(entry.getKey(), entry.getValue());
        }
        //一定要注意起始数据是从第几条开始的
        map.put("pageIndex", pageIndex * pageSize);
        map.put("pageSize", pageSize);
        List<ComplexPayOrder> list = complexPayOrderMapper.getTable(map);
        Integer count = complexPayOrderMapper.getTableCount(map);
        if (list != null && list.size() > 0) {
            return new RELResultUtils<ComplexPayOrder>(200,RELResultUtils.SUCCESS, list, count);
        }
        return new RELResultUtils<ComplexPayOrder>(400, "没有查询到数据!", list);
    }
}
