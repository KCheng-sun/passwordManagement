package com.pwdmang.pwdmang.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pwdmang.pwdmang.common.Result;
import com.pwdmang.pwdmang.entity.User;
import com.pwdmang.pwdmang.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController {

  @Autowired
  private UserService userService;

  @GetMapping()
  public Result list(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
    Page<User> users = userService.page(pageNumber, pageSize);
    return Result.OK(users);
  }

  @GetMapping("/{id}")
  public Result one(@PathVariable("id") Long id) {
    User user = userService.getById(id);
    return Result.OK(user);
  }

  @PostMapping("login")
  public Result login(String mobile, String password) {
    Long userId = userService.login(mobile, password);
    if (Objects.isNull(userId)) {
      return Result.ERROR("login error!");
    }
    return Result.OK(userId);
  }

  @PostMapping()
  public Result add(@RequestBody CreateOrUpdateUserRes createUserRes) {
    User user = new User();
    user.setMobile(createUserRes.getMobile());
    user.setPassword(createUserRes.getPassword());
    userService.add(user);
    return Result.OK(null);
  }

  @PutMapping("/{id}")
  public Result change(@PathVariable("id") Long id, @RequestBody CreateOrUpdateUserRes createUserRes) {
    User user = new User();
    user.setId(id);
    user.setMobile(createUserRes.getMobile());
    user.setPassword(createUserRes.getPassword());
    userService.change(user);
    return Result.OK(null);
  }

  @DeleteMapping("/{id}")
  public Result remove(@PathVariable("id") Long id) {
    userService.removeById(id);
    return Result.OK(null);
  }

}
