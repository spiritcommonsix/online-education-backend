package com.coc.eduservice.service.impl;

import com.coc.commonutils.ResultData;
import com.coc.eduservice.entity.EduCourseComment;
import com.coc.eduservice.mapper.EduCourseCommentMapper;
import com.coc.eduservice.service.EduCourseCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coc.servicebase.vo.AddCommentVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论 服务实现类
 * </p>
 *
 * @author cyx
 * @since 2021-04-26
 */
@Service
public class EduCourseCommentServiceImpl extends ServiceImpl<EduCourseCommentMapper, EduCourseComment> implements EduCourseCommentService {

    @Override
    public ResultData createComment(AddCommentVo addCommentVo) {
        EduCourseComment courseComment=new EduCourseComment();
        BeanUtils.copyProperties(addCommentVo,courseComment);
        baseMapper.insert(courseComment);
        return ResultData.ok();
    }
}
