package com.jfatty.zcloud.base.api;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.jfatty.zcloud.base.dto.BaseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * 描述
 *
 * @author jfatty on 2019/12/10
 * @email jfatty@163.com
 */
@Slf4j
public class ApiBaseFileController<T extends Model,P extends BaseDTO,R extends BaseDTO > extends ApiBaseController<T,P,R> {


    /**
     * 文件上传
     * @param file 文件
     * @param fileType
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/uploadFile",
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadFile(@RequestPart(value = "file") MultipartFile file,
                             @RequestParam(value = "fileType") String fileType,
                             HttpServletRequest request, HttpServletResponse response) {
        System.out.println("fileType:"+fileType);
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
        File dest =   new File("f:/b13/"+uuid+suffix);
        try {
            file.transferTo(dest);

            return dest.getCanonicalPath();//文件的绝对路径
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }
        return "failure";
    }

    /**
     * 文件（二进制数据）下载
     * @param fileType 文件类型
     * @return
     */
    @RequestMapping("/downloadFile")
    public  ResponseEntity<byte[]> downloadFile(String fileType,HttpServletRequest request ){
        System.out.println(request.getParameter("fileType"));
        System.out.println("参数fileType: "+fileType);
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<byte[]> entity = null;
        InputStream in=null;
        try {
            in=new FileInputStream(new File("d:/myImg/001.png"));
            byte[] bytes = new byte[in.available()];
            String imageName="001.png";
            //处理IE下载文件的中文名称乱码的问题
            String header = request.getHeader("User-Agent").toUpperCase();
            if (header.contains("MSIE") || header.contains("TRIDENT") || header.contains("EDGE")) {
                imageName = URLEncoder.encode(imageName, "utf-8");
                imageName = imageName.replace("+", "%20");    //IE下载文件名空格变+号问题
            } else {
                imageName = new String(imageName.getBytes(), "iso-8859-1");
            }
            in.read(bytes);
            headers.add("Content-Disposition", "attachment;filename="+imageName);
            entity = new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(in!=null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return entity;
    }

}
