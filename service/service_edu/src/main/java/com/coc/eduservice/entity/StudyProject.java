package com.coc.eduservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 学习项目
 * </p>
 *
 * @author cyx
 * @since 2021-04-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="StudyProject对象", description="学习项目")
public class StudyProject implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "pro_id", type = IdType.ID_WORKER_STR)
    private String proId;

    @ApiModelProperty(value = "项目内容")
    private String proComment;

    @ApiModelProperty(value = "小组id")
    private String orgId;

    private Date gmtCreate;


}
