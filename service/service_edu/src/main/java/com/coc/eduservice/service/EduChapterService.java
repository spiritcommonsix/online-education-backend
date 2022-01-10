package com.coc.eduservice.service;

import com.coc.commonutils.ResultData;
import com.coc.eduservice.entity.EduChapter;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程章节 服务类
 * </p>
 *
 * @author testjava
 * @since 2021-04-10
 */
public interface EduChapterService extends IService<EduChapter> {
    public ResultData addChapter(String courseId,String title);

    ResultData removeChapterById(String chapterId);
}
