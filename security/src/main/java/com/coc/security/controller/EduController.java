package com.coc.security.controller;

import com.coc.commonutils.ResultData;
import com.coc.security.client.EduClient;
import com.coc.security.client.MemberClient;
import com.coc.servicebase.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/edu")
public class EduController {
    @Autowired
    EduClient eduClient;

    @Autowired
    MemberClient memberClient;

    //前端权限验证（每到一个页面就访问一次该接口，根据返回结果判断是否合法）
    @GetMapping("teacher/check")
    public ResultData teacherCheck(){
        return ResultData.ok().message("权限验证通过，可以访问该页面");
    }
    @GetMapping("student/check")
    public ResultData studentCheck(){
        return ResultData.ok().message("权限验证通过，可以访问该页面");
    }

    @PostMapping("teacher/add_course")
    public ResultData testAdd(@RequestBody AddCourseVo vo)
    {
        return eduClient.addCourse(vo);
    }


    //教师访问接口获取自己发布的课程列表
    @PostMapping("teacher/get_owing_course/{userId}/{current}/{pageSize}")
    public ResultData getOwingCourseByUserId(@PathVariable("userId") String userId, @PathVariable("current") int current, @PathVariable("pageSize") int pageSize, @RequestBody TeacherCourseQuery query)
    {
        return eduClient.getCourseListByUserId(userId,current,pageSize,query);
    }

    //获取所有的科目
    @GetMapping("teacher/getOneSubjects/{parentId}")
    public ResultData getOneSubject(@PathVariable("parentId") String parentId)
    {
        return eduClient.getAllOneSubject(parentId);
    }

    @GetMapping("teacher/get_status_list")
    public ResultData getStatusList(){return eduClient.getAllStatus();}

    @GetMapping("teacher/get_course_detail/{courseId}")
    public ResultData getCourseDetail(@PathVariable("courseId") String courseId)
    {
        return eduClient.getUpdateChaptersList(courseId);
    }

    @GetMapping("teacher/add_chapter/{courseId}/{title}")
    public ResultData addChapterByTeacher(@PathVariable("courseId") String courseId,@PathVariable("title") String title){
        return eduClient.addChapter(courseId,title);
    }
    @GetMapping("teacher/add_video/{chapterId}/{videoTitle}")
    public ResultData addVideoByTeacher(@PathVariable("chapterId") String chapterId,@PathVariable("videoTitle") String videoTitle){
        return eduClient.addVideo(chapterId,videoTitle);
    }
    @GetMapping("teacher/remove_chapter/{chapterId}")
    public ResultData removeChapterById(@PathVariable("chapterId") String chapterId)
    {
        return eduClient.removeChapter(chapterId);
    }
    @GetMapping("teacher/remove_video/{videoId}")
    public ResultData removeVideoById(@PathVariable("videoId") String videoId)
    {
        return eduClient.removeVideo(videoId);
    }

    @GetMapping("teacher/chapter/get_title/{chapterId}")
    public ResultData getChapterTitleById(@PathVariable("chapterId") String chapterId)
    {
        return eduClient.getChapterTitleById(chapterId);
    }

    @PostMapping("teacher/chapter/update")
    public ResultData updateChapterById(@RequestBody UpdateTitleVo titleVo)
    {
        return eduClient.updateChapterById(titleVo);
    }

    @GetMapping("teacher/video/get_title/{videoId}")
    public ResultData getVideoTitleById(@PathVariable("videoId") String videoId)
    {
        return eduClient.getVideoTitleById(videoId);
    }

    @PostMapping("teacher/video/update")
    public ResultData updateVideoById(@RequestBody UpdateTitleVo titleVo)
    {
        return eduClient.updateVideoById(titleVo);
    }

    //创建讨论组
    @GetMapping("teacher/createOrg/addOrg/{userId}/{orgName}")
    public ResultData createOrganization(@PathVariable("userId") String userId,@PathVariable("orgName")String orgName)
    {
        return eduClient.addOrganization(userId,orgName);
    }

    //更新上传的视频
    @GetMapping("teacher/video/updateSource/{videoId}/{sourceId}")
    public ResultData updateVideoSource(@PathVariable("videoId") String videoId,@PathVariable("sourceId") String sourceId)
    {
        return eduClient.updateVideoSource(videoId,sourceId);
    }

    //TODO 教师获取凭证的视频接口
    @GetMapping("teacher/video/get_auth/{videoId}")
    public ResultData getVideoAuthByTeacher(@PathVariable("videoId") String videoId)
    {
        return eduClient.getVideoAuthById(videoId);
    }
    @GetMapping("teacher/course/update_status/{courseId}/{statusId}")
    public ResultData updateCourseStatusByTeacher(@PathVariable("courseId") String courseId,@PathVariable("statusId") String statusId)
    {
        return eduClient.submitInspect(courseId, statusId);
    }

