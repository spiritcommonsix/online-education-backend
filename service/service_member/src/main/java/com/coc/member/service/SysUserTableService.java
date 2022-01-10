package com.coc.member.service;

import com.coc.commonutils.ResultData;
import com.coc.member.entity.SysUserTable;
import com.baomidou.mybatisplus.extension.service.IService;
import com.coc.member.entity.vo.RegisterVo;
import com.coc.servicebase.vo.UpdatePwdVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cyx
 * @since 2021-04-12
 */
public interface SysUserTableService extends IService<SysUserTable> {

    ResultData register(RegisterVo vo);

    ResultData updatePwd(UpdatePwdVo updatePwdVo);
}
