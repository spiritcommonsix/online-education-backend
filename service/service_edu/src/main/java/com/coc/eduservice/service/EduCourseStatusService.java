package com.coc.eduservice.service;

import com.coc.commonutils.ResultData;
import com.coc.eduservice.entity.EduCourseStatus;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程状态 服务类
 * </p>
 *
 * @author testjava
 * @since 2021-04-10
 */
public interface EduCourseStatusService extends IService<EduCourseStatus> {

    ResultData getAllStatus();
}
