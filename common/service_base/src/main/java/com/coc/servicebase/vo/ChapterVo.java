package com.coc.servicebase.vo;

import lombok.Data;

import java.util.List;

@Data
public class ChapterVo {
    private String title;
    private List<VideoVo> videos;
}
