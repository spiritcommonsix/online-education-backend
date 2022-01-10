package com.coc.servicebase.vo;

import lombok.Data;

@Data
public class AddCommentVo {
    private String courseId,userId,commentContent,parentId;
    private Integer sort;
}
