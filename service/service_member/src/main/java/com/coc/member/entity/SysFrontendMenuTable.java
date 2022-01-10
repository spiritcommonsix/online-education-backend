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
 * 
 * </p>
 *
 * @author cyx
 * @since 2021-04-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysFrontendMenuTable对象", description="")
public class SysFrontendMenuTable implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "frontend_menu_id", type = IdType.ID_WORKER_STR)
    private String frontendMenuId;

    @ApiModelProperty(value = "前端菜单名称")
    private String frontendMenuName;

    @ApiModelProperty(value = "前端菜单访问HTML地址")
    private String frontendMenuUrl;

    @ApiModelProperty(value = "鐖禝D")
    private String pid;

    @ApiModelProperty(value = "鎺掑簭")
    private Integer frontendMenuSort;

    @ApiModelProperty(value = "描述")
    private String description;


}
