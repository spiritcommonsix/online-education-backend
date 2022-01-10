package com.coc.eduservice.entity.vo;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class UpdateChapterVideoVo {

    public UpdateChapterVideoVo() {
    }

    public UpdateChapterVideoVo(String id, String title) {
        this.id = id;
        this.title = title;
    }

    private String id;
    private String title;
    private List<Map<String,Object>> videos;
}
