package com.jfatty.zcloud.hospital.service;

import com.jfatty.zcloud.hospital.vo.WebCyfyqd;
import com.jfatty.zcloud.hospital.vo.WebCyqdList;
import com.jfatty.zcloud.hospital.vo.WebZyrqd;

import java.util.List;

/**
 * 描述 住/出院清单查看
 *
 * @author jfatty on 2020/7/15
 * @email jfatty@163.com
 */
public interface MedicalCheckListService {

    /**
     * 住院日清单查询
     * @param openId
     * @param openIdType
     * @param brid
     * @param startTime
     * @param endTime
     * @return
     */
    List<WebZyrqd> getWebZyrqd(String openId, Integer openIdType, String brid, String startTime, String endTime);

    /**
     * 住院记录查询
     * @param openId
     * @param openIdType
     * @param brid
     * @return
     */
    List<WebCyqdList> getWebCyqdList(String openId, Integer openIdType, String brid);

    /**
     * 出院清单查询
     * @param openId
     * @param openIdType
     * @param zybh
     * @return
     */
    List<WebCyfyqd> getWebCyfyqd(String openId, Integer openIdType, String zybh);
}
