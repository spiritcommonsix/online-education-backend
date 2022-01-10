package com.coc.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.coc.commonutils.PageEntity;
import com.coc.commonutils.ResultData;
import com.coc.eduservice.entity.StudentOrganization;
import com.coc.eduservice.entity.StudyOrganization;
import com.coc.eduservice.mapper.StudyOrganizationMapper;
import com.coc.servicebase.vo.StudentJoinInOrganizationVo;
import com.coc.eduservice.mapper.StudentOrganizationMapper;
import com.coc.eduservice.service.StudentOrganizationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户-讨论组 服务实现类
 * </p>
 *
 * @author cyx
 * @since 2021-04-29
 */
@Service
public class StudentOrganizationServiceImpl extends ServiceImpl<StudentOrganizationMapper, StudentOrganization> implements StudentOrganizationService {
    @Autowired
    private StudyOrganizationMapper organizationMapper;
    @Autowired
    private StudentOrganizationMapper studentOrganizationMapper;

    @Override
    public ResultData joinInOrganization(StudentJoinInOrganizationVo joinInOrganizationVo) {
        QueryWrapper<StudyOrganization> organizationQueryWrapper=new QueryWrapper<>();
        organizationQueryWrapper.eq("user_id",joinInOrganizationVo.getUserId());
        organizationQueryWrapper.eq("org_id",joinInOrganizationVo.getOrgId());
        StudyOrganization organization = organizationMapper.selectOne(organizationQueryWrapper);
        if(organization!=null)
            return ResultData.error().message("创立者无需加入");

        QueryWrapper<StudentOrganization> studentOrganizationQueryWrapper=new QueryWrapper<>();
        studentOrganizationQueryWrapper.eq("user_id",joinInOrganizationVo.getUserId());
        studentOrganizationQueryWrapper.eq("org_id",joinInOrganizationVo.getOrgId());
        StudentOrganization studentOrganization1 = studentOrganizationMapper.selectOne(studentOrganizationQueryWrapper);
        if(studentOrganization1!=null){
            return ResultData.error().message("已加入该组，不可重复加入");
        }

        StudentOrganization studentOrganization=new StudentOrganization();

        BeanUtils.copyProperties(joinInOrganizationVo,studentOrganization);



        this.save(studentOrganization);
        return ResultData.ok().message("加入成功");
    }

    @Override
    public ResultData existOrganization(StudentJoinInOrganizationVo joinInOrganizationVo) {
        UpdateWrapper<StudentOrganization> studentOrganizationUpdateWrapper=new UpdateWrapper<>();
        studentOrganizationUpdateWrapper.eq("org_id",joinInOrganizationVo.getOrgId());
        studentOrganizationUpdateWrapper.eq("user_id",joinInOrganizationVo.getUserId());
        this.remove(studentOrganizationUpdateWrapper);
        return ResultData.ok().message("退出成功");
    }


    //TODO 根据组id查询所有成员
    @Override
    public ResultData getMembersByOrgId(String orgId) {

        return null;
    }

    @Override
    public ResultData removeMember(String orgId, String userId) {
        UpdateWrapper<StudentOrganization> studentOrganizationUpdateWrapper=new UpdateWrapper<>();
        studentOrganizationUpdateWrapper.eq("org_id",orgId);
        studentOrganizationUpdateWrapper.eq("user_id",userId);
        baseMapper.delete(studentOrganizationUpdateWrapper);
        return ResultData.ok();
    }

    @Override
    public ResultData getListByStudent(String userId, int current, int pageSize) {
        PageHelper.startPage(current,pageSize);
        List<Map<String, Object>> groupListByStudent = baseMapper.getGroupListByStudent(userId);
        PageEntity pageEntity = PageEntity.transPage(new PageInfo(groupListByStudent));
        return ResultData.ok().data("groupList",groupListByStudent).data("page",pageEntity);
    }
}
