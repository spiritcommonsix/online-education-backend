package com.coc.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coc.commonutils.ResultData;
import com.coc.eduservice.entity.EduChapter;
import com.coc.eduservice.entity.EduVideo;
import com.coc.eduservice.mapper.EduChapterMapper;
import com.coc.eduservice.mapper.EduVideoMapper;
import com.coc.eduservice.service.EduChapterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coc.eduservice.service.EduVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程章节 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-04-10
 */
@Service
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter> implements EduChapterService {

    @Autowired
    private EduVideoService videoService;

    @Autowired
    private EduVideoMapper videoMapper;

    @Override
    public ResultData addChapter(String courseId,String title) {
        EduChapter chapter=new EduChapter();
        chapter.setCourseId(courseId);
        chapter.setChapterTitle(title);
        this.save(chapter);
        return ResultData.ok();
    }

    @Override
    public ResultData removeChapterById(String chapterId) {
        //查出对应的小结并删除
        QueryWrapper<EduVideo> videoQueryWrapper=new QueryWrapper<>();
        videoQueryWrapper.select("video_id as id");
        videoQueryWrapper.eq("chapter_id",chapterId);
        List<Map<String, Object>> maps = videoMapper.selectMaps(videoQueryWrapper);
        for(Map<String,Object> map : maps)
            videoService.removeVideo(map.get("id").toString());
        baseMapper.deleteById(chapterId);
        return ResultData.ok();
    }
}
