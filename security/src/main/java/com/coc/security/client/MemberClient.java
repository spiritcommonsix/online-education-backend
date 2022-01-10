package com.coc.security.client;


import com.coc.commonutils.ResultData;
import com.coc.member.entity.vo.RegisterVo;
import com.coc.servicebase.vo.ResolveApplyVo;
import com.coc.servicebase.vo.UpdatePwdVo;
import com.coc.servicebase.vo.UpdateUserInfoVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "service-member") //调用的服务名称
@Component
public interface MemberClient {
    @GetMapping("/member/members/getInfo/{userName}")
    public ResultData getUserInfoByUserName(@PathVariable("userName") String userName);

    @PostMapping("/member/members/register")
    public ResultData register(@RequestBody RegisterVo vo);

    @PostMapping("/member/members/updateUserInfo")
    public ResultData updateUserInfo(@RequestBody UpdateUserInfoVo updateUserInfoVo);

    @GetMapping("/member/members/fill/{userId}/{code}")
    public ResultData fillAccount(@PathVariable("userId") String userId,@PathVariable("code") String code);

    @GetMapping("/member/members/get_account/{userId}")
    public ResultData getAccount(@PathVariable("userId") String userId);

    @GetMapping("/member/members/get_roles/{userId}")
    public ResultData getRolesInfoById(@PathVariable("userId") String userId);

    @GetMapping("/member/members/getAllRoles")
    public ResultData getAllRoles();

    @GetMapping("/member/members/submit_apply/{userId}/{roleId}")
    public ResultData submitApply(@PathVariable("userId") String userId,@PathVariable("roleId") String roleId);

    @GetMapping("/member/getrole/getApplyList")
    public ResultData getApplyList();

    @PostMapping("/member/getrole/resolve")
    public ResultData resolveApply(@RequestBody ResolveApplyVo resolveApplyVo);

    @GetMapping("/member/getrole/getHistory/{userId}")
    public ResultData getHistoryApply(@PathVariable("userId") String userId);

    @PostMapping("/member/members/updatePwd")
    public ResultData updatePwd(@RequestBody UpdatePwdVo updatePwdVo);

    @GetMapping("/member/members/buy_course/{userId}/{courseId}")
    public ResultData buyCourse(@PathVariable("userId") String userId,@PathVariable("courseId") String courseId);
}
