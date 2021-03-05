package com.micro.lcl.sleb.repository.master;

import com.micro.lcl.sleb.model.LoginModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Todo
 *
 * @author Administrator
 * @date 2021/1/1215:46
 */
@Repository
public interface LoginRepository {
    LoginModel getById(@Param("id") Integer id);
}
