package com.coc.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coc.commonutils.ResultData;
import com.coc.eduservice.entity.EduSubject;
import com.coc.eduservice.mapper.EduSubjectMapper;
import com.coc.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-04-10
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {
    @Autowired
    private EduSubjectMapper subjectMapper;

    @Override
    public ResultData getSubjectsByParentId(String parentId) {
        QueryWrapper<EduSubject> wrapper=new QueryWrapper<>();
        wrapper.eq("parent_id",parentId);
        List<EduSubject> eduSubjects = this.baseMapper.selectList(wrapper);
        return ResultData.ok().data("subjects",eduSubjects);
    }

}
