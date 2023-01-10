package com.pwdmang.pwdmang.common;

import lombok.Data;

@Data
public class Result {

  private Object data;
  private String code;
  private String message;

  public static Result OK(Object data) {
    Result result = new Result();
    result.setData(data);
    result.setMessage("成功");
    result.setCode("20000");
    return result;
  }

  public static Result ERROR(String mssage) {
    Result result = new Result();
    result.setMessage(mssage);
    result.setCode("40000");
    return result;
  }

}
