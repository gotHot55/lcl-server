package com.micro.lcl.common.exception;

import lombok.Data;

/**
 * 异常信息实体类
 *
 * @author Administrator
 * @date 2021/3/414:43
 */
@Data
public class ErrorResponse {
    private String errorTypeName;
    private String message;

    public ErrorResponse(Exception e) {
        this(e.getClass().getName(), e.getMessage());
    }

    public ErrorResponse(String errorTypeName, String message) {
        this.errorTypeName = errorTypeName;
        this.message = message;
    }
}
