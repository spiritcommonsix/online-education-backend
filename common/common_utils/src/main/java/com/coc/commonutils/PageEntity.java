package com.coc.commonutils;

import com.github.pagehelper.PageInfo;
import lombok.Data;

@Data
public class PageEntity {
    private int pageNum,pageSize,pages;
    private Long total;

    public PageEntity(){}
    public PageEntity(int pageNum, int pageSize, Long total, int pages) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        this.pages = pages;
    }

    public static PageEntity transPage(PageInfo pageInfo)
    {
        return new PageEntity(pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getTotal(),pageInfo.getPages());
    }
}
