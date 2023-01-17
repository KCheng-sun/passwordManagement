package com.pwdmang.pwdmang.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pwdmang.pwdmang.entity.User;

public interface UserService extends IService<User> {

  public Long login(String mobile, String password);

  public Page<User> page(Integer page, Integer size);

  public void add(User user);

  public void change(User user);

}
