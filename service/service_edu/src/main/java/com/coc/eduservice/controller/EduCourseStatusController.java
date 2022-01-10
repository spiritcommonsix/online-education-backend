package com.coc.eduservice.controller;


import com.coc.commonutils.ResultData;
import com.coc.eduservice.service.EduCourseStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 课程状态 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-04-10
 */
@RestController
@RequestMapping("/eduservice/course_status")
public class EduCourseStatusController {
    @Autowired
    private EduCourseStatusService statusService;

    //獲取所有的課程狀態
    @GetMapping("getAllStatus")
    public ResultData getAllStatus()
    {
        return statusService.getAllStatus();
    }
}

