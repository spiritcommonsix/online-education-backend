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
 * 课程状态
 * </p>
 *
 * @author testjava
 * @since 2021-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="EduCourseStatus对象", description="课程状态")
public class EduCourseStatus implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "课程状态ID")
    @TableId(value = "status_id", type = IdType.ID_WORKER_STR)
    private String statusId;

    @ApiModelProperty(value = "课程状态标题")
    private String statusName;

    @ApiModelProperty(value = "课程状态描述")
    private String statusDescription;


}
