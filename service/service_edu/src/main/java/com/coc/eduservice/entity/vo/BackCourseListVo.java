package com.coc.eduservice.entity.vo;

import com.coc.eduservice.entity.EduCourse;
import lombok.Data;

/*
* 后端教师查看课程的信息显示
* */
@Data
public class BackCourseListVo {
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
    private EduCourse courseInfo;
    private int likeNum,collectNum;

}
