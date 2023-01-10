package com.pwdmang.pwdmang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pwdmang.pwdmang.common.Result;
import com.pwdmang.pwdmang.entity.User;
import com.pwdmang.pwdmang.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/{id}")
  public Result one(@PathVariable("id") Long id) {
    User user = userService.getById(id);
    return Result.OK(user);
  }

}
