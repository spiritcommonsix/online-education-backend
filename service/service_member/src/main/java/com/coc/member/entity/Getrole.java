package com.coc.member.entity;

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
 * 申请教师角色
 * </p>
 *
 * @author cyx
 * @since 2021-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Getrole对象", description="申请教师角色")
public class Getrole implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "申请者id")
    private String studentId;

    @ApiModelProperty(value = "审核者id")
    private String adminId;

    private String roleId;

    @ApiModelProperty(value = "是否通过，0表示未通过，1表示通过")
    private Integer isPass;

    @ApiModelProperty(value = "管理员id")
    private Date gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private Date gmtUpdate;


}
