package com.jfatty.zcloud.base.interfaces;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * 描述
 *
 * @author jfatty on 2019/12/10
 * @email jfatty@163.com
 */
public interface BFileInterface<T> {

    @RequestMapping(method = RequestMethod.POST, value = "/uploadFile",
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String uploadFile(@RequestPart(value = "file") MultipartFile file, @RequestParam(value = "fileType") String fileType);

    @RequestMapping("/downloadFile")
    ResponseEntity<byte[]> downloadFile(@RequestParam(value = "fileType")  String fileType);

}
