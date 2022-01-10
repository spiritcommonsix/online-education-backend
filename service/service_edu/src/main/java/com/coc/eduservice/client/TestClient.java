package com.coc.eduservice.client;


import com.coc.commonutils.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-member") //调用的服务名称
@Component
public interface TestClient {
    @GetMapping("/edumember/testcontroller/test")
    public ResultData test();

}
