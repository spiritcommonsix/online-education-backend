package com.coc.eduservice.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.coc.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程列表 Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2021-04-10
 */
public interface EduCourseMapper extends BaseMapper<EduCourse> {
    List<HashMap<String,Object>> getCourseInfoByTeacher(HashMap<String,Object> map);

    List<HashMap<String,Object>> testQuery(HashMap<String,Object> map);

    List<HashMap<String,Object>> getCourseInfoByStudent(HashMap<String,Object> map);

    List<HashMap<String,Object>> getInspectList();

    @Select("select user_name from sys_user_table where user_id = #{userId}")
    String getUserNameById(@Param(value = "userId") String userId);

    @Select("select * from course_detail where course_id=#{courseId}")
    Map<String,Object> studentQueryCourseDetailById(String courseId);

    //封面，发布者，标题，收藏时间
    List<Map<String,Object>> getCollectCourse(String userId);
}
