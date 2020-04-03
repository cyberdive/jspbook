package com.awl.jspbook.ch11;

import java.io.*;
import java.util.*;

public class Board implements Serializable {
  private Vector theMessages = new Vector();

  public void addMessage(Message m) {
    theMessages.addElement(m);
  }

  public Enumeration getMessages() {return theMessages.elements();}
}
