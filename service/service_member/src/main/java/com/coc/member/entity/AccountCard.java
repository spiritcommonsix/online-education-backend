package com.coc.member.entity;

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
 * 充值卡信息
 * </p>
 *
 * @author cyx
 * @since 2021-05-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="AccountCard对象", description="充值卡信息")
public class AccountCard implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "card_id", type = IdType.INPUT)
    private String cardId;

    @ApiModelProperty(value = "充值卡金额")
    private Float cardValue;

    @ApiModelProperty(value = "是否有效")
    private Integer isValid;


}
