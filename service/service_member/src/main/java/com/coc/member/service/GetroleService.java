package com.coc.member.service;

import com.coc.commonutils.ResultData;
import com.coc.member.entity.Getrole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.coc.servicebase.vo.ResolveApplyVo;

/**
 * <p>
 * 申请教师角色 服务类
 * </p>
 *
 * @author cyx
 * @since 2021-05-20
 */
public interface GetroleService extends IService<Getrole> {

    ResultData getApplyList();

    ResultData resolveApply(ResolveApplyVo resolveApplyVo);

    ResultData getHistory(String userId);
}
