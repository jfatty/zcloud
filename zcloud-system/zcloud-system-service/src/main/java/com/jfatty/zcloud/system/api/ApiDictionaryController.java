package com.jfatty.zcloud.system.api;

import com.jfatty.zcloud.system.entity.Dictionary;
import com.jfatty.zcloud.system.interfaces.IDictionary;
import com.jfatty.zcloud.system.req.DictionaryReq;
import com.jfatty.zcloud.system.res.DictionaryRes;
import com.jfatty.zcloud.system.service.DictionaryService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述
 *
 * @author jfatty on 2019/11/13
 * @email jfatty@163.com
 */
@Api(tags = "系统字典API" ,value = "系统字典")
@Slf4j
@RestController
@RequestMapping(value={"/api/dictionary"})
public class ApiDictionaryController extends ApiBaseSystemController<Dictionary,DictionaryReq,DictionaryRes>  implements IDictionary {

    private DictionaryService dictionaryService;

    @Autowired
    public void setDictionaryService(DictionaryService dictionaryService) {
        super.setBaseService(dictionaryService);
        this.dictionaryService = dictionaryService;
    }
}
