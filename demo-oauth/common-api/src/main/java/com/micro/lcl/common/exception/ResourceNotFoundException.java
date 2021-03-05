package com.micro.lcl.common.exception;

/**
 * 自定义异常处理类型
 *
 * @author Administrator
 * @date 2021/3/414:53
 */
public class ResourceNotFoundException extends RuntimeException{
    private String message;

    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.getMessage();
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
