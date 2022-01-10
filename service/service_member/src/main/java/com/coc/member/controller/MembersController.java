package com.coc.member.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coc.commonutils.ResultData;
import com.coc.member.MemberApplication;
import com.coc.member.entity.Members;
import com.coc.member.entity.SysRoleTable;
import com.coc.member.entity.SysUserTable;
import com.coc.member.entity.vo.RegisterVo;
import com.coc.member.service.MembersService;
import com.coc.member.service.OrderService;
import com.coc.member.service.SysRoleTableService;
import com.coc.member.service.SysUserTableService;
import com.coc.servicebase.vo.UpdatePwdVo;
import com.coc.servicebase.vo.UpdateUserInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author cyx
 * @since 2021-04-11
 */
@RestController
@RequestMapping("/member/members")
public class MembersController {

    @Autowired
    private SysUserTableService userTableService;

    @Autowired
    private MembersService membersService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private SysRoleTableService roleTableService;

    //注册
    @PostMapping("register")
    public ResultData register(@RequestBody RegisterVo vo)
    {
       return userTableService.register(vo);
    }

    //获取用户信息
    @GetMapping("getInfo/{userName}")
    public ResultData getUserInfoByUserName(@PathVariable String userName)
    {
        Map<String,Object> result=membersService.getUserInfoByUserName(userName);
        return ResultData.ok().data("result",result);
    }

    @PostMapping("updateUserInfo")
    public ResultData updateUserInfo(@RequestBody UpdateUserInfoVo updateUserInfoVo)
    {
        return membersService.updateUserInfo(updateUserInfoVo);
    }

    @GetMapping("get_account/{userId}")
    public ResultData getAccount(@PathVariable("userId") String userId)
    {
        return membersService.getAccountByUserId(userId);
    }

    //充值
    @GetMapping("fill/{userId}/{code}")
    public ResultData fillAccount(@PathVariable("userId") String userId,@PathVariable("code") String code){
        return membersService.fillAccount(userId,code);
    }

    @GetMapping("buy_course/{userId}/{courseId}")
    public ResultData buyCourse(@PathVariable("userId") String userId,@PathVariable("courseId") String courseId){
        return orderService.buyCourse(userId, courseId);
    }
    @GetMapping("get_roles/{userId}")
    public ResultData getRolesInfoById(@PathVariable("userId") String userId){
        return roleTableService.getRolesInfoById(userId);
    }
    @GetMapping("getAllRoles")
    public ResultData getAllRoles(){
        QueryWrapper<SysRoleTable> roleTableQueryWrapper=new QueryWrapper<>();
        roleTableQueryWrapper.ne("role_id","1381432143040860161");
        return ResultData.ok().data("roleList",roleTableService.list(roleTableQueryWrapper));
    }
    @GetMapping("submit_apply/{userId}/{roleId}")
    public ResultData submitApply(@PathVariable("userId") String userId,@PathVariable("roleId") String roleId){
        return membersService.submitApply(userId,roleId);
    }
    @PostMapping("updatePwd")
    public ResultData updatePwd(@RequestBody UpdatePwdVo updatePwdVo){
        return userTableService.updatePwd(updatePwdVo);
    }
}

