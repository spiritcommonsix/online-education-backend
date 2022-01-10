package com.coc.servicebase.vo;

import lombok.Data;

@Data
public class StudentIndexCourseQuery {
    public StudentIndexCourseQuery() {
    }

    public StudentIndexCourseQuery(String keyWord, String subjectId) {
        this.keyWord = keyWord;
        this.subjectId = subjectId;
    }

    private String keyWord;
    private String subjectId;
}
