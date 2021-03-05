package com.micro.lcl.sleb.service;

import com.micro.lcl.sleb.model.UserModel;
import com.micro.lcl.sleb.repository.core.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Todo
 *
 * @author Administrator
 * @date 2021/1/1316:09
 */
//@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserModel getById(Integer id) {
        return userRepository.getById(id);
    }

}
