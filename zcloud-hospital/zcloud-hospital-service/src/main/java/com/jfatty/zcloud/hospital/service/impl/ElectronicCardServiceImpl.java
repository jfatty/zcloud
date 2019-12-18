package com.jfatty.zcloud.hospital.service.impl;

import com.jfatty.zcloud.hospital.datasource.TargetDataSource;
import com.jfatty.zcloud.hospital.mapper.ElectronicCardMapper;
import com.jfatty.zcloud.hospital.res.WebRegPatientRes;
import com.jfatty.zcloud.hospital.service.ElectronicCardService;
import com.jfatty.zcloud.hospital.vo.ElectronicCard;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
@Slf4j
@Service
public class ElectronicCardServiceImpl implements ElectronicCardService {

    @Autowired
    private ElectronicCardMapper electronicCardMapper ;

    @TargetDataSource(name="mssql")
    @Override
    public List<ElectronicCard> getECards(List<WebRegPatientRes> list) {
        return electronicCardMapper.getECards(list);
    }
}
