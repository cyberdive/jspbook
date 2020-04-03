package com.awl.jspbook.ch11;

import java.io.*;
import java.util.*;

public class Message implements Serializable {
  private String from    = null;
  private String subject = null;
  private String text    = null;

  public String getFrom()    {return from;}
  public String getSubject() {return subject;}
  public String getText()    {return text;}

  public void setFrom(String s)    {from = s;}
  public void setSubject(String s) {subject = s;}
  public void setText(String s)    {text = s;}

  public boolean isReady() {
    return (from != null && subject != null && text != null);
  }
}
