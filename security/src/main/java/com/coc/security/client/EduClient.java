package com.coc.security.client;

import com.coc.commonutils.ResultData;
import com.coc.servicebase.vo.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "service-edu") //调用的服务名称
@Component
public interface EduClient {
    @PostMapping("/eduservice/educourse/addCourse")
    public ResultData addCourse(AddCourseVo courseVo);

    @PostMapping("/eduservice/educourse/getCourseList/{userId}/{current}/{pageSize}")
    public ResultData getCourseListByUserId(@PathVariable("userId") String userId, @PathVariable("current") int current, @PathVariable("pageSize") int pageSize, @RequestBody TeacherCourseQuery query);

    @GetMapping("/eduservice/subject/getSubjectsByParentId/{parentId}")
    public ResultData getAllOneSubject(@PathVariable("parentId") String parentId);

    @GetMapping("/eduservice/course_status/getAllStatus")
    public ResultData getAllStatus();

    @GetMapping("/eduservice/study_organization/addOrg/{userId}/{orgName}")
    public ResultData addOrganization(@PathVariable("userId") String userId,@PathVariable("orgName")String orgName);

    @PostMapping("/eduservice/educourse/studnetGetCourse/{current}/{pageSize}")
    public ResultData getCourseByStudent( @PathVariable("current") int current,
                                          @PathVariable("pageSize") int pageSize,@RequestBody StudentIndexCourseQuery query);

    @GetMapping("/eduservice/educourse/getInspectCourse/{current}/{pageSize}")
    public ResultData getInspectList(@PathVariable("current") int current,
                                     @PathVariable("pageSize") int pageSize);

    @GetMapping("/eduservice/educourse/getUpateChaptersList/{courseId}")
    public ResultData getUpdateChaptersList(@PathVariable("courseId") String courseId);

    @GetMapping("/eduservice/chapter/add/{courseId}/{title}")
    public ResultData addChapter(@PathVariable("courseId") String courseId,@PathVariable("title") String title);

    @GetMapping("/eduservice/chapter/delete/{chapterId}")
    public ResultData removeChapter(@PathVariable("chapterId") String chapterId);

    @GetMapping("/eduservice/video/add/{chapterId}/{videoTitle}")
    public ResultData addVideo(@PathVariable("chapterId") String chapterId,@PathVariable("videoTitle") String videoTitle);

    @GetMapping("/eduservice/video/delete/{videoId}")
    public ResultData removeVideo(@PathVariable("videoId") String videoId);
//TODO
    @GetMapping("/eduservice/chapter/get_title/{chapterId}")
    public ResultData getChapterTitleById(@PathVariable("chapterId") String chapterId);

    @PostMapping("/eduservice/chapter/update")
    public ResultData updateChapterById(@RequestBody UpdateTitleVo titleVo);

    @GetMapping("/eduservice/video/get_title/{videoId}")
    public ResultData getVideoTitleById(@PathVariable("videoId") String videoId);

    @PostMapping("/eduservice/video/update")
    public ResultData updateVideoById(@RequestBody UpdateTitleVo titleVo);

    @GetMapping("/eduservice/video/updateSource/{videoId}/{sourceId}")
    public ResultData updateVideoSource(@PathVariable("videoId") String videoId,@PathVariable("sourceId") String sourceId);

    @GetMapping("/eduservice/video/get_auth/{videoId}")
    public ResultData getVideoAuthById(@PathVariable("videoId") String videoId);

    @GetMapping("/eduservice/video/check_auth/{userId}/{videoId}")
    public ResultData getVideoAuthByIdAfterCheck(@PathVariable("userId") String userId,@PathVariable("videoId") String videoId);

    @GetMapping("/eduservice/educourse/update_status/{courseId}/{statusId}")
    public ResultData submitInspect(@PathVariable("courseId") String courseId,@PathVariable("statusId") String statusId);

    @GetMapping("/eduservice/video/updateIsFree/{videoId}/{isFree}")
    public ResultData updateVideoIsFree(@PathVariable("videoId") String videoId,@PathVariable("isFree") Boolean isFree);

    @GetMapping("/eduservice/inspectCourse/create/{adminId}/{courseId}/{statusId}/{price}")
    public ResultData createInspect(@PathVariable("adminId")String adminId,@PathVariable("courseId")String courseId,@PathVariable("statusId")String statusId,@PathVariable("price")float price);

    @GetMapping("/eduservice/educourse/remove/{courseId}")
    public ResultData removeCourseById(@PathVariable("courseId") String courseId);

    @GetMapping("/eduservice/educourse/getCourseDetail/{courseId}/{userId}")
    public ResultData getCourseDetailByStudent(@PathVariable("courseId") String courseId,@PathVariable("userId") String userId);

    @GetMapping("/eduservice/likeCourse/like/{courseId}/{userId}")
    public ResultData likeCourse(@PathVariable("courseId") String courseId, @PathVariable("userId") String userId);

    @GetMapping("/eduservice/likeCourse/unlike/{courseId}/{userId}")
    public ResultData unlikeCourse(@PathVariable("courseId") String courseId, @PathVariable("userId") String userId);

    @GetMapping("/eduservice/courseCollect/collect/{courseId}/{userId}")
    public ResultData collectCourse(@PathVariable("courseId") String courseId, @PathVariable("userId") String userId);

    @GetMapping("/eduservice/courseCollect/cancelCollect/{courseId}/{userId}")
    public ResultData cancelCollect(@PathVariable("courseId") String courseId, @PathVariable("userId") String userId);

    @PostMapping("/eduservice/comment/add")
    public ResultData addNewComment(@RequestBody AddCommentVo vo);

    @GetMapping("/eduservice/educourse/getCollect/{userId}/{current}/{pageSize}")
    public ResultData getCollectByStudent(@PathVariable("userId") String userId,@PathVariable("current") int current, @PathVariable("pageSize") int pageSize);

    @GetMapping("/eduservice/study_organization/getOrganizationsByTeacher/{userId}/{current}/{pageSize}")
    public ResultData getOrganizationsByTeacher(@PathVariable("userId") String userId,@PathVariable("current") int current,@PathVariable("pageSize") int pageSize);

    @GetMapping("/eduservice/study_organization/getBannerOrgList/{current}/{pageSize}/{keyWord}")
    public ResultData getBannerOrgList(@PathVariable("current") int current,@PathVariable("pageSize") int pageSize,@PathVariable("keyWord")String keyWord);

    @PostMapping("/eduservice/student_org/join")
    public ResultData joinInGroup(@RequestBody StudentJoinInOrganizationVo joinInOrganizationVo);

    @GetMapping("/eduservice/project/getListByOrg/{orgId}")
    public ResultData getProjectsByOrgId(@PathVariable("orgId") String orgId);

    @PostMapping("/eduservice/project/create")
    public ResultData createNewProjectByTeacher(@RequestBody CreateProjectVo projectVo);

    @GetMapping("/eduservice/project/detete/{proId}")
    public ResultData deleteByProId(@PathVariable("proId")String proId);

    @GetMapping("/eduservice/study_organization/getMemberList/{orgId}")
    public ResultData getMemberListByOrgId(@PathVariable("orgId") String orgId);

    @GetMapping("/eduservice/student_org/delete/{orgId}/{userId}")
    public ResultData deleteMember(@PathVariable("orgId") String orgId,@PathVariable("userId") String userId);

    @GetMapping("/eduservice/student_org/getListByStudent/{userId}/{current}/{pageSize}")
    public ResultData getGroupListByStudent(@PathVariable("userId") String userId,@PathVariable("current") int current,@PathVariable("pageSize") int pageSize);
}
