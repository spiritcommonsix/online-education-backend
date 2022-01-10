package com.coc.member.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author cyx
 * @since 2021-04-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Members对象", description="用户")
public class Members implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.INPUT)
    private String memberId;

    @ApiModelProperty(value = "手机号")
    private String memberMobile;

    @ApiModelProperty(value = "性别 1 女，2 男")
    private Integer memberSex;

    @ApiModelProperty(value = "用户头像")
    private String memberAvatar;

    @ApiModelProperty(value = "用户签名")
    private String memberSign;


    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;


}
