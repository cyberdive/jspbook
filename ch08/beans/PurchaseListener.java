package com.awl.jspbook.ch08;

public interface PurchaseListener 
  extends java.util.EventListener 
{
  public void purchaseMade(PurchaseEvent e);
}
