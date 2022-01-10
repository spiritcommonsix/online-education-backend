package com.coc.security.controller;

import com.coc.commonutils.ResultData;
import com.coc.security.client.EduClient;
import com.coc.security.client.FileClient;
import com.coc.security.client.MemberClient;
import com.coc.servicebase.vo.AddCourseVo;
import com.coc.servicebase.vo.TestStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private MemberClient memberClient;

    @Autowired
    private FileClient fileClient;

    @Autowired
    EduClient courseClient;

    @GetMapping("testController")
    public ResultData testController()
    {
        return memberClient.getUserInfoByUserName("admin");
    }

    @PostMapping("addCourse")
    public ResultData testAdd(@RequestBody AddCourseVo vo)
    {
        return courseClient.addCourse(vo);
//        return ResultData.ok().data("vo",vo);
    }
    @PostMapping("upload/{userId}")
    public ResultData testUpload(MultipartFile file,@PathVariable("userId") String userId)
    {
        return fileClient.userUploadAvator(file,userId);
    }
}
