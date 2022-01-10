package com.coc.security.controller;

import com.coc.commonutils.ResultData;
import com.coc.security.client.EduClient;
import com.coc.security.client.MemberClient;
import com.coc.servicebase.vo.ResolveApplyVo;
import com.coc.servicebase.vo.TeacherCourseQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manage")
public class ManagerController {
    @Autowired
    EduClient eduClient;

    @Autowired
    MemberClient memberClient;



    @GetMapping("check")
    public ResultData checkManage(){
        return ResultData.ok().message("权限验证通过，可以访问该页面");
    }

    @GetMapping("get_inspect_list/{current}/{pageSize}")
    public ResultData getInspectList(@PathVariable("current") int current, @PathVariable("pageSize") int pageSize){
        return eduClient.getInspectList(current,pageSize);
    }
    @GetMapping("get_chapters/{courseId}")
    public ResultData getChapterByManager(@PathVariable("courseId") String courseId){
        return eduClient.getUpdateChaptersList(courseId);
    }
    @GetMapping("inspect/updateIsFree/{videoId}/{isFree}")
    public ResultData updateVideoIsFree(@PathVariable("videoId") String videoId,@PathVariable("isFree") Boolean isFree)
    {
        return eduClient.updateVideoIsFree(videoId, isFree);
    }
//    inspect/isPass
    @GetMapping("inspect/isPass/{adminId}/{courseId}/{statusId}/{price}")
    public ResultData inspectIsPass(@PathVariable("adminId")String adminId,@PathVariable("courseId")String courseId,@PathVariable("statusId")String statusId,@PathVariable("price") float price)
    {
        return eduClient.createInspect(adminId, courseId, statusId,price);
    }
    @GetMapping("getrole/get_apply_list")
    public ResultData getApplyList(){
        return memberClient.getApplyList();
    }

    @PostMapping("getrole/resolve")
    public ResultData resolveApply(@RequestBody ResolveApplyVo resolveApplyVo)
    {
        return memberClient.resolveApply(resolveApplyVo);
    }
}
