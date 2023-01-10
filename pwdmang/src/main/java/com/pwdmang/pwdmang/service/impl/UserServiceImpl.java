package com.pwdmang.pwdmang.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pwdmang.pwdmang.dao.UserDao;
import com.pwdmang.pwdmang.entity.User;
import com.pwdmang.pwdmang.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}
