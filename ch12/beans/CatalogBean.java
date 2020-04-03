package com.awl.jspbook.ch12;

import java.sql.*;
import java.text.*;

public class CatalogBean {
  private String orderBy  = "";
  private Statement st    = null;
  private ResultSet rs;
  
  private int catid;
  private boolean catidSet;
  
  public int getCatid() {
    if(rs == null) return 0;
    try {
      return rs.getInt("catid");
    } catch (Exception e) {
    }
    return 0;
  }
  
  public void setCatid(int catid) {
    this.catid = catid;
    this.catidSet = true;
  }
  
  private int itemid;
  private boolean itemidSet;
  
  public int getItemid() {
    if(rs == null) return 0;
    try {
      return rs.getInt("itemid");
    } catch (Exception e) {
    }
    return 0;
  }
  
  public void setItemid(int itemid) {
    this.itemid = itemid;
    this.itemidSet = true;
  }
  
  private String variation;
  private boolean variationSet;
  
  public String getVariation() {
    if(rs == null) return null;
    try {
      return rs.getString("variation");
    } catch (Exception e) {
    }
    return null;
  }
  
  public void setVariation(String variation) {
    this.variation = variation;
    this.variationSet = true;
  }
  
  private float price;
  private boolean priceSet;
  
  public float getPrice() {
    if(rs == null) return (float) 0.0;
    try {
      return rs.getFloat("price");
    } catch (Exception e) {
    }
    return (float) 0.0;
  }
  
  public void setPrice(float price) {
    this.price = price;
    this.priceSet = true;
  }
  
  private int inventory;
  private boolean inventorySet;
  
  public int getInventory() {
    if(rs == null) return 0;
    try {
      return rs.getInt("inventory");
    } catch (Exception e) {
    }
    return 0;
  }
  
  public void setInventory(int inventory) {
    this.inventory = inventory;
    this.inventorySet = true;
  }
  
  public void select() {
    try {
      if (rs != null) {rs.close(); rs = null;}
      if (st != null) {st.close(); st = null;}
      Connection tmp = PersistentConnection.getConnection();
      st = tmp.createStatement();
      String query = "SELECT * FROM catalog";
      String where = buildWhere();

      rs = st.executeQuery(query + where + " " + orderBy + ";");
      catidSet = false;
      itemidSet = false;
      variationSet = false;
      priceSet = false;
      inventorySet = false;
    } catch (Exception e) {
    }
  }
  
  private String buildWhere() {
    StringBuffer where = new StringBuffer(40);
    boolean nonEmpty   = false;
    

    /* This bean uses a special WHERE clause to ensure
     * that only items that are in stock are shown to the users 
     */

    where.append(" inventory > 0 ");
    nonEmpty = true;

    if(catidSet) {
      if(nonEmpty) where.append(" AND ");
      where.append("catid=");
      where.append(catid);
      nonEmpty = true;
    }
    if(itemidSet) {
      if(nonEmpty) where.append(" AND ");
      where.append("itemid=");
      where.append(itemid);
      nonEmpty = true;
    }
    if(variationSet) {
      if(nonEmpty) where.append(" AND ");
      where.append("variation=");
      where.append("'");
      where.append(variation);
      where.append("'");
      nonEmpty = true;
    }
    if(priceSet) {
      if(nonEmpty) where.append(" AND ");
      where.append("price=");
      where.append("'");
      where.append(price);
      where.append("'");
      nonEmpty = true;
    }
    if(inventorySet) {
      if(nonEmpty) where.append(" AND ");
      where.append("inventory=");
      where.append(inventory);
      nonEmpty = true;
    }

    if(nonEmpty) {
      return " WHERE " + where.toString();
    } else {
      return "";
    }
  }
  
  public void insert() {
    try {
      if (rs != null) {rs.close(); rs = null;}
      if (st != null) {st.close(); st = null;}
      Connection tmp = PersistentConnection.getConnection();
      st = tmp.createStatement();
      
      StringBuffer query = new StringBuffer(100);
      query.append("INSERT INTO catalog(itemid,variation,price,inventory) VALUES(");
      query.append(itemid);
      query.append(',');
      query.append("'");
      query.append(variation);
      query.append("'");
      query.append(',');
      query.append("'");
      query.append(price);
      query.append("'");
      query.append(',');
      query.append(inventory);
      query.append(")");
      
      st.execute(query.toString());
    } catch (Exception e) {
    }
  }
  
  public boolean next() {
    if(rs == null) return false;
    try {
      return rs.next();
    } catch (Exception e) {
      e.printStackTrace(System.err);
      return false;
    }
  }
  
  public void cleanup() {
    try {
      if (rs != null) rs.close();
      if (st != null) st.close();
    } catch (Exception e) {
    }
  }
}
