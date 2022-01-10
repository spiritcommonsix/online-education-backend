package com.coc.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coc.commonutils.ResultData;
import com.coc.eduservice.entity.LikeCourse;
import com.coc.eduservice.mapper.LikeCourseMapper;
import com.coc.eduservice.service.LikeCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 点赞 服务实现类
 * </p>
 *
 * @author cyx
 * @since 2021-04-23
 */
@Service
public class LikeCourseServiceImpl extends ServiceImpl<LikeCourseMapper, LikeCourse> implements LikeCourseService {

    @Override
    public ResultData likeCourse(String courseId, String userId) {
        LikeCourse likeCourse=new LikeCourse();
        likeCourse.setCourseId(courseId);
        likeCourse.setUserId(userId);
        baseMapper.insert(likeCourse);
        return ResultData.ok();
    }

    @Override
    public ResultData unlikeCourse(String courseId, String userId) {
        QueryWrapper<LikeCourse> likeCourseQueryWrapper=new QueryWrapper<>();
        likeCourseQueryWrapper.eq("course_id",courseId);
        likeCourseQueryWrapper.eq("user_id",userId);
        baseMapper.delete(likeCourseQueryWrapper);
        return ResultData.ok();
    }
}
