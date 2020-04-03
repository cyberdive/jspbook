package com.awl.jspbook.ch07;

public class Counter implements java.io.Serializable {
  private int count;

  public void setCount(int c) {count = c;}

  public int getCount() {
    count++;
    return count;
  }
}
