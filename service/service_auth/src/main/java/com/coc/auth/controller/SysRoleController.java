package com.coc.auth.controller;


import com.coc.auth.entity.SysRole;
import com.coc.auth.service.SysRoleService;
import com.coc.commonutils.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author cyx
 * @since 2021-04-11
 */
@RestController
@RequestMapping("/auth/sys-role")
public class SysRoleController {
    @Autowired
    private SysRoleService service;

    @PostMapping("add_role")
    public ResultData addRole(@RequestBody SysRole role)
    {
        boolean saveFlag = service.save(role);
        return saveFlag?ResultData.ok():ResultData.error();
    }
}

