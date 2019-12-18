package com.jfatty.zcloud.hospital.service;

import com.jfatty.zcloud.hospital.vo.QueueProgress;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
public interface QueueProgressService {


    List<QueueProgress> getQueueProgressStatus(String openId, Integer openIdType);

}
