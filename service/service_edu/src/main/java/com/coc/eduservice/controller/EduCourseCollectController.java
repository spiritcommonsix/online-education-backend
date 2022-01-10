package com.coc.eduservice.controller;


import com.coc.commonutils.ResultData;
import com.coc.eduservice.service.EduCourseCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户收藏课程 前端控制器
 * </p>
 *
 * @author cyx
 * @since 2021-04-26
 */
@RestController
@RequestMapping("/eduservice/courseCollect")
public class EduCourseCollectController {
    @Autowired
    private EduCourseCollectService collectService;

    @GetMapping("collect/{courseId}/{userId}")
    public ResultData collectCourse(@PathVariable("courseId") String courseId, @PathVariable("userId") String userId){
        return collectService.addCollect(courseId,userId);
    }
    @GetMapping("cancelCollect/{courseId}/{userId}")
    public ResultData cancelCollect(@PathVariable("courseId") String courseId, @PathVariable("userId") String userId){
        return collectService.cancelCollectCollect(courseId,userId);
    }

}

