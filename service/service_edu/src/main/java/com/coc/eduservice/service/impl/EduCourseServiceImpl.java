package com.coc.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.coc.commonutils.PageEntity;
import com.coc.commonutils.ResultData;
import com.coc.eduservice.entity.*;
import com.coc.eduservice.entity.vo.UpdateChapterVideoVo;
import com.coc.eduservice.mapper.*;
import com.coc.eduservice.service.EduChapterService;
import com.coc.eduservice.service.EduCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coc.eduservice.service.EduVideoService;
import com.coc.servicebase.vo.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程列表 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-04-10
 */
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {

    @Autowired
    EduChapterService chapterService;

    @Autowired
    EduVideoService videoService;

    @Autowired
    EduVideoMapper videoMapper;

    @Autowired
    EduCourseMapper courseMapper;

    @Autowired
    EduChapterMapper chapterMapper;

    @Autowired
    private EduCourseCommentMapper commentMapper;

    @Autowired
    private LikeCourseMapper likeCourseMapper;

    @Autowired
    private EduCourseCollectMapper collectMapper;

    @Override
    //添加课程
    public ResultData addCourse(AddCourseVo courseVo) {
        EduCourse course=new EduCourse();
        BeanUtils.copyProperties(courseVo,course);

        //获取所有的章节
        List<ChapterVo> chapterVos = courseVo.getChapter();

        //插入course
        baseMapper.insert(course);

        for(ChapterVo chapterVo : chapterVos)
        {
            EduChapter chapter=new EduChapter();
            chapter.setCourseId(course.getCourseId());
            chapter.setChapterTitle(chapterVo.getTitle());
            chapterService.save(chapter);
            List<VideoVo> videoVos = chapterVo.getVideos();
            //根据每个chapter获取video
            for (VideoVo videoVo : videoVos)
            {
                EduVideo video = new EduVideo();
                video.setChapterId(chapter.getChapterId());
                video.setIsFree(videoVo.getIsFree());
                video.setVideoTitle(videoVo.getTitle());
                videoService.save(video);
            }
        }


        return ResultData.ok().message("插入课程成功");
    }

    @Override
    public ResultData getListByUserId(String userId, int current, int pageSize, TeacherCourseQuery teacherCourseQuery) {

        /*
        * TODO
        *  课程编号
        *  课程名
        *  课时数
        *  价格
        *  点赞数
        *  收藏数
        *   发布时间
        *   当前状态（状态码和状态名）
        *
        * */
        //TODO 根据条件查询
        QueryWrapper<EduCourse> preQuery=new QueryWrapper<>();
        preQuery.select("course_id");
        if(!StringUtils.isEmpty(teacherCourseQuery.getCourseName()))
            preQuery.like("course_title",teacherCourseQuery.getCourseName());
        if(!StringUtils.isEmpty(teacherCourseQuery.getStatusId()))
            preQuery.eq("status_id",teacherCourseQuery.getStatusId());
        if(!StringUtils.isEmpty(teacherCourseQuery.getBegin()))
            preQuery.ge("gmt_create",teacherCourseQuery.getBegin());
        if(!StringUtils.isEmpty(teacherCourseQuery.getEnd()))
            preQuery.le("gmt_create",teacherCourseQuery.getEnd());
        List<Object> preIds = courseMapper.selectObjs(preQuery);

        System.out.println(preIds);
        preIds.add(new EduCourse(""));


        PageHelper.startPage(current,pageSize);
        HashMap<String,Object> query=new HashMap<>();
        query.put("userId",userId);
        query.put("otherQuery",preIds);

        List<HashMap<String, Object>> courseInfoByTeacher = courseMapper.getCourseInfoByTeacher(query);
        PageEntity pageEntity = PageEntity.transPage(new PageInfo(courseInfoByTeacher));

        return ResultData.ok().data("list",courseInfoByTeacher).data("page",pageEntity);
    }

    @Override
    public ResultData selectCourseByStudent(int current,int pageSize,StudentIndexCourseQuery query) {
        //封面，名称，作者，时间
        HashMap<String, Object> queryMap = new HashMap<>();
        if (!StringUtils.isEmpty(query.getKeyWord()))
            queryMap.put("keyWord", query.getKeyWord());

        if (!StringUtils.isEmpty(query.getSubjectId()))
            queryMap.put("subjectId",query.getSubjectId());
        PageHelper.startPage(current,pageSize);
        List<HashMap<String, Object>> courseListByStudent = courseMapper.getCourseInfoByStudent(queryMap);
        PageEntity pageEntity = PageEntity.transPage(new PageInfo(courseListByStudent));
        return ResultData.ok().data("courseList",courseListByStudent).data("page",pageEntity);
    }

    @Override
    public ResultData getInspectList(int current, int pageSize) {
        PageHelper.startPage(current,pageSize);
        List<HashMap<String, Object>> inspectList = courseMapper.getInspectList();
        PageEntity pageEntity = PageEntity.transPage(new PageInfo(inspectList));

        return ResultData.ok().data("inspectList",inspectList).data("page",pageEntity);
    }

    @Override
    public ResultData getCourseDetail(String courseId) {
        //创建最终返回结果
        List<UpdateChapterVideoVo> resultList=new ArrayList<>();
        //根据courseId查出所有的chapter
        QueryWrapper<EduChapter> chapterQueryWrapper=new QueryWrapper<>();
        chapterQueryWrapper.eq("course_id",courseId);
        //查出了所有的chapter
        List<EduChapter> eduChapters = chapterMapper.selectList(chapterQueryWrapper);

        for (EduChapter chapter: eduChapters)
        {
            UpdateChapterVideoVo vo=new UpdateChapterVideoVo(chapter.getChapterId(),chapter.getChapterTitle());
            QueryWrapper<EduVideo> videoQueryWrapper=new QueryWrapper<>();
            videoQueryWrapper.select("video_id as id","video_title as title","video_source as source","is_free");
            videoQueryWrapper.eq("chapter_id",chapter.getChapterId());
            List<Map<String, Object>> maps = videoMapper.selectMaps(videoQueryWrapper);
            vo.setVideos(maps);
            resultList.add(vo);
        }
        EduCourse course = baseMapper.selectById(courseId);
        return ResultData.ok().data("chapters",resultList).data("courseId",course.getCourseId()).data("courseName",course.getCourseTitle()).data("courseCover",course.getCourseCover());
    }

    @Override
    public ResultData updateStatus(String courseId,String statusId) {
        EduCourse course = baseMapper.selectById(courseId);
        if(course.getStatusId().equals("1381482894559543297"))
            return ResultData.error().message("课程已发布，不可修改");
        EduCourse newCourse=new EduCourse();
        newCourse.setCourseId(courseId);
        newCourse.setStatusId(statusId);
        baseMapper.updateById(newCourse);
        return ResultData.ok();
    }

    @Override
    public ResultData removeCourseByTeacher(String courseId) {
        EduCourse course = baseMapper.selectById(courseId);
        if(course.getStatusId().equals("1381482894559543297"))
            return ResultData.error().message("课程已发布，不可删除");

        QueryWrapper<EduChapter> chapterQueryWrapper=new QueryWrapper<>();
        chapterQueryWrapper.eq("course_id",courseId);
        List<EduChapter> eduChapters = chapterMapper.selectList(chapterQueryWrapper);
        for(EduChapter chapter : eduChapters)
            chapterService.removeChapterById(chapter.getChapterId());
        baseMapper.deleteById(courseId);

        return ResultData.ok();
    }

    @Override
    public ResultData getCourseDetailByStudent(String courseId,String userId) {
        //TODO 评论条,发布者,
        Map<String, Object> courseInfo = baseMapper.studentQueryCourseDetailById(courseId);

        //TODO 开始查找所有的评论
        List<Map<String, Object>> bannerComments = commentMapper.getBannerComments(courseId);

        //TODO 判断该用户是否对该课程进行点赞或收藏
        QueryWrapper<LikeCourse> likeCourseQueryWrapper=new QueryWrapper<>();
        likeCourseQueryWrapper.eq("course_id",courseId);
        likeCourseQueryWrapper.eq("user_id",userId);
        LikeCourse likeCourse = likeCourseMapper.selectOne(likeCourseQueryWrapper);

        QueryWrapper<EduCourseCollect> collectQueryWrapper=new QueryWrapper<>();
        collectQueryWrapper.eq("course_id",courseId);
        collectQueryWrapper.eq("user_id",userId);
        EduCourseCollect eduCourseCollect = collectMapper.selectOne(collectQueryWrapper);

        return this.getCourseDetail(courseId)
                .data("courseInfo",courseInfo)
                .data("commentList",bannerComments)
                .data("isCollect",eduCourseCollect!=null)
                .data("isLike",likeCourse!=null)
                ;
    }

    @Override
    public ResultData getCollectCourses(String userId, int current, int pageSize) {
        PageHelper.startPage(current,pageSize);
        List<Map<String, Object>> collectCourse = baseMapper.getCollectCourse(userId);
        PageEntity pageEntity = PageEntity.transPage(new PageInfo(collectCourse));
        return ResultData.ok().data("collectList",collectCourse).data("page",pageEntity);
    }
}