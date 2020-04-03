package com.awl.jspbook.ch08;

public class ArrayBean {
  private String things[];

  public String[] getThings() {return things;}
  public void setThings(String things[]) {this.things = things;}

  public String getThings(int i) {return things[i];}
  public void setThings(int i, String thing) {
    things[i] = thing;
  }
}
