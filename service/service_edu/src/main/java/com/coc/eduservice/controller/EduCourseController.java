package com.coc.eduservice.controller;


import com.coc.commonutils.ResultData;
import com.coc.eduservice.entity.EduCourse;

import com.coc.eduservice.service.EduCourseService;
import com.coc.servicebase.exception.MyServiceException;
import com.coc.servicebase.vo.AddCourseVo;
import com.coc.servicebase.vo.StudentIndexCourseQuery;
import com.coc.servicebase.vo.TeacherCourseQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程列表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-04-10
 */
@RestController
@RequestMapping("/eduservice/educourse")
@CrossOrigin
public class EduCourseController {
    @Autowired
    private EduCourseService courseService;

    //添加课程
    @PostMapping("addCourse")
    public ResultData addCourse(@RequestBody AddCourseVo courseVo)
    {
        return courseService.addCourse(courseVo);
    }

    //教师端查询课程
    @PostMapping("getCourseList/{userId}/{current}/{pageSize}")
    public ResultData getCourseListByUserId(@PathVariable("userId") String userId,
                                            @PathVariable("current") int current,
                                            @PathVariable("pageSize") int pageSize,
                                            @RequestBody TeacherCourseQuery query)
    {
        return courseService.getListByUserId(userId,current,pageSize,query);
    }
    //TODO 教师端获取某课程的章节列表
    @GetMapping("getUpateChaptersList/{courseId}")
    public ResultData getUpdateChaptersList(@PathVariable("courseId") String courseId)
    {
        return courseService.getCourseDetail(courseId);
    }
    @GetMapping("update_status/{courseId}/{statusId}")
    public ResultData submitInspect(@PathVariable("courseId") String courseId,@PathVariable("statusId") String statusId){
        return courseService.updateStatus(courseId,statusId);
    }

    @PostMapping("studnetGetCourse/{current}/{pageSize}")
    public ResultData getCourseByStudent( @PathVariable("current") int current,
                                          @PathVariable("pageSize") int pageSize,@RequestBody StudentIndexCourseQuery query){
        return courseService.selectCourseByStudent(current,pageSize,query);
    }

    // TODO 审核课程列表
    @GetMapping("getInspectCourse/{current}/{pageSize}")
    public ResultData getInspectList(@PathVariable("current") int current,@PathVariable("pageSize") int pageSize)
    {
        return courseService.getInspectList(current,pageSize);
    }
    @GetMapping("remove/{courseId}")
    public ResultData removeCourseById(@PathVariable("courseId") String courseId)
    {
        return courseService.removeCourseByTeacher(courseId);
    }


    @GetMapping("getCourseDetail/{courseId}/{userId}")
    public ResultData getCourseDetailByStudent(@PathVariable("courseId") String courseId,@PathVariable("userId") String userId)
    {
        return courseService.getCourseDetailByStudent(courseId,userId);
    }
    //TODO 在此添加每个评论的回复树，使用笨办法。

    //TODO 获取收藏的课程列表
    @GetMapping("getCollect/{userId}/{current}/{pageSize}")
    public ResultData getCollectByStudent(@PathVariable("userId") String userId,@PathVariable("current") int current, @PathVariable("pageSize") int pageSize){
        return courseService.getCollectCourses(userId,current,pageSize);
    }
}

