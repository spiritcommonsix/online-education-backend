package com.coc.eduservice.client;

import com.coc.commonutils.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "ali-service") //调用的服务名称
@Component
public interface AliClient {
    @PostMapping(value="/ali_service/upload/uploadavatoar/{userId}" ,consumes = "multipart/form-data")
    public ResultData uploadOssFile(@PathVariable("userId") String userId, MultipartFile file);

    @GetMapping("/ali_service/upload/delete/{videoId}")
    public ResultData deleteVideoById(@PathVariable("videoId") String videoId);

    @GetMapping("/ali_service/upload/get_play_auth/{videoId}")
    public ResultData getPlayAuthByVideoId(@PathVariable("videoId") String videoId);
}