    @GetMapping("teacher/course/remove/{courseId}")
    public ResultData removeCourse(@PathVariable("courseId") String courseId)
    {
        return eduClient.removeCourseById(courseId);
    }
    @GetMapping("teacher/organization/getList/{userId}/{current}/{pageSize}")
    public ResultData getOrganizationByTeacher(@PathVariable("userId") String userId,@PathVariable("current") int current,@PathVariable("pageSize") int pageSize){
        return eduClient.getOrganizationsByTeacher(userId, current, pageSize);
    }
    @GetMapping("/teacher/project/getListByOrg/{orgId}")
    public ResultData teacherGetProjectsByOrgId(@PathVariable("orgId") String orgId){
        return eduClient.getProjectsByOrgId(orgId);
    }
    @PostMapping("/teacher/project/create")
    public ResultData createNewProjectByTeacher(@RequestBody CreateProjectVo projectVo){
        return eduClient.createNewProjectByTeacher(projectVo);
    }
    @GetMapping("/teacher/project/delete/{proId}")
    public ResultData deleteByProId(@PathVariable("proId")String proId){
        return eduClient.deleteByProId(proId);
    }
    @GetMapping("/teacher/group/getMemberList/{orgId}")
    public ResultData getMemberListByOrgId(@PathVariable("orgId") String orgId){
        return eduClient.getMemberListByOrgId(orgId);
    }
    @GetMapping("/teacher/student_org/delete/{orgId}/{userId}")
    public ResultData deleteMember(@PathVariable("orgId") String orgId,@PathVariable("userId") String userId){
        return eduClient.deleteMember(orgId,userId);
    }


    @GetMapping("student/get_index_subject")
    public ResultData getIndexSubject()
    {
        return eduClient.getAllOneSubject("0");
    }
    @PostMapping("student/getCourseList/{current}/{pageSize}")
    public ResultData getCourseListByStudent(@PathVariable("current") int current,
                                             @PathVariable("pageSize") int pageSize,@RequestBody StudentIndexCourseQuery query){
        //TODO
        return eduClient.getCourseByStudent(current,pageSize,query);
    }

    //TODO 学生端访问视频凭证接口
    @GetMapping("student/video/check_auth/{userId}/{videoId}")
    public ResultData getVideoAuthByIdAfterCheck(@PathVariable("userId") String userId,@PathVariable("videoId") String videoId)
    {
        return eduClient.getVideoAuthByIdAfterCheck(userId,videoId);
    }

    //获取视频课程的详细情况
    @GetMapping("student/course/getCourseDetail/{courseId}/{userId}")
    public ResultData getCourseDetailByStudent(@PathVariable("courseId") String courseId,@PathVariable("userId") String userId){
        return eduClient.getCourseDetailByStudent(courseId,userId);
    }

    @GetMapping("student/course/operate/like/{courseId}/{userId}")
    public ResultData likeCourse(@PathVariable("courseId") String courseId,@PathVariable("userId") String userId){
        return eduClient.likeCourse(courseId,userId);
    }
    @GetMapping("student/course/operate/unlike/{courseId}/{userId}")
    public ResultData unlikeCourse(@PathVariable("courseId") String courseId,@PathVariable("userId") String userId){
        return eduClient.unlikeCourse(courseId,userId);
    }
    @GetMapping("student/course/operate/collect/{courseId}/{userId}")
    public ResultData collectCourse(@PathVariable("courseId") String courseId,@PathVariable("userId") String userId){
        return eduClient.collectCourse(courseId,userId);
    }
    @GetMapping("student/course/operate/cancelCollect/{courseId}/{userId}")
    public ResultData cancelCollect(@PathVariable("courseId") String courseId,@PathVariable("userId") String userId){
        return eduClient.cancelCollect(courseId,userId);
    }
    @PostMapping("student/comment/add")
    public ResultData addNewComment(@RequestBody AddCommentVo vo){
        return eduClient.addNewComment(vo);
    }

    @GetMapping("student/get_collect_list/{userId}/{current}/{pageSize}")
    public ResultData getCollectList(@PathVariable("userId") String userId, @PathVariable("current") int current, @PathVariable("pageSize") int pageSize){
        return eduClient.getCollectByStudent(userId,current,pageSize);
    }
    @GetMapping("student/group/banner/{current}/{pageSize}/{keyWord}")
    public ResultData getBannerGroups(@PathVariable("current") int current,@PathVariable("pageSize") int pageSize,@PathVariable("keyWord") String keyWord){
        return eduClient.getBannerOrgList(current, pageSize, keyWord);
    }
    @PostMapping("student/group/join")
    public ResultData joinInGroup(@RequestBody StudentJoinInOrganizationVo joinInOrganizationVo){
        return eduClient.joinInGroup(joinInOrganizationVo);
    }
    @GetMapping("student/organization/getListByStudent/{userId}/{current}/{pageSize}")
    public ResultData getGroupListByStudent(@PathVariable("userId") String userId,@PathVariable("current") int current,@PathVariable("pageSize") int pageSize){
        return eduClient.getGroupListByStudent(userId,current,pageSize);
    }
    @GetMapping("student/org/detail/{orgId}")
    public ResultData getOrgDetailByStudent(@PathVariable("orgId")String orgId){
        return eduClient.getProjectsByOrgId(orgId);
    }
    @GetMapping("student/buy_course/{userId}/{courseId}")
    public ResultData buyCourse(@PathVariable("userId") String userId,@PathVariable("courseId") String courseId){
        return memberClient.buyCourse(userId,courseId);
    }

    @GetMapping("student/video/get_auth/{videoId}")
    public ResultData getVideoAuthByStudent(@PathVariable("videoId") String videoId){
        return eduClient.getVideoAuthById(videoId);
    }

}
