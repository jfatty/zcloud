package com.jfatty.zcloud.hospital.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.jfatty.zcloud.base.utils.StringUtils;
import com.jfatty.zcloud.hospital.datasource.TargetDataSource;
import com.jfatty.zcloud.hospital.mapper.ComplexPatientMapper;
import com.jfatty.zcloud.hospital.res.NumoPatientDeatilRes;
import com.jfatty.zcloud.hospital.service.ComplexPatientService;
import com.jfatty.zcloud.hospital.vo.NumoPatientInfo;
import com.jfatty.zcloud.hospital.vo.WebRegPatient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<WebRegPatient> getWebRegList(String openId, Integer openIdType) {
        return getWebRegList(openId,openIdType,1,10);
    }

    @TargetDataSource(name="mssql")
    @Override
    public List<WebRegPatient> getWebRegList(String openId, Integer openIdType, Integer pageIndex, Integer pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("openId", openId);
        map.put("openIdType", openIdType);
        List<WebRegPatient> list = complexPatientMapper.getWebRegPatientList(map);
        return list;
    }

    @TargetDataSource(name="mssql")
    @Override
    public boolean saveComplexPatient(String openId, Integer openIdType, String name, String gender, String idCard, String tel, String address, String nation,String relationship,Integer hasCard, String hisCardNo, String hisCardType) throws Exception {
        String regMSg = "" ;
        List<WebRegPatient> list = null ;
        Map<String, Object> map = new HashMap<String, Object>();
        NumoPatientInfo numoPatientInfo  = new NumoPatientInfo().setName(name).setIdCard(idCard).setTel(tel).setNation(nation).setRelationship(relationship).setHasCard(hasCard);
        map.put("idCard", idCard);
        map.put("name", name);
        map.put("tel", tel);
        map.put("openId", openId);
        map.put("openIdType", openIdType);
        if(StringUtils.isEmptyOrBlank(hisCardNo) && hasCard == 0 ) {
            regMSg = "通过 姓名 身份证号绑定 " ;
            list = complexPatientMapper.webRegPatient(map);
        } else if (StringUtils.isNotEmptyAndBlank(hisCardNo) && hasCard == 1){
            regMSg = "通过绑定就诊卡号绑定 就诊卡号:" + hisCardNo + " 就诊卡类型:" + hisCardType  ;
            String [] tmps = hisCardType.split(":::");
            if (tmps.length != 3)
                throw new RuntimeException("就诊卡类型数据格式错误!");
            map.put("Type", tmps[1]);
            map.put("No", hisCardNo);
            numoPatientInfo.setHisCardNo(hisCardNo);
            numoPatientInfo.setHisCardType(hisCardType);
            numoPatientInfo.setHisCardTypeCode(tmps[1]);
            list = complexPatientMapper.webRegOtherPatient(map);
        } else {
            throw new RuntimeException("就诊人数据有误!");
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
                if(StringUtils.isEmptyOrBlank(webRegPatient.getDz()) && StringUtils.isNotEmptyAndBlank(address))
                    numoPatientInfo.setAddress(address);
                int affect = complexPatientMapper.addNumoPatientInfo(numoPatientInfo,openId,openIdType);
                log.error("绑定就诊人 数据库受影响行数: [{}]",affect);
                return true ;
            }
            throw new RuntimeException(list.get(0).getMsg()) ;
        }
        log.error("绑定就诊人 失败  病人姓名 [{}] 性别 [{}] 身份证号码 [{}] 电话 [{}] openId [{}] openIdType [{}] 绑定方式[{}]",name,gender,idCard,tel,openId,openIdType,regMSg);
        return false;
    }

    @TargetDataSource(name="mssql")
    @Override
    public NumoPatientDeatilRes getNumoPatientInfo(String openId, String brid) {
        NumoPatientDeatilRes numoPatientDeatilRes = new NumoPatientDeatilRes();
        NumoPatientInfo numoPatientInfo  = complexPatientMapper.getNumoPatientInfo(brid);
        BeanUtils.copyProperties(numoPatientInfo,numoPatientDeatilRes);
        return numoPatientDeatilRes;
    }

    @TargetDataSource(name="mssql")
    @Override
    public NumoPatientDeatilRes getNumoPatientInfo(String openId, Integer openIdType, String brid) {
        NumoPatientDeatilRes numoPatientDeatilRes = new NumoPatientDeatilRes();
        NumoPatientInfo numoPatientInfo  = complexPatientMapper.getNumoPatientInfo(brid);
        BeanUtils.copyProperties(numoPatientInfo,numoPatientDeatilRes);
        int count = complexPatientMapper.checkDefaultPatByBrid(openId, openIdType, brid);                      //查询此就诊人和对应用户是否为绑定默认就诊人关系
        numoPatientDeatilRes.setDefaultPat( count>0?1:0 );
        String nation  = numoPatientInfo.getNation() ;                                                      //民族
        String relationship = numoPatientInfo.getRelationship() ;
        if(StringUtils.isNotEmptyAndBlank(nation)){
            String [] tmps = nation.split(":::");
            numoPatientDeatilRes.setNation(tmps[0]);
        }
        if(StringUtils.isNotEmptyAndBlank(relationship)){
            String [] tmps = relationship.split(":::");
            numoPatientDeatilRes.setRelationship(tmps[0]);
        }
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

    @TargetDataSource(name="mssql")
    @Override
    public boolean checkRightByBrid(String openId, Integer openIdType, String brid) {
        int count = complexPatientMapper.checkRightByBrid(openId,openIdType,brid);
        return (count > 0);
    }

    @TargetDataSource(name="mssql")
    @Override
    public boolean bindDefaultPat(String openId, Integer openIdType, String brid,Integer bindStatus) throws Exception {
        if (bindStatus == 0)
            brid = "" ;
        int count = complexPatientMapper.bindDefaultPat(openId,openIdType,brid);
        return (count > 0);
    }
}
