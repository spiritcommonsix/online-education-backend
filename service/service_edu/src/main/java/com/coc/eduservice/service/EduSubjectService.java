package com.coc.eduservice.service;

import com.coc.commonutils.ResultData;
import com.coc.eduservice.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author testjava
 * @since 2021-04-10
 */
public interface EduSubjectService extends IService<EduSubject> {

    ResultData getSubjectsByParentId(String parentId);

}
