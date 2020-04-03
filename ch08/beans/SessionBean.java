package com.awl.jspbook.ch08;

import java.io.*;
import java.util.*;
import javax.servlet.http.*;

public class SessionBean 
  implements Serializable, HttpSessionBindingListener
{
  private String fileName;
  private String message;

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getFileName() {return fileName;}

  public void setMessage(String message) {
    this.message = message;
  }

  public String getMessage() {return message;}

  public void valueBound(HttpSessionBindingEvent b) {
  }

  public void valueUnbound(HttpSessionBindingEvent b) {
    save();
  }

  public void save() {
    try {
      ObjectOutputStream out = new ObjectOutputStream(
				   new FileOutputStream(fileName));
      out.writeObject(this);
      out.close();
    } catch (Exception e) {}
  }

  public static void main(String argv[]) {
    SessionBean sb = new SessionBean();
    sb.setFileName(argv[0]);
    sb.setMessage(argv[1]);
    sb.save();
  }
}
