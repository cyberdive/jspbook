package com.awl.jspbook.ch06;

public class CalcBean implements java.io.Serializable {
  private int value1;
  private int value2;

  private String valueS1;
  private String valueS2;

  private boolean value1_OK = false;
  private boolean value2_OK = false;

  public void setValue1(String value1) {
    valueS1 = value1;
    try {
      this.value1 = Integer.parseInt(value1);
      value1_OK   = true;
    } catch (NumberFormatException nfe) {}
  }

  public void setValue2(String value2) {
    valueS2 = value2;
    try {
      this.value2 = Integer.parseInt(value2);
      value2_OK   = true;
    } catch (NumberFormatException nfe) {}
  }

  public int getSum() {
    return value1 + value2;
  }

  public String getReason() {
    if (value1_OK) {
      if(value2_OK) return "";
      else return "\"" + valueS2 + "\" is not an integer";
    } else {
      if(value2_OK) return "\"" + valueS1 + "\" is not an integer";
      else return "neither value is an integer";
    }
  }

  public boolean isValid() {
    return value1_OK && value2_OK;
  }
}
