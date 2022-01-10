package com.coc.eduservice.controller;


import com.coc.commonutils.ResultData;
import com.coc.eduservice.client.TestClient;
import com.coc.eduservice.entity.EduChapter;
import com.coc.eduservice.service.EduChapterService;
import com.coc.servicebase.vo.UpdateTitleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程章节 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-04-10
 */
@RestController
@RequestMapping("/eduservice/chapter")
public class EduChapterController {
    @Autowired
    EduChapterService chapterService;

    @GetMapping("add/{courseId}/{title}")
    public ResultData addChapter(@PathVariable("courseId") String courseId,@PathVariable("title") String title)
    {
        return chapterService.addChapter(courseId,title);
    }
    @GetMapping("delete/{chapterId}")
    public ResultData removeChapter(@PathVariable("chapterId") String chapterId)
    {
        return chapterService.removeChapterById(chapterId);
    }
    @GetMapping("get_title/{chapterId}")
    public ResultData getChapterTitleById(@PathVariable("chapterId") String chapterId)
    {
        return ResultData.ok().data("resultTitle",chapterService.getById(chapterId).getChapterTitle());
    }
    @PostMapping("update")
    public ResultData updateChapterById(@RequestBody UpdateTitleVo titleVo)
    {
        EduChapter chapter=new EduChapter();
        chapter.setChapterId(titleVo.getId());
        chapter.setChapterTitle(titleVo.getTitle());
        chapterService.updateById(chapter);
        return ResultData.ok();
    }
}

