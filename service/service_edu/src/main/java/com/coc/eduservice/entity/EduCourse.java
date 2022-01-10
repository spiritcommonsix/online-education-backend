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
 * 课程列表
 * </p>
 *
 * @author testjava
 * @since 2021-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="EduCourse对象", description="课程列表")
public class EduCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    public EduCourse() {
    }

    public EduCourse(String courseId) {
        this.courseId = courseId;
    }

    @ApiModelProperty(value = "课程ID")
    @TableId(value = "course_id", type = IdType.ID_WORKER_STR)
    private String courseId;

    @ApiModelProperty(value = "发布人id")
    private String userId;

    @ApiModelProperty(value = "课程专业ID")
    private String subjectId;

    @ApiModelProperty(value = "课程标题")
    private String courseTitle;

    @ApiModelProperty(value = "课程销售价格，设置为0则可免费观看")
    private Float coursePrice;

    @ApiModelProperty(value = "课程简介")
    private String courseDescription;

    @ApiModelProperty(value = "课程封面图片路径")
    private String courseCover;

    @ApiModelProperty(value = "课程状态，发布或未发布等")
    private String statusId;

    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;


}
