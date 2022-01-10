package com.coc.auth.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * 后端权限访问列表
 * </p>
 *
 * @author cyx
 * @since 2021-04-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysBackendApi对象", description="后端权限访问列表")
@TableName("sys_backend_api_table")
public class SysBackendApi implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "backend_api_id", type = IdType.ID_WORKER_STR)
    private String backendApiId;

    private String backendApiName;

    private String backendApiUrl;

    private String backendApiMethod;

    private String backendApiPid;

    private Integer backendApiSort;

    private String backendApiDescription;


}
