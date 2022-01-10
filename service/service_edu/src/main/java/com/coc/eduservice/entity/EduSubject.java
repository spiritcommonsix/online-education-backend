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
 * 课程科目
 * </p>
 *
 * @author testjava
 * @since 2021-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="EduSubject对象", description="课程科目")
public class EduSubject implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "课程类别ID")
    @TableId(value = "subject_id", type = IdType.ID_WORKER_STR)
    private String subjectId;

    @ApiModelProperty(value = "类别名称")
    private String subjectTitle;

    @ApiModelProperty(value = "父ID")
    private String parentId;

    public EduSubject() {
    }

    public EduSubject(String subjectTitle, String parentId) {
        this.subjectTitle = subjectTitle;
        this.parentId = parentId;
    }
}
