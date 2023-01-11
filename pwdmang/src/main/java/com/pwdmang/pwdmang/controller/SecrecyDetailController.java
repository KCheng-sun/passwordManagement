package com.pwdmang.pwdmang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pwdmang.pwdmang.common.Result;
import com.pwdmang.pwdmang.entity.SecrecyDetail;
import com.pwdmang.pwdmang.service.SecrecyDetailService;

@RestController
@RequestMapping("/secrecyDetails")
public class SecrecyDetailController {

  @Autowired
  SecrecyDetailService secrecyDetailService;

  @GetMapping()
  public Result findListByUserId(@RequestParam Long userId) {
    List<SecrecyDetail> secrecyDetails = secrecyDetailService.findListByUserId(userId);
    return Result.OK(secrecyDetails);
  }

}
