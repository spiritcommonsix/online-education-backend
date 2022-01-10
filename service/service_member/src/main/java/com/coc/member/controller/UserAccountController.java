package com.coc.member.controller;


import com.coc.commonutils.ResultData;
import com.coc.member.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cyx
 * @since 2021-05-09
 */
@RestController
@RequestMapping("/member/account")
public class UserAccountController {
    @Autowired
    private UserAccountService accountService;

    //TODO 充值功能
}

