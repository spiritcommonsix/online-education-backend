package com.coc.eduservice.controller;


import com.coc.commonutils.ResultData;
import com.coc.eduservice.service.InspectCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 管理员审核课程 前端控制器
 * </p>
 *
 * @author cyx
 * @since 2021-05-19
 */
@RestController
@RequestMapping("/eduservice/inspectCourse")
public class InspectCourseController {
    @Autowired
    private InspectCourseService inspectCourseService;

    @GetMapping("create/{adminId}/{courseId}/{statusId}/{price}")
    public ResultData createInspect(@PathVariable("adminId")String adminId,@PathVariable("courseId")String courseId,@PathVariable("statusId")String statusId,@PathVariable("price") float price){
        return inspectCourseService.createInspect(adminId,courseId,statusId,price);
    }
}

