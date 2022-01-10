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
@ApiModel(value="SysBackendApiTable对象", description="")
public class SysBackendApiTable implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "backend_api_id", type = IdType.ID_WORKER_STR)
    private String backendApiId;

    @ApiModelProperty(value = "API名称")
    private String backendApiName;

    @ApiModelProperty(value = "API请求地址")
    private String backendApiUrl;

    @ApiModelProperty(value = "API请求方式：GET、POST、PUT、DELETE")
    private String backendApiMethod;

    @ApiModelProperty(value = "鐖禝D")
    private String pid;

    @ApiModelProperty(value = "鎺掑簭")
    private Integer backendApiSort;

    @ApiModelProperty(value = "描述")
    private String description;


}
