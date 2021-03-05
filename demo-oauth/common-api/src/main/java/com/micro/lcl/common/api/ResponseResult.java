package com.micro.lcl.common.api;

import lombok.Builder;
import lombok.Data;

/**
 * Todo
 *
 * @author Administrator
 * @date 2021/1/411:55
 */
@Builder
@Data
public class ResponseResult {
    private Integer code = 0;
    private String message;
    private Object data;
}
