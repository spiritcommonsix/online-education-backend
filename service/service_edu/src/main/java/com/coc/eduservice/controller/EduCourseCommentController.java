package com.coc.eduservice.controller;


import com.coc.commonutils.ResultData;
import com.coc.eduservice.service.EduCourseCommentService;
import com.coc.servicebase.vo.AddCommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 评论 前端控制器
 * </p>
 *
 * @author cyx
 * @since 2021-04-26
 */
@RestController
@RequestMapping("/eduservice/comment")
public class EduCourseCommentController {
    @Autowired
    private EduCourseCommentService commentService;

    @PostMapping("add")
    public ResultData addNewComment(@RequestBody AddCommentVo vo){
        return commentService.createComment(vo);
    }
}

