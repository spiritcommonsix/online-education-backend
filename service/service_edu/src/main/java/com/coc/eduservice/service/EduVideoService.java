package com.coc.eduservice.service;

import com.coc.commonutils.ResultData;
import com.coc.eduservice.entity.EduVideo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 小结视频 服务类
 * </p>
 *
 * @author testjava
 * @since 2021-04-10
 */
public interface EduVideoService extends IService<EduVideo> {

    ResultData addVideo(String chapterId, String videoTitle);

    ResultData removeVideo(String videoId);

    ResultData updateVideoSource(String videoId,String source);

    ResultData getAuth(String videoId);

    public ResultData getAuthByCheck(String userId,String videoId);

    ResultData updateIsFree(String videoId, Boolean isFree);
}
