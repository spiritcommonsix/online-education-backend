package com.coc.eduservice.mapper;

import com.coc.eduservice.entity.StudentOrganization;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户-讨论组 Mapper 接口
 * </p>
 *
 * @author cyx
 * @since 2021-04-29
 */
public interface StudentOrganizationMapper extends BaseMapper<StudentOrganization> {
    public List<Map<String,Object>> getGroupListByStudent(String userId);
}
