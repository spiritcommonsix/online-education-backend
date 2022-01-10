package com.coc.eduservice.service;

import com.coc.commonutils.ResultData;
import com.coc.eduservice.entity.InspectCourse;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 管理员审核课程 服务类
 * </p>
 *
 * @author cyx
 * @since 2021-05-19
 */
public interface InspectCourseService extends IService<InspectCourse> {

    ResultData createInspect(String adminId, String courseId,String statusId,float price);
}
