package com.coc.member.mapper;

import com.coc.member.entity.Getrole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 申请教师角色 Mapper 接口
 * </p>
 *
 * @author cyx
 * @since 2021-05-20
 */
public interface GetroleMapper extends BaseMapper<Getrole> {
    public List<Map<String,Object>> getApplyList();

    public List<Map<String,Object>> historyApply(String userId);
}
