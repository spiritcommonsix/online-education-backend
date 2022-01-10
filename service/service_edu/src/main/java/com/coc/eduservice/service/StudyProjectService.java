package com.coc.eduservice.service;

import com.coc.commonutils.ResultData;
import com.coc.eduservice.entity.StudyProject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.coc.servicebase.vo.CreateProjectVo;

/**
 * <p>
 * 学习项目 服务类
 * </p>
 *
 * @author cyx
 * @since 2021-04-29
 */
public interface StudyProjectService extends IService<StudyProject> {
    public ResultData createProject(CreateProjectVo projectVo);

    ResultData getListByOrgId(String orgId);
}
