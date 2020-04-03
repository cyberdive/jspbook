package com.awl.jspbook.ch08;

import java.io.*;
import java.util.*;

public class InventoryBean
  implements Serializable,PurchaseListener
{
  private static final Integer ONE = new Integer(1);
  private Hashtable inventory      = new Hashtable();

  public void addInventory(String name) {
    Integer count = (Integer) inventory.get(name);
    if(count == null) {
      inventory.put(name,ONE);
    } else {
      inventory.put(name,
		    new Integer(count.intValue() + 1));
    }
  }

  public void removeInventory(String name) 
  {
    Integer count = (Integer) inventory.get(name);
    if(count == null) {
      return;
    } else if(count.equals(ONE)) {
      inventory.remove(name);
    } else {
      inventory.put(name,
		    new Integer(count.intValue() - 1));
    }
  }

  public void purchaseMade(PurchaseEvent pe) {
    removeInventory(pe.getItemName());
  }
}
