package com.jfatty.zcloud.hospital.api;

import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.hospital.req.QueueProgressReq;
import com.jfatty.zcloud.hospital.res.QueueProgressRes;
import com.jfatty.zcloud.hospital.service.QueueProgressService;
import com.jfatty.zcloud.hospital.vo.QueueProgress;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述 排队进度
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
@Api(tags = "排队进度查询API" ,value = "排队进度查询")
@Slf4j
@RestController
@RequestMapping("/api/queueProgress")
public class ApiQueueProgressController {

    @Autowired
    private QueueProgressService queueProgressService ;

    @ApiOperation(value="查询用户排队的状态")
    @RequestMapping(value = {"/getQueueProgressStatus"} ,method = RequestMethod.POST)
    public RELResultUtils<QueueProgressRes> getQueueProgressStatus(@RequestBody QueueProgressReq queueProgressReq ){
        List<QueueProgress> list = queueProgressService.getQueueProgressStatus(queueProgressReq.getOpenId(),queueProgressReq.getOpenIdType());
        if( !CollectionUtils.isEmpty(list) ){
            if(!list.get(0).success())
                return RELResultUtils._506((list.get(0)).getMsg());
            List<QueueProgressRes> results = new ArrayList<QueueProgressRes>();
            list.forEach(
                    queueProgress -> {
                        QueueProgressRes queueProgressRes = new QueueProgressRes();
                        BeanUtils.copyProperties(queueProgress,queueProgressRes);
                        results.add(queueProgressRes);
                    }
            );
            return new RELResultUtils(results);
        }
        return RELResultUtils._506("没有查询到排队信息!");
    }

}
