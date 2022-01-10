package com.coc.eduservice.controller;


import com.coc.commonutils.ResultData;
import com.coc.eduservice.service.StudyProjectService;
import com.coc.servicebase.vo.CreateProjectVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 学习项目 前端控制器
 * </p>
 *
 * @author cyx
 * @since 2021-04-29
 */
@RestController
@RequestMapping("/eduservice/project")
public class StudyProjectController {
    @Autowired
    private StudyProjectService projectService;

    @GetMapping("getListByOrg/{orgId}")
    public ResultData getProjectsByOrgId(@PathVariable("orgId") String orgId){
        return projectService.getListByOrgId(orgId);
    }
    @PostMapping("create")
    public ResultData createNewProjectByTeacher(@RequestBody CreateProjectVo projectVo){
        return projectService.createProject(projectVo);
    }
    @GetMapping("detete/{proId}")
    public ResultData deleteByProId(@PathVariable("proId")String proId){
        projectService.removeById(proId);
        return ResultData.ok().message("删除成功");
    }
}

