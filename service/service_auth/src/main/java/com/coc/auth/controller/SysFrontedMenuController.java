package com.coc.auth.controller;


import com.coc.auth.entity.SysFrontedMenu;
import com.coc.auth.service.SysFrontedMenuService;
import com.coc.commonutils.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端页面列表 前端控制器
 * </p>
 *
 * @author cyx
 * @since 2021-04-11
 */
@RestController
@RequestMapping("/auth/sys-fronted-menu")
public class SysFrontedMenuController {
    @Autowired
    private SysFrontedMenuService service;
    @PostMapping("add_front_menu")
    public ResultData addFrontMenu(@RequestBody SysFrontedMenu menu)
    {
        boolean saveFlag = service.save(menu);
        return saveFlag?ResultData.ok():ResultData.error();
    }
}

