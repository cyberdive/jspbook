package com.awl.jspbook.ch04;

import java.text.*;
import java.util.*;

public class Bean1 implements java.io.Serializable {
  public String getName() {
    return "com.awl.jspbook.ch04";
  }


  public int getSeventhPrimeNumber() {
    return 17;
  }

  public String getColor() {
    return "#772266";
  }

  public String getCurrentTime() {
    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm 'and' s 'seconds'");
    return sdf.format(new Date());
  }
}
