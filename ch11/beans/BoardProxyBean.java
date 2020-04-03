package com.awl.jspbook.ch11;

import java.io.*;
import java.util.*;

public class BoardProxyBean implements Serializable {
  private Board         theBoard   = null;
  private AllBoardsBean allBoards  = null;
  private Message       newMessage = null;
  private Enumeration   messages   = null;
  private String        id;

  public void setAllBoards(AllBoardsBean b) {
    allBoards = b;
  }

  public String getBoardId() {return id;}

  public void setBoardId(String id) {
    this.id = id;

    if (allBoards != null) {
      theBoard = allBoards.getBoard(id);
    }
  }
  
  public void setFrom(String s) {
    if(newMessage == null) newMessage = new Message();

    newMessage.setFrom(s);

    maybeSave();
  }

  private void maybeSave() {
    if(newMessage.isReady()) {
      if(theBoard != null) {
	theBoard.addMessage(newMessage);
	messages = theBoard.getMessages();
      }
      newMessage = null;
    }
  }

  public void setSubject(String s) {
    if(newMessage == null) newMessage = new Message();

    newMessage.setSubject(s);

    maybeSave();
  }

  public void setText(String s) {
    if(newMessage == null) newMessage = new Message();

    newMessage.setText(s);

    maybeSave();
  }

  public boolean hasMoreMessages() {
    if (messages == null) return false;

    boolean tmp = messages.hasMoreElements();
    if(tmp)
      newMessage  = (Message) messages.nextElement();
    return tmp;
  }

  public String getText() {
    return (newMessage == null) ? "" : newMessage.getText();
  }

  public String getFrom() {
    return (newMessage == null) ? "" : newMessage.getFrom();
  }

  public String getSubject() {
    return (newMessage == null) ? "" : newMessage.getSubject();
  }
}
