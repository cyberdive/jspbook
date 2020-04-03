package com.awl.jspbook.ch08;

public class PurchaseEvent extends java.util.EventObject {
  private String itemName;

  public PurchaseEvent(Object source,String itemName) 
  {
    super(source);

    this.itemName = itemName;
  }

  public String getItemName() {return itemName;}
}
