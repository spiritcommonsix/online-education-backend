package com.coc.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coc.commonutils.ResultData;
import com.coc.eduservice.entity.EduCourseCollect;
import com.coc.eduservice.mapper.EduCourseCollectMapper;
import com.coc.eduservice.service.EduCourseCollectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户收藏课程 服务实现类
 * </p>
 *
 * @author cyx
 * @since 2021-04-26
 */
@Service
public class EduCourseCollectServiceImpl extends ServiceImpl<EduCourseCollectMapper, EduCourseCollect> implements EduCourseCollectService {

    @Override
    public ResultData addCollect(String courseId, String userId) {
        EduCourseCollect collect=new EduCourseCollect();
        collect.setCourseId(courseId);
        collect.setUserId(userId);
        this.baseMapper.insert(collect);
        return ResultData.ok();
    }

    @Override
    public ResultData cancelCollectCollect(String courseId, String userId) {
        QueryWrapper<EduCourseCollect> collectQueryWrapper=new QueryWrapper<>();
        collectQueryWrapper.eq("course_id",courseId);
        collectQueryWrapper.eq("user_id",userId);
        baseMapper.delete(collectQueryWrapper);
        return ResultData.ok();
    }
}
