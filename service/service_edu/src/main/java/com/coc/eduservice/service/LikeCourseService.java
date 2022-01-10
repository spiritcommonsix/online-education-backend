package com.coc.eduservice.service;

import com.coc.commonutils.ResultData;
import com.coc.eduservice.entity.LikeCourse;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 点赞 服务类
 * </p>
 *
 * @author cyx
 * @since 2021-04-23
 */
public interface LikeCourseService extends IService<LikeCourse> {

    ResultData likeCourse(String courseId, String userId);

    ResultData unlikeCourse(String courseId, String userId);
}
