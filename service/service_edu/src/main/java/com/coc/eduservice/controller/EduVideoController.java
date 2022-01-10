package com.coc.eduservice.controller;


import com.coc.commonutils.ResultData;
import com.coc.eduservice.entity.EduChapter;
import com.coc.eduservice.entity.EduVideo;
import com.coc.eduservice.service.EduVideoService;
import com.coc.servicebase.vo.UpdateTitleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 小结视频 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-04-10
 */
@RestController
@RequestMapping("/eduservice/video")
public class EduVideoController {
    @Autowired
    private EduVideoService videoService;

    @GetMapping("add/{chapterId}/{videoTitle}")
    public ResultData addVideo(@PathVariable("chapterId") String chapterId,@PathVariable("videoTitle") String videoTitle)
    {
        return videoService.addVideo(chapterId,videoTitle);
    }
    @GetMapping("delete/{videoId}")
    public ResultData removeVideo(@PathVariable("videoId") String videoId)
    {
        return videoService.removeVideo(videoId);
    }

    @GetMapping("get_title/{videoId}")
    public ResultData getVideoTitleById(@PathVariable("videoId") String videoId)
    {
        return ResultData.ok().data("resultTitle",videoService.getById(videoId).getVideoTitle());
    }
    @PostMapping("update")
    public ResultData updateVideoById(@RequestBody UpdateTitleVo titleVo)
    {
        EduVideo video=new EduVideo();
        video.setVideoId(titleVo.getId());
        video.setVideoTitle(titleVo.getTitle());
        videoService.updateById(video);
        return ResultData.ok();
    }
    @GetMapping("updateSource/{videoId}/{sourceId}")
    public ResultData updateVideoSource(@PathVariable("videoId") String videoId,@PathVariable("sourceId") String sourceId){
        return videoService.updateVideoSource(videoId,sourceId);
    }

    //教师端获取auth可以直接观看
    @GetMapping("get_auth/{videoId}")
    public ResultData getVideoAuthById(@PathVariable("videoId") String videoId)
    {
        return videoService.getAuth(videoId);
    }
    //check过后判断是否能获取凭证
    @GetMapping("check_auth/{userId}/{videoId}")
    public ResultData getVideoAuthByIdAfterCheck(@PathVariable("userId") String userId,@PathVariable("videoId") String videoId)
    {
        return videoService.getAuthByCheck(userId,videoId);
    }
    @GetMapping("updateIsFree/{videoId}/{isFree}")
    public ResultData updateVideoIsFree(@PathVariable("videoId") String videoId,@PathVariable("isFree") Boolean isFree)
    {
        return videoService.updateIsFree(videoId,isFree);
    }
}

