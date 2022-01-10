package com.coc.eduservice.service;

import com.coc.commonutils.ResultData;
import com.coc.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.coc.servicebase.vo.AddCourseVo;
import com.coc.servicebase.vo.StudentIndexCourseQuery;
import com.coc.servicebase.vo.TeacherCourseQuery;

/**
 * <p>
 * 课程列表 服务类
 * </p>
 *
 * @author testjava
 * @since 2021-04-10
 */
public interface EduCourseService extends IService<EduCourse> {

    ResultData addCourse(AddCourseVo courseVo);

    ResultData getListByUserId(String userId, int current, int pageSize, TeacherCourseQuery query);

    ResultData selectCourseByStudent(int current,int pageSize,StudentIndexCourseQuery query);

    ResultData getInspectList(int current, int pageSize);

    ResultData getCourseDetail(String courseId);

    ResultData updateStatus(String courseId,String statusId);

    ResultData removeCourseByTeacher(String courseId);

    ResultData getCourseDetailByStudent(String courseId,String userId);

    ResultData getCollectCourses(String userId, int current, int pageSize);
}
