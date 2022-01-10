package com.coc.member.service;

import com.coc.commonutils.ResultData;
import com.coc.member.entity.Members;
import com.baomidou.mybatisplus.extension.service.IService;
import com.coc.member.entity.vo.RegisterVo;
import com.coc.servicebase.vo.UpdateUserInfoVo;

import java.util.Map;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author cyx
 * @since 2021-04-11
 */
public interface MembersService extends IService<Members> {

    Map<String, Object> getUserInfoByUserName(String userName);

    ResultData updateUserInfo(UpdateUserInfoVo updateUserInfoVo);

    ResultData fillAccount(String userId, String code);

    ResultData getAccountByUserId(String userId);

    ResultData submitApply(String userId, String roleId);
}
