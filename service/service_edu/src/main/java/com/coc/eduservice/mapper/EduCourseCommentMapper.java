package com.coc.eduservice.mapper;

import com.coc.eduservice.entity.EduCourseComment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 评论 Mapper 接口
 * </p>
 *
 * @author cyx
 * @since 2021-04-26
 */
public interface EduCourseCommentMapper extends BaseMapper<EduCourseComment> {
    @Select("select * from front_comment where course_id=#{courseId} and sort=1 order by gmt_create desc")
    public List<Map<String,Object>> getBannerComments(@Param("courseId") String courseId);
}
