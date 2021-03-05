package com.micro.lcl.sleb.repository.core;

import com.micro.lcl.sleb.model.UserModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Todo
 *
 * @author Administrator
 * @date 2021/1/1215:43
 */
//@Repository
public interface UserRepository {
    UserModel getById(@Param("id") Integer id);
}
