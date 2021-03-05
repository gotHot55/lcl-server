package com.micro.lcl.auth.beans;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * Todo
 *
 * @author Administrator
 * @date 2021/1/414:35
 */
@Data
public class ReferRequest {
    @NotEmpty
    private String username;

    @NotEmpty
    private String referToken;
}
