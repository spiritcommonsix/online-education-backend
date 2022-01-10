package com.coc.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coc.commonutils.ResultData;
import com.coc.eduservice.entity.StudyOrganization;
import com.coc.eduservice.entity.StudyProject;
import com.coc.eduservice.mapper.StudyOrganizationMapper;
import com.coc.eduservice.mapper.StudyProjectMapper;
import com.coc.eduservice.service.StudyProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coc.servicebase.vo.CreateProjectVo;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 学习项目 服务实现类
 * </p>
 *
 * @author cyx
 * @since 2021-04-29
 */
@Service
public class StudyProjectServiceImpl extends ServiceImpl<StudyProjectMapper, StudyProject> implements StudyProjectService {
    @Autowired
    private StudyOrganizationMapper organizationMapper;

    @Override
    public ResultData createProject(CreateProjectVo projectVo) {
        StudyProject project=new StudyProject();
        BeanUtils.copyProperties(projectVo,project);
        this.save(project);
        return ResultData.ok().message("发布成功");
    }

    @Override
    public ResultData getListByOrgId(String orgId) {
        QueryWrapper<StudyProject> projectQueryWrapper=new QueryWrapper<>();
        projectQueryWrapper.eq("org_id",orgId);


        StudyOrganization organization = organizationMapper.selectById(orgId);

        List<StudyProject> studyProjects = baseMapper.selectList(projectQueryWrapper);
        return ResultData.ok().data("projectList",studyProjects).data("org_name",organization.getOrgName());
    }
}
