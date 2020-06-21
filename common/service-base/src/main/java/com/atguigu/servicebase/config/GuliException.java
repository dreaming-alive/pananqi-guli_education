package com.atguigu.servicebase.config;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 王永超
 * @description
 * @date 2020/6/21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuliException extends RuntimeException {
    
    @ApiModelProperty(value = "状态码")
    private Integer code;
    
    private String msg;
}
