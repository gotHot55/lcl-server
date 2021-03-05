package com.micro.lcl.common.other;

import lombok.Data;

/**
 * Todo
 *
 * @author Administrator
 * @date 2021/2/2516:31
 */
@Data
public class UserModel {
    private Integer id;
    private String username;
    private String password;

    public UserModel(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public UserModel() {
    }
}
