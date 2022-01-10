package com.coc.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coc.commonutils.ResultData;
import com.coc.eduservice.client.AliClient;
import com.coc.eduservice.entity.EduVideo;
import com.coc.eduservice.mapper.EduVideoMapper;
import com.coc.eduservice.service.EduVideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 小结视频 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-04-10
 */
@Service
public class EduVideoServiceImpl extends ServiceImpl<EduVideoMapper, EduVideo> implements EduVideoService {

    @Autowired
    private AliClient aliClient;
    @Override
    public ResultData addVideo(String chapterId, String videoTitle) {
        EduVideo video=new EduVideo();
        video.setVideoTitle(videoTitle);
        video.setChapterId(chapterId);
        this.save(video);
        return ResultData.ok();
    }

    @Override
    public ResultData removeVideo(String videoId) {
        EduVideo video = baseMapper.selectById(videoId);

        if(!video.getVideoSource().equals(EduVideo.DEFAULT_SOURCE))
            aliClient.deleteVideoById(video.getVideoSource());
        baseMapper.deleteById(video.getVideoId());
        return ResultData.ok();
    }

    @Override
    public ResultData updateVideoSource(String videoId, String source) {
        //先根据id查出原有的source
        QueryWrapper<EduVideo> queryWrapper=new QueryWrapper<>();
        EduVideo originVideo = baseMapper.selectById(videoId);
        if(!originVideo.getVideoSource().equals(EduVideo.DEFAULT_SOURCE))
            aliClient.deleteVideoById(originVideo.getVideoSource());
        EduVideo newVideo=new EduVideo();
        newVideo.setVideoId(videoId);
        newVideo.setVideoSource(source);

        baseMapper.updateById(newVideo);
        return ResultData.ok();
    }

    @Override
    public ResultData getAuth(String videoId) {

        EduVideo video = baseMapper.selectById(videoId);
        ResultData playAuthByVideoId = aliClient.getPlayAuthByVideoId(video.getVideoSource());
        return playAuthByVideoId.data("vid",video.getVideoSource());
    }

    @Override
    public ResultData getAuthByCheck(String userId, String videoId) {
        Integer integer = baseMapper.canGetAuth(videoId, userId);
        if(integer!=1)
            return ResultData.error().message("没有观看权限，购买课程即可观看");
        return getAuth(videoId);
    }

    @Override
    public ResultData updateIsFree(String videoId, Boolean isFree) {
        EduVideo video=new EduVideo();
        video.setIsFree(isFree);
        video.setVideoId(videoId);
        baseMapper.updateById(video);
        return ResultData.ok();
    }
}
