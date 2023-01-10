package com.pwdmang.pwdmang.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pwdmang.pwdmang.entity.User;

@Mapper
public interface UserDao extends BaseMapper<User> {

}
