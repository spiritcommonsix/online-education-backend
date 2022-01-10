package com.coc.servicebase.vo;

import lombok.Data;

import java.util.List;

@Data
public class AddCourseVo {
    /*
    *           userId: '',
                courseTitle: '',
                subjectId: '',
                courseDescription: '',
                courseNum: 0,
                coursePrice: 0,
                courseCover: 'https://cyx-avatar-cloud.oss-cn-shanghai.aliyuncs.com/2021/03/13/a16bb49ec53b4226a22fea8db7d680bc1.jpg',
                chapter: [{
                    title: '章节1', videos: [{ title: '小结1' }]
                }]
    * */
    private String userId;
    private String courseTitle;
    private String courseDescription;
    private String subjectId;
    private String courseCover;
    private List<ChapterVo> chapter;
}
