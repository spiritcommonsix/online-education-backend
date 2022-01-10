package com.coc.member.service;

import com.coc.commonutils.ResultData;
import com.coc.member.entity.SysRoleTable;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cyx
 * @since 2021-04-12
 */
public interface SysRoleTableService extends IService<SysRoleTable> {

    ResultData addRoles(SysRoleTable role);

    ResultData getRolesInfoById(String userId);
}
