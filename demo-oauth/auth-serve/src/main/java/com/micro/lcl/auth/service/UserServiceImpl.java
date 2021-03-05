package com.micro.lcl.auth.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.micro.lcl.auth.entity.User;
import com.micro.lcl.auth.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * Todo
 *
 * @author Administrator
 * @date 2021/1/414:55
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
