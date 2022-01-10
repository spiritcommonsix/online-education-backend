package com.coc.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coc.commonutils.ResultData;
import com.coc.member.entity.SysRoleTable;
import com.coc.member.mapper.SysRoleTableMapper;
import com.coc.member.service.SysRoleTableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cyx
 * @since 2021-04-12
 */
@Service
public class SysRoleTableServiceImpl extends ServiceImpl<SysRoleTableMapper, SysRoleTable> implements SysRoleTableService {

    @Override
    public ResultData addRoles(SysRoleTable role) {
        QueryWrapper<SysRoleTable> wrapper=new QueryWrapper<>();
        wrapper.eq("role_name",role.getRoleName());
        SysRoleTable sysRoleTable = this.baseMapper.selectOne(wrapper);
        if(sysRoleTable!=null)
            return ResultData.error().message("该类角色已经存在");
        this.baseMapper.insert(role);
        return ResultData.ok().data("role",role).message("插入成功");
    }

    @Override
    public ResultData getRolesInfoById(String userId) {
        List<SysRoleTable> roleListByUserId = baseMapper.getRoleListByUserId(userId);
        return ResultData.ok().data("hasRoles",roleListByUserId);
    }
}
