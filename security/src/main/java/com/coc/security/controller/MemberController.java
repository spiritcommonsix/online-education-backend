package com.coc.security.controller;

import com.coc.commonutils.ResultData;

import com.coc.member.entity.vo.RegisterVo;
import com.coc.security.client.AliClient;
import com.coc.security.client.MemberClient;
import com.coc.servicebase.vo.UpdatePwdVo;
import com.coc.servicebase.vo.UpdateUserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class MemberController {

    @Autowired
    private MemberClient memberClient;

    @Autowired
    private AliClient aliClient;

    @GetMapping("getInfo/{userName}")
    public ResultData getUserInfo(@PathVariable("userName") String userName)
    {
        return memberClient.getUserInfoByUserName(userName);
    }

    @PostMapping("register")
    public ResultData register(@RequestBody RegisterVo vo)
    {
        return memberClient.register(vo);
    }

    @PostMapping("updateInfo")
    public ResultData updateUser(@RequestBody UpdateUserInfoVo updateUserInfoVo)
    {
        return memberClient.updateUserInfo(updateUserInfoVo);
    }
    @PostMapping("uploadAvator/{userId}")
    public ResultData uploadAvator(@PathVariable("userId") String userId,MultipartFile file)
    {
        return aliClient.uploadOssFile(userId,file);
    }
    //充值
    @GetMapping("fill_account/{userId}/{code}")
    public ResultData fillAccount(@PathVariable("userId") String userId,@PathVariable("code") String code)
    {
        return memberClient.fillAccount(userId, code);
    }

    @GetMapping("get_account/{userId}")
    public ResultData getAccount(@PathVariable("userId") String userId)
    {
        return memberClient.getAccount(userId);
    }

    //TODO 获取当前用户所拥有的角色
    @GetMapping("get_roles_list/{userId}")
    public ResultData getRolesByUser(@PathVariable("userId") String userId){
        return memberClient.getRolesInfoById(userId);
    }
    @GetMapping("get_all_role")
    public ResultData getAllRoles(){
        return memberClient.getAllRoles();
    }
    //提交角色申请
    @GetMapping("submit_apply_role/{userId}/{roleId}")
    public ResultData submitApplyRole(@PathVariable("userId") String userId,@PathVariable("roleId") String roleId){
        return memberClient.submitApply(userId, roleId);
    }
    @GetMapping("get_history_apply/{userId}")
    public ResultData getHistoryApplyList(@PathVariable("userId") String userId)
    {
        return memberClient.getHistoryApply(userId);
    }
    @PostMapping("updatePwd")
    public ResultData updatePwd(@RequestBody UpdatePwdVo updatePwdVo){
        return memberClient.updatePwd(updatePwdVo);
    }
}
