package com.jfatty.zcloud.hospital.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.jfatty.zcloud.base.utils.StringUtils;
import com.jfatty.zcloud.hospital.datasource.TargetDataSource;
import com.jfatty.zcloud.hospital.mapper.ComplexPatientMapper;
import com.jfatty.zcloud.hospital.res.NumoPatientDeatilRes;
import com.jfatty.zcloud.hospital.res.WebRegPatientRes;
import com.jfatty.zcloud.hospital.service.ComplexPatientService;
import com.jfatty.zcloud.hospital.vo.NumoPatientInfo;
import com.jfatty.zcloud.hospital.vo.WebRegPatient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
@Slf4j
@Service
public class ComplexPatientServiceImpl implements ComplexPatientService {

    @Autowired
    private ComplexPatientMapper complexPatientMapper;

    @TargetDataSource(name="mssql")
    @Override
    public List<WebRegPatientRes> getWebRegList(String openId, Integer openIdType) {
        return getWebRegList(openId,openIdType,1,10);
    }

    @TargetDataSource(name="mssql")
    @Override
    public List<WebRegPatientRes> getWebRegList(String openId, Integer openIdType, Integer pageIndex, Integer pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("openId", openId);
        map.put("openIdType", openIdType);
        List<WebRegPatient> list = complexPatientMapper.getWebRegPatientList(map);
        if(CollectionUtils.isNotEmpty(list)){
            List<WebRegPatientRes> results = new ArrayList<WebRegPatientRes>();
            list.forEach(
                    webRegPatient -> {
                        WebRegPatientRes webRegPatientRes = new WebRegPatientRes();
                        BeanUtils.copyProperties(webRegPatient,webRegPatientRes);
                        results.add(webRegPatientRes);
                    }
            );
            return results ;
        }
        return null;
    }

    @TargetDataSource(name="mssql")
    @Override
    public boolean saveComplexPatient(String openId, Integer openIdType, String name, String idCard, String tel, String address, String nation, String hisCardNo, String hisCardType) throws Exception {
        String regMSg = "" ;
        List<WebRegPatient> list = null ;
        Map<String, Object> map = new HashMap<String, Object>();
        NumoPatientInfo numoPatientInfo  = new NumoPatientInfo().setName(name).setIdCard(idCard).setAddress(address);
        map.put("idCard", idCard);
        map.put("name", name);
        map.put("tel", tel);
        map.put("openId", openId);
        map.put("openIdType", openIdType);
        if(StringUtils.isEmptyOrBlank(hisCardNo)) {
            regMSg = "通过 姓名 身份证号绑定 " ;
            list = complexPatientMapper.webRegPatient(map);
        } else {
            regMSg = "通过绑定就诊卡号绑定 就诊卡号:" + hisCardNo + " 就诊卡类型:" + hisCardType  ;
            String [] tmps = hisCardType.split(":::");
            System.out.println(tmps.length);
            if (tmps.length != 3)
                throw new RuntimeException("就诊卡类型数据格式错误!");
            map.put("Type", tmps[1]);
            map.put("No", hisCardNo);
            numoPatientInfo.setHisCardNo(hisCardNo);
            numoPatientInfo.setHisCardType(hisCardType);
            list = complexPatientMapper.webRegOtherPatient(map);
        }
        if (CollectionUtils.isNotEmpty(list)){
            if( list.size() == 1 && list.get(0).success() ){ //成绑定
                WebRegPatient webRegPatient = list.get(0) ;
                if(StringUtils.isNotEmptyAndBlank(webRegPatient.getCkh()))
                    numoPatientInfo.setCardNo(webRegPatient.getCkh());
                if(StringUtils.isNotEmptyAndBlank(webRegPatient.getXb())){
                    Integer gend = webRegPatient.getXb().contains("男") ? 1 : 2;               //性别
                    numoPatientInfo.setGender(gend);
                }
                if(StringUtils.isNotEmptyAndBlank(webRegPatient.getBrid()))
                    numoPatientInfo.setPatId(webRegPatient.getBrid());                           //病人在HIS中的唯一码
                if(StringUtils.isNotEmptyAndBlank(webRegPatient.getDz()))
                    numoPatientInfo.setAddress(webRegPatient.getDz());
                int affect = complexPatientMapper.addNumoPatientInfo(numoPatientInfo,openId,openIdType);
                log.error("绑定就诊人 数据库受影响行数: [{}]",affect);
                return true ;
            }
            throw new RuntimeException(list.get(0).getMsg()) ;
        }
        log.error("绑定就诊人 失败  病人姓名 [{}] 身份证号码 [{}] 电话 [{}] openId [{}] openIdType [{}] 绑定方式[{}]",name,idCard,tel,openId,openIdType,regMSg);
        return false;
    }

    @TargetDataSource(name="mssql")
    @Override
    public NumoPatientDeatilRes getNumoPatientInfo(String brid) {
        NumoPatientDeatilRes numoPatientDeatilRes = new NumoPatientDeatilRes();
        NumoPatientInfo numoPatientInfo  = complexPatientMapper.getNumoPatientInfo(brid);
        BeanUtils.copyProperties(numoPatientInfo,numoPatientDeatilRes);
        return numoPatientDeatilRes;
    }

    @TargetDataSource(name="mssql")
    @Override
    public boolean deleteComplexPatient(Long pid, String idCard, String name, String openId, Integer openIdType) throws Exception {
        WebRegPatient webRegPatient = complexPatientMapper.webUnReg(idCard,name,openId,openIdType);
        if(webRegPatient != null && webRegPatient.success() ) {
            //3.本地系统解除绑定
            complexPatientMapper.localUnBind(openId,openIdType,pid);//解绑用户和就诊人
            return true;
        }
        return false;
    }

    @TargetDataSource(name="mssql")
    @Override
    public NumoPatientInfo getNumoPatientInfoByBrid(String brid) {
        return complexPatientMapper.getNumoPatientInfo(brid);
    }
}
