package com.jfatty.zcloud.system.api;

import com.jfatty.zcloud.system.entity.Dictionary;
import com.jfatty.zcloud.system.interfaces.IDictionary;
import com.jfatty.zcloud.system.service.DictionaryService;
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
@Slf4j
@RestController
@RequestMapping(value={"/api/dictionary"})
public class ApiDictionaryController extends ApiBaseSystemController<Dictionary>  implements IDictionary {

    private DictionaryService dictionaryService;

    @Autowired
    public void setDictionaryService(DictionaryService dictionaryService) {
        super.setBaseService(dictionaryService);
        this.dictionaryService = dictionaryService;
    }
}
