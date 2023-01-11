package com.pwdmang.pwdmang.controller;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pwdmang.pwdmang.entity.SecrecyDetail;
import com.pwdmang.pwdmang.service.SecrecyDetailService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SecrecyDetailControllerTest {

  @Autowired
  SecrecyDetailService secrecyDetailService;

  @Test
  void testFindListByUserId() {
    Long userId = 1L;
    List<SecrecyDetail> secrecyDetails = secrecyDetailService.findListByUserId(userId);
    for (SecrecyDetail secrecyDetail : secrecyDetails) {
      System.out.println(secrecyDetail);
    }
  }
}
