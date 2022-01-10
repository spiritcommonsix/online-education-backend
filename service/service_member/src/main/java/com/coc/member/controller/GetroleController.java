package com.coc.member.controller;


import com.coc.commonutils.ResultData;
import com.coc.member.service.GetroleService;
import com.coc.servicebase.vo.ResolveApplyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 申请教师角色 前端控制器
 * </p>
 *
 * @author cyx
 * @since 2021-05-20
 */
@RestController
@RequestMapping("/member/getrole")
public class GetroleController {
    @Autowired
    private GetroleService getroleService;

    @GetMapping("getApplyList")
    public ResultData getApplyList(){
        return getroleService.getApplyList();
    }

    @PostMapping("resolve")
    public ResultData resolveApply(@RequestBody ResolveApplyVo resolveApplyVo){
        return getroleService.resolveApply(resolveApplyVo);
    }
    @GetMapping("getHistory/{userId}")
    public ResultData getHistoryApply(@PathVariable("userId") String userId){
        return getroleService.getHistory(userId);
    }
}

