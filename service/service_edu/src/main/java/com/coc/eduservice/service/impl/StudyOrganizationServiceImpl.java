package com.coc.eduservice.service.impl;

import com.coc.commonutils.PageEntity;
import com.coc.commonutils.ResultData;
import com.coc.eduservice.entity.StudyOrganization;
import com.coc.servicebase.vo.InputOrganizationVo;
import com.coc.eduservice.mapper.StudyOrganizationMapper;
import com.coc.eduservice.service.StudyOrganizationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讨论小组 服务实现类
 * </p>
 *
 * @author cyx
 * @since 2021-04-29
 */
@Service
public class StudyOrganizationServiceImpl extends ServiceImpl<StudyOrganizationMapper, StudyOrganization> implements StudyOrganizationService {
    @Override
    public ResultData createOrganization(InputOrganizationVo organizationVo) {
        StudyOrganization organization=new StudyOrganization();
        BeanUtils.copyProperties(organizationVo,organization);
        this.save(organization);
        return ResultData.ok().message("创建成功");
    }

    @Override
    public ResultData getListByTeacher(String userId, int current, int pageSize) {
        PageHelper.startPage(current,pageSize);
        List<Map<String, Object>> groupsByTeacher = baseMapper.getGroupsByTeacher(userId);
        PageEntity pageEntity = PageEntity.transPage(new PageInfo(groupsByTeacher));
        return ResultData.ok().data("groupList",groupsByTeacher).data("page",pageEntity);
    }

    @Override
    public ResultData getBannerList(int current,int pageSize,String keyWord) {
        PageHelper.startPage(current,pageSize);
        String key= StringUtils.isEmpty(keyWord)||keyWord.equals("null")?"":keyWord;
        List<Map<String, Object>> bannerList = baseMapper.getBannerList(key);
        PageEntity pageEntity = PageEntity.transPage(new PageInfo(bannerList));
        return ResultData.ok().data("groupList",bannerList).data("page",pageEntity);
    }

    @Override
    public ResultData getMmberList(String orgId) {
        List<Map<String, Object>> memberList = baseMapper.getMemberList(orgId);
        return ResultData.ok().data("memberList",memberList);
    }
}
