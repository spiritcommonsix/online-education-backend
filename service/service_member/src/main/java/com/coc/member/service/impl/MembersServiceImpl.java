package com.coc.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.coc.commonutils.ResultData;
import com.coc.member.entity.*;
import com.coc.member.entity.vo.RegisterVo;
import com.coc.member.mapper.*;
import com.coc.member.service.MembersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coc.servicebase.vo.UpdateUserInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.Map;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author cyx
 * @since 2021-04-11
 */
@Service
public class MembersServiceImpl extends ServiceImpl<MembersMapper, Members> implements MembersService {

    @Autowired
    private MembersMapper membersMapper;

    @Autowired
    private SysUserTableMapper userTableMapper;

    @Autowired
    private UserAccountMapper accountMapper;

    @Autowired
    private AccountCardMapper cardMapper;

    @Autowired
    private UserCardMapper userCardMapper;

    @Autowired
    private SysRoleUserTableMapper roleUserTableMapper;

    @Autowired
    private GetroleMapper getroleMapper;

    @Override
    public Map<String, Object> getUserInfoByUserName(String userName) {
        return membersMapper.getInfoByName(userName);
    }

    @Override
    public ResultData updateUserInfo(UpdateUserInfoVo updateUserInfoVo) {
        //查询该手机号是否存在
        QueryWrapper<Members> membersQueryWrapper=new QueryWrapper<>();
        membersQueryWrapper.ne("user_id",updateUserInfoVo.getMemberId());
        membersQueryWrapper.eq("member_mobile",updateUserInfoVo.getMemberMobile());
        Members members1 = membersMapper.selectOne(membersQueryWrapper);
        if(members1!=null)
            return ResultData.error().message("该手机号已经被注册");

        Members members=new Members();
        BeanUtils.copyProperties(updateUserInfoVo,members);
        members.setMemberId(updateUserInfoVo.getMemberId());
        membersMapper.updateById(members);

        return ResultData.ok().data("member",members);
    }

    @Override
    public ResultData fillAccount(String userId, String code) {
        QueryWrapper<AccountCard> cardQueryWrapper=new QueryWrapper<>();
        cardQueryWrapper.eq("card_id",code);
        if(cardMapper.selectOne(cardQueryWrapper) ==null)
            return ResultData.error().message("无效的充值码");
        cardQueryWrapper.eq("is_valid",1);

        if(cardMapper.selectOne(cardQueryWrapper)==null)
            return ResultData.error().message("该充值码已失效");
        UserCard userCard=new UserCard();
        userCard.setCardId(code);
        userCard.setUserId(userId);

        userCardMapper.insert(userCard);
        return ResultData.ok().message("充值成功");
    }

    @Override
    public ResultData getAccountByUserId(String userId) {
        QueryWrapper<UserAccount> accountQueryWrapper=new QueryWrapper<>();
        accountQueryWrapper.eq("user_id",userId);
        UserAccount userAccount = accountMapper.selectOne(accountQueryWrapper);
        return ResultData.ok().data("accountInfo",userAccount);
    }

    @Override
    public ResultData submitApply(String userId, String roleId) {
        QueryWrapper<SysRoleUserTable> roleUserTableQueryWrapper=new QueryWrapper<>();
        roleUserTableQueryWrapper.eq("user_id",userId);
        roleUserTableQueryWrapper.eq("role_id",roleId);
        SysRoleUserTable roleUserTable = roleUserTableMapper.selectOne(roleUserTableQueryWrapper);

        if(roleUserTable!=null)
            return ResultData.error().message("已拥有该角色，无需申请");
        //查看是否有申请正在被审核
        QueryWrapper<Getrole> getroleQueryWrapper=new QueryWrapper<>();
        getroleQueryWrapper.eq("student_id",userId);
        getroleQueryWrapper.eq("role_id",roleId);
        getroleQueryWrapper.isNull("admin_id");
        Getrole originGetRole = getroleMapper.selectOne(getroleQueryWrapper);
        if(originGetRole!=null)
            return ResultData.error().message("请勿重复申请");


        //插入申请表，等管理员审核通过后再插入角色用户表
        Getrole getrole=new Getrole();
        getrole.setStudentId(userId);
        getrole.setRoleId(roleId);
        getroleMapper.insert(getrole);
        return ResultData.ok().message("申请成功请等待审核");
    }
}