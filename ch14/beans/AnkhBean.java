package com.awl.jspbook.ch14;

import java.io.*;

public class AnkhBean {
  private final static byte ankhBytes[] = {
    (byte)0x47,(byte)0x49,(byte)0x46,(byte)0x38,
    (byte)0x37,(byte)0x61,(byte)0x12,(byte)0x00,
    (byte)0x1e,(byte)0x00,(byte)0x80,(byte)0x00,
    (byte)0x00,(byte)0x7f,(byte)0x7f,(byte)0x7f,
    (byte)0xff,(byte)0xff,(byte)0xff,(byte)0x2c,
    (byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,
    (byte)0x12,(byte)0x00,(byte)0x1e,(byte)0x00,
    (byte)0x00,(byte)0x02,(byte)0x3f,(byte)0x8c,
    (byte)0x8f,(byte)0xa9,(byte)0x07,(byte)0xed,
    (byte)0x8b,(byte)0x9e,(byte)0x69,(byte)0x70,
    (byte)0x82,(byte)0x44,(byte)0x57,(byte)0x8e,
    (byte)0x57,(byte)0x77,(byte)0x0e,(byte)0x6d,
    (byte)0xcc,(byte)0xa7,(byte)0x90,(byte)0x56,
    (byte)0x25,(byte)0x06,(byte)0x29,(byte)0x38,
    (byte)0x56,(byte)0xe7,(byte)0x8b,(byte)0x76,
    (byte)0xab,(byte)0xa7,(byte)0x9a,(byte)0x23,
    (byte)0xe5,(byte)0xd8,(byte)0x56,(byte)0xce,
    (byte)0xf3,(byte)0x31,(byte)0xa6,(byte)0x83,
    (byte)0xb9,(byte)0x5a,(byte)0x43,(byte)0x56,
    (byte)0x51,(byte)0x58,(byte)0x9c,(byte)0xfd,
    (byte)0x8e,(byte)0xc8,(byte)0xa1,(byte)0x32,
    (byte)0x14,(byte)0x84,(byte)0x32,(byte)0x9b,
    (byte)0xae,(byte)0x67,(byte)0x68,(byte)0x3a,
    (byte)0x2c,(byte)0x00,(byte)0x00,(byte)0x3b};

  private String fgColor = "7f7f7f";
  private String bgColor = "ffffff";

  public String getFgColor() {return fgColor;}
  public String getBgColor() {return bgColor;}

  public void setFgColor(String fgColor) {
    this.fgColor = fgColor;
    byte tmp[]   = toHex(fgColor);

    ankhBytes[13] = (byte) (tmp[0] * 16 + tmp[1]);
    ankhBytes[14] = (byte) (tmp[2] * 16 + tmp[3]);
    ankhBytes[15] = (byte) (tmp[4] * 16 + tmp[5]);
  }

  public void setBgColor(String bgColor) {
    this.bgColor = bgColor;
    byte tmp[]   = toHex(bgColor);

    ankhBytes[16] = (byte) (tmp[0] * 16 + tmp[1]);
    ankhBytes[17] = (byte) (tmp[2] * 16 + tmp[3]);
    ankhBytes[18] = (byte) (tmp[4] * 16 + tmp[5]);
  }

  public String getAnkh() {
    return new String(ankhBytes);
  }

  public byte[] toHex(String s) {
    byte tmp[] = s.toUpperCase().getBytes();

    for(int i=0;i<tmp.length;i++) {
      if(tmp[i] >= 'A' && tmp[i] <= 'F') {
	tmp[i] = (byte) (tmp[i] - 'A' + 10);
      } else {
	tmp[i] = (byte) (tmp[i] - '0');
      }
    }

    return tmp;
  }
}
