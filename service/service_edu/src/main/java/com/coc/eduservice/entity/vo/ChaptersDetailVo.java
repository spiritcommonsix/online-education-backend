package com.coc.eduservice.entity.vo;

import com.coc.eduservice.entity.EduChapter;
import com.coc.eduservice.entity.EduVideo;
import lombok.Data;

import java.util.List;

@Data
public class ChaptersDetailVo extends EduChapter {
    private List<EduVideo> videos;
}
