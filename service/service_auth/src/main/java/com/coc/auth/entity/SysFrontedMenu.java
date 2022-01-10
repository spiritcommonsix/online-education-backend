package com.coc.auth.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 前端页面列表
 * </p>
 *
 * @author cyx
 * @since 2021-04-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysFrontedMenu对象", description="前端页面列表")
@TableName(value = "sys_frontend_menu_table")
public class SysFrontedMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "frontend_menu_id", type = IdType.ID_WORKER_STR)
    private String frontedMenuId;

    @TableField(value = "frontend_menu_name")
    private String frontedMenuName;

    @TableField(value = "frontend_menu_url")
    private String frontedMenuUrl;

    @TableField(value = "pid")
    private String frontedMenuPid;

    @TableField(value = "frontend_menu_sort")
    private Integer frontedMenuSort;

    @TableField(value = "description")
    private String frontedMenuDescription;


}
