package com.coc.member.mapper;

import com.coc.member.entity.SysRoleTable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cyx
 * @since 2021-04-12
 */
public interface SysRoleTableMapper extends BaseMapper<SysRoleTable> {
    List<SysRoleTable> getRoleListByUserId(String userId);
}
