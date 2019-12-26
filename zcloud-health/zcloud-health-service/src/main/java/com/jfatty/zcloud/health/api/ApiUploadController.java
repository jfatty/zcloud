package com.jfatty.zcloud.health.api;

import com.jfatty.zcloud.health.service.HealthCardStationService;
import com.jfatty.zcloud.health.vo.HCSIDCardInfoVO;
import com.jfatty.zcloud.system.feign.IdentityFileFeignClient;
import com.jfatty.zcloud.system.req.IdentityFileReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import java.util.UUID;

/**
 * 描述
 *
 * @author jfatty on 2019/12/14
 * @email jfatty@163.com
 */
@Slf4j
@RestController
public class ApiUploadController {

    @Autowired
    private IdentityFileFeignClient identityFileFeignClient ;

    @Autowired
    private HealthCardStationService healthCardStationService ;

    @RequestMapping(method = RequestMethod.POST, value = "/uploadFile",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Object uploadFile(@RequestPart(value = "files") MultipartFile[] files){
        for (MultipartFile file : files){
            long size= file.getSize();
            String contentType= file.getContentType();
            String name = file.getName();
            String orgFilename= file.getOriginalFilename();
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
                String appId = "b9b77d6b9ba46db83a7dbb158c4740c4" ;
                BASE64Encoder encoder = new BASE64Encoder();
                //String imgData = encoder.encode(file.getBytes());
                //System.out.println(imgData);
                //System.out.println("============================================================>");
                //String imageContent = new String(files[0].getBytes());
                //System.out.println(imageContent);
                String imageContent = encoder.encode(file.getBytes());
                HCSIDCardInfoVO hcsidCardInfoVO = healthCardStationService.ocrInfo(appId,imageContent);
                return  hcsidCardInfoVO ;
            } catch (Exception e) {
                e.printStackTrace();
            }

            IdentityFileReq identityFile = new IdentityFileReq();
            try {
                identityFile.setAvatar(file);
                identityFileFeignClient.save(identityFile);
                return identityFileFeignClient.view("4028FE816F04A799016F04AB02ED0003") ;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "" ;
    }

}
