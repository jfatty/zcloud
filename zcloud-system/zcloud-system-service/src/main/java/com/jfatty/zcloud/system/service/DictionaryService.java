package com.jfatty.zcloud.system.service;

import com.jfatty.zcloud.system.entity.Dictionary;
import com.jfatty.zcloud.system.res.DictionaryRes;
import com.jfatty.zcloud.system.res.DictionarySimRes;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/11/13
 * @email jfatty@163.com
 */
public interface DictionaryService extends BaseSystemService<Dictionary> {

    List<DictionarySimRes> getByDictionaryMenu(String dictionaryMenuId);
}
