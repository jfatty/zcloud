package com.jfatty.zcloud.health.api;

import com.jfatty.zcloud.base.utils.IDCardUtil;
import com.jfatty.zcloud.health.entity.HCSHealthCardInfo;
import com.jfatty.zcloud.health.res.HCSHealthCardInfoRes;
import com.jfatty.zcloud.health.service.HCSHealthCardInfoService;
import com.jfatty.zcloud.health.service.HealthCardStationService;
import com.jfatty.zcloud.health.vo.HealthCardInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URLEncoder;


/**
 * 描述
 *
 * @author jfatty on 2019/12/29
 * @email jfatty@163.com
 */
@Api(tags = "**副**002**电子健康卡平台对接API" ,value = "电子健康卡平台**对接**")
@Slf4j
@Controller
@RequestMapping(value={"/api/healthCardStation"})
public class ApiHealthCardStationViewController {

    @Autowired
    private HealthCardStationService healthCardStationService ;

    @Autowired
    private HCSHealthCardInfoService hcsHealthCardInfoService ;

    @ApiOperation(value=" 001****通过健康卡授权码获取用户健康卡信息接口 3.2.3 通过健康卡授权码获取接口",tags = "注意：页面自动跳转,页面加载时获取URL路径中携带的参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hospitalId", value = "医院ID",dataType = "String",defaultValue = "30646"),
            @ApiImplicitParam(name = "healthCode", value = "健康卡授权码",dataType = "String",defaultValue = "F9D3F8A308FC0EABC581F5903CAA1094")
    })
    @RequestMapping(value="/{hospitalId}/getHealthCardByHealthCode", method=RequestMethod.GET)
    public void getHealthCardByHealthCodePath(@PathVariable("hospitalId") String hospitalId , @RequestParam(value = "healthCode" , defaultValue = "F9D3F8A308FC0EABC581F5903CAA1094") String healthCode, HttpServletResponse response){
        try {

            //注意1：健康卡授权码healthCode有效期为30分钟且只能使用一次，一经使用立即失效。每次刷新会分配新的healthCode，为了保持平滑过渡，最近刷新的两个healthCode均有效，且次新healthCode将在5分钟后失效。
            //注意2：当用户在该页面点击添加健康卡按钮时，开放平台返回healthCode=0，因此ISV必须判断该情况：当healthCode=0时跳转到新用户建卡页面；
            //注意3：当用户在该页面点击暂不授权按钮时，开放平台返回healthCode=-1，因此ISV必须判断该情况：当healthCode=-1时跳转到上一个页面；
            log.error("hospitalId======>[{}]健康平台回传healthCode======>[{}]",hospitalId,healthCode);
            if ("0".equals(healthCode)) {
                //页面跳转到添加健康卡页面
                response.sendRedirect("http://dev.jfatty.com/HealthCardDemo/regist_new.html");
            } else if ("-1".equals(healthCode)){
                //不授权直接页面重定向返回健康卡列表页面 并且URL中携带参数提供给页面做判断
                response.sendRedirect("http://dev.jfatty.com/HealthCardDemo/list.html");
            }else {

                HCSHealthCardInfoRes hcsHealthCardInfoRes  = new HCSHealthCardInfoRes();

                HealthCardInfoVO healthCardInfoVO = healthCardStationService.getHealthCardByHealthCode(hospitalId,healthCode);
                BeanUtils.copyProperties(healthCardInfoVO,hcsHealthCardInfoRes);

                HCSHealthCardInfo db_HCSHealthCardInfo = hcsHealthCardInfoService.getByIdCardNumber(healthCardInfoVO.getIdNumber());
                HCSHealthCardInfo hcsHealthCardInfo = new HCSHealthCardInfo();

                BeanUtils.copyProperties(healthCardInfoVO,hcsHealthCardInfo);
                if (db_HCSHealthCardInfo != null){
                    hcsHealthCardInfoService.updateById(hcsHealthCardInfo);
                }else {
                    hcsHealthCardInfoService.saveId(hcsHealthCardInfo);
                }
                //改变名族为字典
                String nation = hcsHealthCardInfoRes.getNation();
                String nationDic = hcsHealthCardInfoService.getNationDicStr(nation);
                hcsHealthCardInfoRes.setIdNumber(IDCardUtil.coverStarts(hcsHealthCardInfoRes.getIdNumber(),8,14));
                hcsHealthCardInfoRes.setNation(nationDic);

                String path = "http://dev.jfatty.com/HealthCardDemo/personal.html" ;
                String params = getPostParams(hcsHealthCardInfoRes);
                params = URLEncoder.encode(params,"UTF-8");
                log.error("编码后的URL参数[{}]",params);
                path = path + "?" + params ;
                //去健康卡详情页面
                response.sendRedirect(path);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @ApiOperation(value=" 002****通过医院ID与健康卡信息记录ID(系统健康卡ID)跳转至电子健康卡详情页面",tags = "注意：页面自动跳转,页面加载时获取URL路径中携带的参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hospitalId", value = "医院ID",dataType = "String",defaultValue = "30646"),
            @ApiImplicitParam(name = "healthCardInfoId", value = "健康卡信息记录ID(系统健康卡ID)",dataType = "String",defaultValue = "2C9580916F47F3AA016F47F3AA0F0000")
    })
    @RequestMapping(value="/{hospitalId}/getHealthCardByHealthCardInfoId", method=RequestMethod.GET)
    public void getHealthCardByHealthCardInfoId(@PathVariable("hospitalId") String hospitalId , @RequestParam(value = "healthCardInfoId" , defaultValue = "2C9580916F47F3AA016F47F3AA0F0000") String healthCardInfoId, HttpServletResponse response){
        try {
            HCSHealthCardInfoRes hcsHealthCardInfoRes  = new HCSHealthCardInfoRes();
            HCSHealthCardInfo hcsHealthCardInfo = hcsHealthCardInfoService.getById(healthCardInfoId);
            BeanUtils.copyProperties(hcsHealthCardInfo,hcsHealthCardInfoRes);
            //改变名族为字典
            String nation = hcsHealthCardInfoRes.getNation();
            String nationDic = hcsHealthCardInfoService.getNationDicStr(nation);
            hcsHealthCardInfoRes.setIdNumber(IDCardUtil.coverStarts(hcsHealthCardInfoRes.getIdNumber(),8,14));
            hcsHealthCardInfoRes.setNation(nationDic);

            String path = "http://dev.jfatty.com/HealthCardDemo/personal.html" ;
            String params = getPostParams(hcsHealthCardInfoRes);
            params = URLEncoder.encode(params,"UTF-8");
            log.error("编码后的URL参数[{}]",params);
            path = path + "?" + params ;
            //去健康卡详情页面
            response.sendRedirect(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //加入微信卡包 addWechatPack
    @ApiOperation(value=" 003**** 用户点击 加入微信卡包 跳转至微信卡包电子健康卡领取页面",tags = "注意：页面自动跳转,页面加载时获取URL路径中携带的参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hospitalId", value = "医院ID",dataType = "String",defaultValue = "30646"),
            @ApiImplicitParam(name = "healthCardInfoId", value = "健康卡信息记录ID(系统健康卡ID)",dataType = "String",defaultValue = "2C9580916F47F3AA016F47F3AA0F0000")
    })
    @RequestMapping(value="/{hospitalId}/addWechatPack", method=RequestMethod.GET)
    public void addWechatPack(@PathVariable("hospitalId") String hospitalId , @RequestParam(value = "healthCardInfoId" , defaultValue = "2C9580916F47F3AA016F47F3AA0F0000") String healthCardInfoId, HttpServletResponse response){
        try {
            HCSHealthCardInfoRes hcsHealthCardInfoRes  = new HCSHealthCardInfoRes();
            HCSHealthCardInfo hcsHealthCardInfo = hcsHealthCardInfoService.getById(healthCardInfoId);



            BeanUtils.copyProperties(hcsHealthCardInfo,hcsHealthCardInfoRes);
            //改变名族为字典
            String nation = hcsHealthCardInfoRes.getNation();
            String nationDic = hcsHealthCardInfoService.getNationDicStr(nation);
            hcsHealthCardInfoRes.setIdNumber(IDCardUtil.coverStarts(hcsHealthCardInfoRes.getIdNumber(),8,14));
            hcsHealthCardInfoRes.setNation(nationDic);

            String path = "http://dev.jfatty.com/HealthCardDemo/personal.html" ;
            String params = getPostParams(hcsHealthCardInfoRes);
            params = URLEncoder.encode(params,"UTF-8");
            log.error("编码后的URL参数[{}]",params);
            path = path + "?" + params ;
            //去健康卡详情页面
            response.sendRedirect(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     *
     * @Title: getPostParams
     * @Description: 将实体类clazz的属性转换为url参数
     * @param clazz	参数实体类
     * @return
     * String
     */
    private String getPostParamsXXX(Object clazz) {
        Field[] fields = clazz.getClass().getDeclaredFields();

        StringBuilder requestURL = new StringBuilder();
        try {
            boolean flag = true;
            String property, value;
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                // 允许访问私有变量
                field.setAccessible(true);

                // 属性名
                property = field.getName();
                // 属性值
                value = field.get(clazz).toString();

                System.out.println(property+":"+value);
            }
        } catch (Exception e) {
            log.error("用户播放轨迹查询Qos 日志失败,参数为：" + clazz.toString());
        }
        return requestURL.toString();
    }


    /**
     *
     * @Title: getPostParams
     * @Description: 将实体类clazz的属性转换为url参数
     * @param clazz	参数实体类
     * @return
     * String
     */
    private static String getPostParams(Object clazz) {
        // 遍历属性类、属性值
        Field[] fields = clazz.getClass().getDeclaredFields();

        StringBuilder requestURL = new StringBuilder();
        try {
            boolean flag = true;
            String property, value;
            System.out.println(fields.length);

            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                // 允许访问私有变量
                field.setAccessible(true);

                // 属性名
                property = field.getName();
                Object tmp = field.get(clazz);
                if (tmp == null)
                    continue;
                // 属性值
                value = field.get(clazz).toString();
                String params = property + "=" + value;
                if (flag) {
                    requestURL.append(params);
                    flag = false;
                } else {
                    requestURL.append("&" + params);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            log.error("URL参数为：" + clazz.toString());
        }
        return requestURL.toString();
    }


//    public static void main(String[] args) {
//        HCSHealthCardInfoRes hcsHealthCardInfoRes  = new HCSHealthCardInfoRes();
//        hcsHealthCardInfoRes.setAddress("湖北");
//        hcsHealthCardInfoRes.setBirthday("1994-11-10");
//        hcsHealthCardInfoRes.setGender("男");
//        hcsHealthCardInfoRes.setHealthCardId("225585828");
//        hcsHealthCardInfoRes.setNation("土家族");
//        hcsHealthCardInfoRes.setName("杨三");
//        hcsHealthCardInfoRes.setIdNumber("2585858588");
//        String url = getPostParams(hcsHealthCardInfoRes);
//        System.out.println(url);
//    }



}
