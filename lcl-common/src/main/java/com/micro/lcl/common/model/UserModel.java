package com.micro.lcl.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Todo
 *
 * @author Administrator
 * @date 2020/12/3016:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    private Long id;
    private String username;
    private String password;
    private Integer status;
    private String clientId;
    private List<String> roles;
}
