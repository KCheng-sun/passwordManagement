package com.pwdmang.pwdmang.entity;

import java.sql.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Data
@TableName("t_secrecy_details")
@ToString
public class SecrecyDetail {

  @TableId
  private Long id;

  private Long userId;

  private String title;

  private String username;

  private String password;

  private String remark;

  private String bindMobile;

  private String bindEmail;

  @JsonIgnore
  private Date createdTime;

  @JsonIgnore
  private Date updateTime;
}
