package com.jfatty.zcloud.hospital.service.impl;

import com.jfatty.zcloud.hospital.datasource.TargetDataSource;
import com.jfatty.zcloud.hospital.mapper.QueueProgressMapper;
import com.jfatty.zcloud.hospital.service.QueueProgressService;
import com.jfatty.zcloud.hospital.vo.QueueProgress;
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
public class QueueProgressServiceImpl implements QueueProgressService {

    @Autowired
    private QueueProgressMapper queueProgressMapper ;

    @TargetDataSource(name="mssql")
    @Override
    public List<QueueProgress> getQueueProgressStatus(String openId, Integer openIdType) {
        return queueProgressMapper.getQueueProgressStatus(openId,openIdType);
    }
}
