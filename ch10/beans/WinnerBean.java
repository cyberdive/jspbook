package com.awl.jspbook.ch10;

import java.io.*;
import java.util.*;

public class WinnerBean implements Serializable {
  private static final Integer ONE = new Integer(1);

  private Hashtable winners = new Hashtable();
  private int sortedScores[];
  private String sortedNames[];

  private int topTenScores[];
  private String topTenNames[];

  public void setName(String name) {
    Integer tmp = (Integer) winners.get(name);
    if(tmp == null)
      winners.put(name,ONE);
    else
      winners.put(name,new Integer(tmp.intValue() + 1));

    resort();
  }

  public void resort() {
    // buble sort, pull out last ten, yeah.
    return;
  }

  public String[] getNames() {
    return topTenNames;
  }

  public int[] getScores() {
    return topTenScores;
  }
}
