package com.jfatty.zcloud.health.feign;

import com.jfatty.zcloud.base.utils.RETResultUtils;
import com.jfatty.zcloud.health.vo.ReportHISDataVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 描述 电子健康卡平台
 *
 *
 * @author jfatty on 2020/5/21
 * @email jfatty@163.com
 */
@FeignClient(value = "zcloud-health-service" , path = "/api/healthCardStation")
public interface HealthCardStationFeignClient {



    @RequestMapping(value="/reportHISData", method=RequestMethod.POST)
    RETResultUtils<Boolean> reportHISData(@RequestParam(value = "hospitalId" , defaultValue = "30646" ) String hospitalId , @RequestBody ReportHISDataVO reportHISDataVO );

}
