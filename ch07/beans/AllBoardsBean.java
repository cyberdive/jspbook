package com.awl.jspbook.ch07;

import java.io.*;
import java.util.*;

public class AllBoardsBean implements Serializable {
  private Hashtable theBoards = new Hashtable();

  public void setNewBoardName(String name) {
    if(theBoards.get(name) == null)
      theBoards.put(name,new Board());
  }

  public String[] getBoardNames() {
    String s[] = new String[theBoards.size()];
    int i=0;

    Enumeration e = theBoards.keys();
    while(e.hasMoreElements())
      s[i++] = (String) e.nextElement();

    return s;
  }


  public Board getBoard(String name) {
    // Work around for the fact that getProperty adds a newline
    name = name.trim();
    return (Board) theBoards.get(name);
  }
}
