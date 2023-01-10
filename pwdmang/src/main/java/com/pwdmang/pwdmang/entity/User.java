package com.pwdmang.pwdmang.entity;

import java.sql.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("t_users")
public class User {

  @TableId
  private Long id;

  private String mobile;

  private String password;

  private Date createdTime;

  private Date updateTime;
}
