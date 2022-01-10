package com.coc.eduservice.service;

import com.coc.commonutils.ResultData;
import com.coc.eduservice.entity.StudyOrganization;
import com.baomidou.mybatisplus.extension.service.IService;
import com.coc.servicebase.vo.InputOrganizationVo;

/**
 * <p>
 * 讨论小组 服务类
 * </p>
 *
 * @author cyx
 * @since 2021-04-29
 */
public interface StudyOrganizationService extends IService<StudyOrganization> {
    public ResultData createOrganization(InputOrganizationVo organizationVo);

    ResultData getListByTeacher(String userId, int current, int pageSize);

    ResultData getBannerList(int current,int pageSize,String keyWord);

    ResultData getMmberList(String orgId);
}
