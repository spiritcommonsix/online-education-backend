package com.coc.member.service.impl;

import com.coc.commonutils.ResultData;
import com.coc.member.entity.Getrole;
import com.coc.member.mapper.GetroleMapper;
import com.coc.member.service.GetroleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coc.servicebase.vo.ResolveApplyVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 申请教师角色 服务实现类
 * </p>
 *
 * @author cyx
 * @since 2021-05-20
 */
@Service
public class GetroleServiceImpl extends ServiceImpl<GetroleMapper, Getrole> implements GetroleService {

    @Override
    public ResultData getApplyList() {
        List<Map<String, Object>> applyList = this.baseMapper.getApplyList();
        return ResultData.ok().data("applyList",applyList);
    }

    @Override
    public ResultData resolveApply(ResolveApplyVo resolveApplyVo) {
        Getrole getrole=new Getrole();
        getrole.setId(resolveApplyVo.getId());
        getrole.setAdminId(resolveApplyVo.getAdminId());
        getrole.setIsPass(resolveApplyVo.getIsPass());
        baseMapper.updateById(getrole);
        return ResultData.ok();
    }

    @Override
    public ResultData getHistory(String userId) {
        List<Map<String, Object>> maps = baseMapper.historyApply(userId);
        return ResultData.ok().data("historyApplies",maps);
    }
}
