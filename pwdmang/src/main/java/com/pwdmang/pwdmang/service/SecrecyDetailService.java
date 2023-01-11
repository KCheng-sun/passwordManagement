package com.pwdmang.pwdmang.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pwdmang.pwdmang.entity.SecrecyDetail;

public interface SecrecyDetailService extends IService<SecrecyDetail> {

  public List<SecrecyDetail> findListByUserId(Long userId);

}
