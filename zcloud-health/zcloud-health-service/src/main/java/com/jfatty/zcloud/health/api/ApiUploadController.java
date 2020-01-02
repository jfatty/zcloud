package com.jfatty.zcloud.health.api;

import com.jfatty.zcloud.base.utils.RETResultUtils;
import com.jfatty.zcloud.health.entity.HCSIDCardInfo;
import com.jfatty.zcloud.health.res.HCSIDCardInfoRes;
import com.jfatty.zcloud.health.service.HCSIDCardInfoService;
import com.jfatty.zcloud.health.service.HealthCardStationService;
import com.jfatty.zcloud.health.vo.HCSIDCardInfoVO;
import com.jfatty.zcloud.system.feign.IdentityFileFeignClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.UUID;

/**
 * 描述
 *
 * @author jfatty on 2019/12/14
 * @email jfatty@163.com
 */
@Api(tags = "测试文件上传API" ,value = "电子健康卡测试文件上传")
@Slf4j
@RestController
public class ApiUploadController {

    @Autowired
    private IdentityFileFeignClient identityFileFeignClient ;

    @Autowired
    private HealthCardStationService healthCardStationService ;

    @Autowired
    private HCSIDCardInfoService hcsidCardInfoService ;

    @ApiOperation(value=" **** 测试文件上传 服务端上传健康卡平台成功后 将返回用户身份信息")
    @RequestMapping(method = RequestMethod.POST, value = "/uploadFile",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public RETResultUtils<HCSIDCardInfoRes> uploadFile(@RequestParam(value = "hospitalId" , defaultValue = "30646" ) String hospitalId , @RequestPart(value = "files") MultipartFile files){
        long size= files.getSize();
        String contentType= files.getContentType();
        String name = files.getName();
        String orgFilename= files.getOriginalFilename();
        System.out.println("size:"+size);
        System.out.println("contentType:"+contentType);
        System.out.println("name:"+name);
        System.out.println("orgFilename:"+orgFilename);
        String suffix = orgFilename.substring(orgFilename.lastIndexOf("."));//后缀
        String uuid =UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        System.out.println( uuid +":"+suffix);
        //appSecret
        //String secret = "626b6e57b68a2c65643a4ba4ealkid";
        //创建健康卡实例，传入appSecret
        //HealthCardServerImpl healthCard = new HealthCardServerImpl(secret);
        try {
            BASE64Encoder encoder = new BASE64Encoder();
            //String imgData = encoder.encode(file.getBytes());
            //System.out.println(imgData);
            //System.out.println("============================================================>");
            //String imageContent = new String(files[0].getBytes());
            //System.out.println(imageContent);
            String imageContent = encoder.encode(files.getBytes());
            imageContent = imageContent.replaceAll("\r|\n","");
            System.out.println(imageContent);
            HCSIDCardInfoVO hcsidCardInfoVO = healthCardStationService.ocrInfo(hospitalId,imageContent);
            HCSIDCardInfo db_hcsidCardInfo = hcsidCardInfoService.getById(hcsidCardInfoVO.getId());
            String birth = hcsidCardInfoVO.getBirth() ;
            DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");//对日期进行格式化
            birth = df.format(format.parse(birth));
            hcsidCardInfoVO.setBirth(birth);
            BeanUtils.copyProperties(hcsidCardInfoVO,db_hcsidCardInfo);
            if( db_hcsidCardInfo == null){
                hcsidCardInfoService.save(db_hcsidCardInfo);
            }else {
                hcsidCardInfoService.updateById(db_hcsidCardInfo);
            }
            HCSIDCardInfoRes hcsidCardInfoRes = new HCSIDCardInfoRes();
            BeanUtils.copyProperties(hcsidCardInfoVO,hcsidCardInfoRes);
            return new RETResultUtils(hcsidCardInfoRes) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        //IdentityFileReq identityFile = new IdentityFileReq();
        //try {
        //identityFile.setAvatar(file);
        //identityFileFeignClient.save(identityFile);
        //return identityFileFeignClient.view("4028FE816F04A799016F04AB02ED0003") ;
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}
        return RETResultUtils.faild("网络异常!请稍后重试") ;
    }



}
