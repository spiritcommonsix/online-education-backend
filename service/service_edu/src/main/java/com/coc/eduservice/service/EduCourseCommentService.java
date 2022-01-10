package com.coc.eduservice.service;

import com.coc.commonutils.ResultData;
import com.coc.eduservice.entity.EduCourseComment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.coc.servicebase.vo.AddCommentVo;

import javax.xml.transform.Result;

/**
 * <p>
 * 评论 服务类
 * </p>
 *
 * @author cyx
 * @since 2021-04-26
 */
public interface EduCourseCommentService extends IService<EduCourseComment> {
    public ResultData createComment(AddCommentVo addCommentVo);
}
