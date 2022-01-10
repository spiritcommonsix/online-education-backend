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
 * 讨论小组
 * </p>
 *
 * @author cyx
 * @since 2021-04-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="StudyOrganization对象", description="讨论小组")
public class StudyOrganization implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "小组编号")
    @TableId(value = "org_id", type = IdType.ID_WORKER_STR)
    private String orgId;

    @ApiModelProperty(value = "小组名称")
    private String orgName;

    @ApiModelProperty(value = "鍒涘缓鑰卛d")
    private String userId;

    private Date gmtCreate;


}
