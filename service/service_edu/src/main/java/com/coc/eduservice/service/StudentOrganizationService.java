package com.coc.eduservice.service;

import com.coc.commonutils.ResultData;
import com.coc.eduservice.entity.StudentOrganization;
import com.baomidou.mybatisplus.extension.service.IService;
import com.coc.servicebase.vo.StudentJoinInOrganizationVo;

/**
 * <p>
 * 用户-讨论组 服务类
 * </p>
 *
 * @author cyx
 * @since 2021-04-29
 */
public interface StudentOrganizationService extends IService<StudentOrganization> {
    public ResultData joinInOrganization(StudentJoinInOrganizationVo joinInOrganizationVo);

    public ResultData existOrganization(StudentJoinInOrganizationVo joinInOrganizationVo);

    ResultData getMembersByOrgId(String orgId);

    ResultData removeMember(String orgId, String userId);

    ResultData getListByStudent(String userId, int current, int pageSize);
}
