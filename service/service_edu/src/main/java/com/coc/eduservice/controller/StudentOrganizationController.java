package com.coc.eduservice.controller;


import com.coc.commonutils.ResultData;
import com.coc.eduservice.service.StudentOrganizationService;
import com.coc.servicebase.vo.StudentJoinInOrganizationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户-讨论组 前端控制器
 * </p>
 *
 * @author cyx
 * @since 2021-04-29
 */
@RestController
@RequestMapping("/eduservice/student_org")
public class StudentOrganizationController {
    @Autowired
    private StudentOrganizationService studentOrganizationService;

    @GetMapping("getMembersByOrgId/{orgId}")
    public ResultData getMembersByOrgId(@PathVariable("orgId") String orgId){
        return studentOrganizationService.getMembersByOrgId(orgId);
    }
    @PostMapping("join")
    public ResultData joinInGroup(@RequestBody StudentJoinInOrganizationVo joinInOrganizationVo){
        return studentOrganizationService.joinInOrganization(joinInOrganizationVo);
    }
    @GetMapping("delete/{orgId}/{userId}")
    public ResultData deleteMember(@PathVariable("orgId") String orgId,@PathVariable("userId") String userId){
        return studentOrganizationService.removeMember(orgId,userId);
    }
    //学生端获取组列表
    @GetMapping("getListByStudent/{userId}/{current}/{pageSize}")
    public ResultData getGroupListByStudent(@PathVariable("userId") String userId,@PathVariable("current") int current,@PathVariable("pageSize") int pageSize){
        return studentOrganizationService.getListByStudent(userId,current,pageSize);
    }

}

