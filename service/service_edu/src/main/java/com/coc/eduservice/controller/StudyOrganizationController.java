package com.coc.eduservice.controller;


import com.coc.commonutils.ResultData;
import com.coc.eduservice.entity.StudyOrganization;
import com.coc.eduservice.service.StudyOrganizationService;
import com.coc.servicebase.vo.InputOrganizationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 讨论小组 前端控制器
 * </p>
 *
 * @author cyx
 * @since 2021-04-29
 */
@RestController
@RequestMapping("/eduservice/study_organization")
public class StudyOrganizationController {

    @Autowired
    StudyOrganizationService organizationService;

    @GetMapping("addOrg/{userId}/{orgName}")
    public ResultData addOrganization(@PathVariable("userId") String userId,@PathVariable("orgName")String orgName){
        return organizationService.createOrganization(new InputOrganizationVo(orgName,userId));
    }

    @GetMapping("getOrganizationsByTeacher/{userId}/{current}/{pageSize}")
    public ResultData getOrganizationsByTeacher(@PathVariable("userId") String userId,@PathVariable("current") int current,@PathVariable("pageSize") int pageSize){
        return organizationService.getListByTeacher(userId,current,pageSize);
    }
    @GetMapping("getBannerOrgList/{current}/{pageSize}/{keyWord}")
    public ResultData getBannerOrgList(@PathVariable("current") int current,@PathVariable("pageSize") int pageSize,@PathVariable("keyWord")String keyWord){
        return organizationService.getBannerList(current,pageSize,keyWord);
    }
    @GetMapping("getMemberList/{orgId}")
    public ResultData getMemberListByOrgId(@PathVariable("orgId") String orgId){
        return organizationService.getMmberList(orgId);
    }
}

