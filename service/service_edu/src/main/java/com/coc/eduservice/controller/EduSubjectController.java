package com.coc.eduservice.controller;


import com.coc.commonutils.ResultData;
import com.coc.eduservice.service.EduSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-04-10
 */
@RestController
@RequestMapping("/eduservice/subject")
public class EduSubjectController {
    @Autowired
    private EduSubjectService subjectService;

    @GetMapping("getSubjectsByParentId/{parentId}")
    public ResultData getAllOneSubject(@PathVariable("parentId") String parentId)
    {
        return subjectService.getSubjectsByParentId(parentId);
    }

}

