package com.jfatty.zcloud.health.api;

import com.jfatty.zcloud.system.feign.IdentityFileFeignClient;
import com.jfatty.zcloud.system.req.IdentityFileReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

            IdentityFileReq identityFile = new IdentityFileReq();
            try {
                identityFile.setAvatar(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
            identityFileFeignClient.save(identityFile);
        }

        return identityFileFeignClient.view("4028FE816F04A799016F04AB02ED0003") ;
    }

}
