package com.coc.demo;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.coc.commonutils.ResultData;
import com.coc.eduservice.EduApplication;
import com.coc.eduservice.entity.*;
import com.coc.eduservice.mapper.EduCourseCommentMapper;
import com.coc.eduservice.mapper.EduCourseMapper;
import com.coc.eduservice.mapper.EduVideoMapper;
import com.coc.eduservice.mapper.StudyOrganizationMapper;
import com.coc.eduservice.service.*;
import com.coc.servicebase.vo.InputOrganizationVo;
import com.coc.servicebase.vo.TeacherCourseQuery;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.bouncycastle.crypto.tls.MACAlgorithm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EduApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CourseTest {
    @Autowired
    private EduSubjectService subjectService;

    @Autowired
    private EduCourseMapper courseMapper;

    @Autowired
    private EduCourseService courseService;

    public void addSubject(){
        List<EduSubject> list=new ArrayList<>();

        //经济学
        String parentId="1381480414832553986";
        String subjectTitle[]={
                "西方经济学",
                "世界经济",
                "国民经济学",
                "财政学",
                "金融学",
                "工业经济",
                "农业经济",
                "商业经济",
                "国际贸易"
        };
        for(String title : subjectTitle)
            list.add(new EduSubject(title,parentId));

        //历史学
        list.add(new EduSubject("中国历史","1381480416858402818"));
        list.add(new EduSubject("西方历史","1381480416858402818"));

        //法学
        list.add(new EduSubject("理论法学","1381480415604305921"));
        list.add(new EduSubject("应用法学","1381480415604305921"));
        list.add(new EduSubject("比较法学","1381480415604305921"));

        //哲学
        list.add(new EduSubject("哲学理论","1381480413955944450"));
        list.add(new EduSubject("哲学时间","1381480413955944450"));

        //理学
        list.add(new EduSubject("物理学","1381480417265250305"));
        list.add(new EduSubject("化学","1381480417265250305"));
        list.add(new EduSubject("生物学","1381480417265250305"));
        list.add(new EduSubject("数学","1381480417265250305"));

        //管理学 人力资源管理、财务管理、企业文化
        list.add(new EduSubject("人力资源管理","1381480418087333890"));
        list.add(new EduSubject("财务管理","1381480418087333890"));
        list.add(new EduSubject("企业文化","1381480418087333890"));



        subjectService.saveBatch(list);
    }


    public void testNewXml(){
/*        HashMap<String,Object> map=new HashMap<>();
        map.put("userId","1388398933008531457");
        List<String> list=new ArrayList<>();
        list.add("1390965203495047169");
        list.add("1390965386236678145");
        map.put("courseIds",list);
        List<HashMap<String, Object>> courseInfoByTeacher = courseMapper.getCourseInfoByTeacher(map);
        TeacherCourseQuery query=new TeacherCourseQuery();
        query.setCourseName("前端");
        ResultData listByUserId = courseService.getListByUserId("1388398933008531457", 1, 10, query);
        System.out.println(listByUserId);*/
        HashMap<String,Object> map=new HashMap<>();
//        map.put("keyWord","J");
        List<HashMap<String, Object>> courseInfoByStudent = courseMapper.getCourseInfoByStudent(map);
        System.out.println(courseInfoByStudent);
    }

    @Test
    public void inspectTest(){
        List<HashMap<String, Object>> inspectList = courseMapper.getInspectList();
        System.out.println(inspectList);
    }

    @Autowired
    private EduVideoMapper videoMapper;



    @Autowired
    private EduChapterService chapterService;

    @Test
    public void testQuery(){
        Integer integer = videoMapper.canGetAuth("1391916803235627010", "1381468375103873026");
        System.out.println(integer);
    }

    @Autowired
    private EduCourseCommentMapper commentMapper;
    @Test
    public void addComment(){
        List<Map<String, Object>> bannerComments = commentMapper.getBannerComments("1391916797271326722");
        System.out.println(bannerComments);
    }
    @Autowired
    private StudyOrganizationMapper organizationMapper;
    @Test
    public void group(){
        List<Map<String, Object>> list = organizationMapper.getBannerList("");
        System.out.println(list);
    }


}
