package com.coc.eduservice.controller;


import com.coc.commonutils.ResultData;
import com.coc.eduservice.service.LikeCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 点赞 前端控制器
 * </p>
 *
 * @author cyx
 * @since 2021-04-23
 */
@RestController
@RequestMapping("/eduservice/likeCourse")
public class LikeCourseController {
    @Autowired
    LikeCourseService likeCourseService;

    @GetMapping("like/{courseId}/{userId}")
    public ResultData likeCourse(@PathVariable("courseId") String courseId, @PathVariable("userId") String userId){
        return likeCourseService.likeCourse(courseId,userId);
    }
    @GetMapping("unlike/{courseId}/{userId}")
    public ResultData unlikeCourse(@PathVariable("courseId") String courseId, @PathVariable("userId") String userId){
        return likeCourseService.unlikeCourse(courseId,userId);
    }
}

