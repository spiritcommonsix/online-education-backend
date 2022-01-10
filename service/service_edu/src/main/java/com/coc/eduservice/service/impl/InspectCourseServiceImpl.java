package com.coc.eduservice.service.impl;

import com.coc.commonutils.ResultData;
import com.coc.eduservice.entity.EduCourse;
import com.coc.eduservice.entity.InspectCourse;
import com.coc.eduservice.mapper.EduCourseMapper;
import com.coc.eduservice.mapper.InspectCourseMapper;
import com.coc.eduservice.service.InspectCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员审核课程 服务实现类
 * </p>
 *
 * @author cyx
 * @since 2021-05-19
 */
@Service
public class InspectCourseServiceImpl extends ServiceImpl<InspectCourseMapper, InspectCourse> implements InspectCourseService {
    @Autowired
    private EduCourseMapper courseMapper;

    @Override
    public ResultData createInspect(String adminId, String courseId,String statusId,float price) {
        InspectCourse inspectCourse=new InspectCourse();
        inspectCourse.setAdminId(adminId);
        inspectCourse.setCourseId(courseId);
        inspectCourse.setStatusId(statusId);

        EduCourse course=new EduCourse();
        course.setCourseId(courseId);
        course.setCoursePrice(price);
        courseMapper.updateById(course);

        baseMapper.insert(inspectCourse);

        return ResultData.ok();
    }
}
