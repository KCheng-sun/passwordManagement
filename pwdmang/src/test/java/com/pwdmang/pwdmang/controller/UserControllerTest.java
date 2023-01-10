package com.pwdmang.pwdmang.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.pwdmang.pwdmang.entity.User;
import com.pwdmang.pwdmang.service.UserService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserControllerTest {

  @Autowired
  private UserService userService;

  @Test
  void testOne() {
    Long id = 1L;
    User user = userService.getById(id);
    Assert.notNull(user, "error");
  }
}
