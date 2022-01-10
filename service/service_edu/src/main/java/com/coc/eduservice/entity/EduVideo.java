package com.coc.eduservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 小结视频
 * </p>
 *
 * @author testjava
 * @since 2021-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="EduVideo对象", description="小结视频")
public class EduVideo implements Serializable {
    public static final String DEFAULT_SOURCE="9b8a1d2db32542df8c41f5dc0b0068a7";

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "视频ID")
    @TableId(value = "video_id", type = IdType.ID_WORKER_STR)
    private String videoId;

    @ApiModelProperty(value = "章节ID")
    private String chapterId;

    @ApiModelProperty(value = "节点名称")
    private String videoTitle;

    @ApiModelProperty(value = "云端视频资源")
    private String videoSource;

    @ApiModelProperty(value = "是否可以试听：0收费 1免费")
    private Boolean isFree;


}
