package com.coc.eduservice.service;

import com.coc.commonutils.ResultData;
import com.coc.eduservice.entity.EduCourseCollect;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户收藏课程 服务类
 * </p>
 *
 * @author cyx
 * @since 2021-04-26
 */
public interface EduCourseCollectService extends IService<EduCourseCollect> {

    ResultData addCollect(String courseId, String userId);

    ResultData cancelCollectCollect(String courseId, String userId);
}
