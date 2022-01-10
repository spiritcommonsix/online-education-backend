package com.coc.security.client;

import com.coc.commonutils.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "service-file") //调用的服务名称
@Component
public interface FileClient {

    @PostMapping(value="/file/upload/test" ,consumes = "multipart/form-data")
    public ResultData uploadFile(MultipartFile multipartFile);

    @PostMapping(value="/file/upload/user/avatar/{userId}" ,consumes = "multipart/form-data")
    public ResultData userUploadAvatar(MultipartFile file,@PathVariable("userId") String userId);
}
