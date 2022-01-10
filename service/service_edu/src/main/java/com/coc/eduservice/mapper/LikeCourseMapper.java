package com.coc.eduservice.mapper;

import com.coc.eduservice.entity.LikeCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 点赞 Mapper 接口
 * </p>
 *
 * @author cyx
 * @since 2021-04-23
 */
public interface LikeCourseMapper extends BaseMapper<LikeCourse> {
    public int getLikeNumByCourseId(String courseId);
}
