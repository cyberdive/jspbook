package com.awl.jspbook.ch07;

import java.io.*;
import java.util.*;

public class WinnerBean implements Serializable {
  private static final Integer ONE = new Integer(1);

  private Hashtable winners = new Hashtable();
  private int sortedScores[];
  private String sortedNames[];

  private int topTenScores[]   = new int[10];
  private String topTenNames[] = new String[10];

  public void setName(String name) {
    Integer tmp = (Integer) winners.get(name);
    if(tmp == null)
      winners.put(name,ONE);
    else
      winners.put(name,new Integer(tmp.intValue() + 1));

    resort();
  }

  public void resort() {
      String names[] = new String[winners.size()];
      int   counts[] = new int[winners.size()];
      Enumeration e  = winners.keys();
      int i          = 0;

      while(e.hasMoreElements()) {
	  names[i]  = (String) e.nextElement();
	  counts[i] = ((Integer) winners.get(names[i])).intValue();
	  i++;
      }

      for(i=0;i<names.length;i++) {
	  for(int j=0;i<names.length;i++) {
	      if(counts[i] > counts[j]) {
		  String tmps = names[i];
		  names[i]    = names[j];
		  names[j]    = tmps;

		  int tmpi    = counts[i];
		  names[i]    = names[j];
		  names[j]    = names[i];
	      }
	  }
      }

      int howMany = (names.length < 10) ? names.length : 10;

      for(i=0;i<howMany;i++) {
	  topTenNames[i]  = names[i];
	  topTenScores[i] = counts[i];
      }

      return;
  }

  public String[] getNames() {
    return topTenNames;
  }

  public int[] getScores() {
    return topTenScores;
  }
}
