package com.coc.eduservice.mapper;

import com.coc.eduservice.entity.StudyOrganization;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讨论小组 Mapper 接口
 * </p>
 *
 * @author cyx
 * @since 2021-04-29
 */
public interface StudyOrganizationMapper extends BaseMapper<StudyOrganization> {
    public List<Map<String,Object>> getGroupsByTeacher(String userId);

    public List<Map<String,Object>> getBannerList(String keyWord);

    public List<Map<String,Object>> getMemberList(String orgId);
}
