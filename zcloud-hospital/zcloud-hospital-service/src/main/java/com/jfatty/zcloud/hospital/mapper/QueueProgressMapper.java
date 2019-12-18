package com.jfatty.zcloud.hospital.mapper;

import com.jfatty.zcloud.hospital.vo.QueueProgress;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
public interface QueueProgressMapper {

    /**
     * 查询用户排队的状态
     * @return
     */
    List<QueueProgress> getQueueProgressStatus(@Param("openId") String openId, @Param("openIdType")  Integer openIdType);
}
