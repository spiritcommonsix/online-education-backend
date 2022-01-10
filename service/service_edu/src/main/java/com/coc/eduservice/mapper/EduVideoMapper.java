package com.coc.eduservice.mapper;

import com.coc.eduservice.entity.EduVideo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 小结视频 Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2021-04-10
 */
public interface EduVideoMapper extends BaseMapper<EduVideo> {
    public Integer canGetAuth(@Param("videoId") String videoId,@Param("userId") String userId);
}
