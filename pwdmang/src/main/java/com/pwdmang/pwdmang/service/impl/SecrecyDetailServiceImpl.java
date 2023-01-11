package com.pwdmang.pwdmang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pwdmang.pwdmang.dao.SecrecyDetailDao;
import com.pwdmang.pwdmang.entity.SecrecyDetail;
import com.pwdmang.pwdmang.service.SecrecyDetailService;

@Service
public class SecrecyDetailServiceImpl extends ServiceImpl<SecrecyDetailDao, SecrecyDetail>
    implements SecrecyDetailService {

  @Autowired
  SecrecyDetailDao secrecyDetailDao;

  @Override
  public List<SecrecyDetail> findListByUserId(Long userId) {
    QueryWrapper<SecrecyDetail> queryWrapper = new QueryWrapper<SecrecyDetail>();
    queryWrapper.eq("user_id", userId);
    List<SecrecyDetail> secrecyDetails = secrecyDetailDao.selectList(queryWrapper);
    return secrecyDetails;
  }

}
