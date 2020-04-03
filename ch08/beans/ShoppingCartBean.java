package com.awl.jspbook.ch08;

import java.io.*;
import java.util.*;

public class ShoppingCartBean implements Serializable {
  public String items[];
  public int numItems;

  public Vector purchaseListeners;

  public ShoppingCartBean() {
    purchaseListeners = new Vector();
    items             = new String[50];
    numItems          = 0;
  }

  public void setItem(String item) {
    items[numItems++] = item;
    firePurchaseEvent(item);
  }


  private void firePurchaseEvent(String item) {
    PurchaseEvent pe = new PurchaseEvent(this,item);

    Enumeration e = purchaseListeners.elements();
    while(e.hasMoreElements()) {
      ((PurchaseListener) e.nextElement()).purchaseMade(pe);
    }
  }

  public void addPurchaseListener(PurchaseListener p) {
    purchaseListeners.addElement(p);
  }

  public void removePurchaseListener(PurchaseListener p) {
    purchaseListeners.removeElement(p);
  }
}
