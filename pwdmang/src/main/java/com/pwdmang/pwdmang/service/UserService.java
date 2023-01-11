package com.pwdmang.pwdmang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pwdmang.pwdmang.entity.User;

public interface UserService extends IService<User> {
  public Long login(String mobile, String password);
}
