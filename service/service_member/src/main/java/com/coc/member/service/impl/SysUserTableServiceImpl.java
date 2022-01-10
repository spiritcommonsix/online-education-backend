package com.coc.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coc.commonutils.ResultData;
import com.coc.member.entity.Members;
import com.coc.member.entity.SysRoleUserTable;
import com.coc.member.entity.SysUserTable;
import com.coc.member.entity.UserAccount;
import com.coc.member.entity.vo.RegisterVo;
import com.coc.member.mapper.MembersMapper;
import com.coc.member.mapper.SysRoleUserTableMapper;
import com.coc.member.mapper.SysUserTableMapper;
import com.coc.member.mapper.UserAccountMapper;
import com.coc.member.service.SysRoleUserTableService;
import com.coc.member.service.SysUserTableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coc.member.utils.BCryptPasswordEncoderUtil;
import com.coc.servicebase.vo.UpdatePwdVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cyx
 * @since 2021-04-12
 */
@Service
public class SysUserTableServiceImpl extends ServiceImpl<SysUserTableMapper, SysUserTable> implements SysUserTableService {

    @Autowired
    private MembersMapper membersMapper;

    @Autowired
    private SysRoleUserTableMapper roleUserTableMapper;

    @Autowired
    private UserAccountMapper accountMapper;

    @Autowired
    private BCryptPasswordEncoderUtil codingUtil;

    @Override
    //注册，判断用户名和手机号是否ok
    public ResultData register(RegisterVo vo) {
        SysUserTable userTable = vo.transferBean();
        //判断用户名是否存在
        QueryWrapper<SysUserTable> userWrapper=new QueryWrapper<>();
        userWrapper.eq("user_name",userTable.getUserName());
        SysUserTable one = this.getOne(userWrapper);
        if(one!=null)
        {
            return ResultData.error().message("用户名已经存在");
        }
        //判断手机号是否存在
        QueryWrapper<Members> membersWrapper=new QueryWrapper<>();
        membersWrapper.eq("member_mobile",vo.getTelNumber());
        Members members1 = membersMapper.selectOne(membersWrapper);
        if(members1!=null)
            return ResultData.error().message("该手机号已经注册");

        //加入user表
        boolean save = this.save(userTable);
        if(!save)
            return ResultData.error().message("插入失败");

        //插入members表
        Members members = new Members();
        members.setMemberId(userTable.getUserId());
        members.setMemberMobile(vo.getTelNumber());

        membersMapper.insert(members);

        //插入账户表
        UserAccount userAccount=new UserAccount();
        userAccount.setUserId(userTable.getUserId());
        accountMapper.insert(userAccount);

        //给新用户分配一个角色学生
        SysRoleUserTable roleUserTable=new SysRoleUserTable();
        roleUserTable.setUserId(userTable.getUserId());
        roleUserTable.setRoleId("1381432271378173953");
        roleUserTableMapper.insert(roleUserTable);


        return ResultData.ok();
    }

    @Override
    public ResultData updatePwd(UpdatePwdVo updatePwdVo) {
        SysUserTable userTable = baseMapper.selectById(updatePwdVo.getUserId());
        boolean flag = codingUtil.matches(updatePwdVo.getOriginPwd(), userTable.getPassWord());
        if(!flag)
            return ResultData.error().message("原密码错误");
        //验证成功
        String encode = codingUtil.encode(updatePwdVo.getNewPwd());

        SysUserTable user=new SysUserTable();
        user.setUserId(updatePwdVo.getUserId());
        user.setPassWord(encode);
        baseMapper.updateById(user);
        return ResultData.ok().message("修改成功");
    }
}
