package com.coc.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coc.commonutils.ResultData;
import com.coc.eduservice.entity.EduCourseStatus;
import com.coc.eduservice.mapper.EduCourseStatusMapper;
import com.coc.eduservice.service.EduCourseStatusService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程状态 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-04-10
 */
@Service
public class EduCourseStatusServiceImpl extends ServiceImpl<EduCourseStatusMapper, EduCourseStatus> implements EduCourseStatusService {

    @Autowired
    private EduCourseStatusMapper statusMapper;

    @Override
    public ResultData getAllStatus() {
        QueryWrapper<EduCourseStatus> queryWrapper=new QueryWrapper<>();
        queryWrapper.select("status_id as statusId","status_name as statusName");

        return ResultData.ok().data("statusList",statusMapper.selectMaps(queryWrapper));
    }
}
