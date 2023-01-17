package com.pwdmang.pwdmang.service.impl;

import java.util.Date;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pwdmang.pwdmang.dao.UserDao;
import com.pwdmang.pwdmang.entity.User;
import com.pwdmang.pwdmang.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

  @Autowired
  UserDao userDao;

  @Override
  public Long login(String mobile, String password) {
    QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
    queryWrapper.eq("mobile", mobile);
    queryWrapper.eq("password", password);
    User user = userDao.selectOne(queryWrapper);
    if (Objects.nonNull(user)) {
      return user.getId();
    }
    return null;
  }

  @Override
  public Page<User> page(Integer page, Integer size) {
    Page<User> pageObj = new Page<User>(page, size);
    Page<User> userPage = userDao.selectPage(pageObj, null);
    return userPage;
  }

  @Override
  public void add(User user) {
    user.setCreatedTime(new Date());
    user.setUpdateTime(new Date());
    baseMapper.insert(user);
  }

  @Override
  public void change(User user) {
    user.setUpdateTime(new Date());
    baseMapper.updateById(user);
  }

}
