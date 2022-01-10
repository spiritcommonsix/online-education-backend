package com.coc.member.mapper;

import com.coc.member.entity.Members;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coc.member.entity.SysRoleTable;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author cyx
 * @since 2021-04-11
 */
public interface MembersMapper extends BaseMapper<Members> {
    Map<String, Object> getInfoByName(String userName);
}
