package com.awl.jspbook.ch10;

import javax.servlet.*;
import javax.servlet.http.*;

public class UserInfoBean implements java.io.Serializable {
  private String name;
  private HttpServletRequest request;

  public void setRequest(Object request) {
    this.request = (HttpServletRequest) request;
    name         = "user from " + this.request.getRemoteHost();
  }

  public String getName() {return name;}
}
