package com.awl.jspbook.ch12;

import java.util.*;
import java.sql.*;
import java.text.*;

public class ShoppingCartBean {
  private Vector catIds     = new Vector();
  private Vector names      = new Vector();
  private Vector variations = new Vector();
  private Vector prices     = new Vector();

  private float total = 0;

  public void setCatid(int catid) {
    try {
      Connection tmp = PersistentConnection.getConnection();
      Statement   st = tmp.createStatement();
      ResultSet   rs = st.executeQuery("select descriptions.name, catalog.variation, catalog.price WHERE descriptions.itemid = catalog.itemid AND catalog.catid = " + catid);
      
      if(rs.next()) {
	catIds.addElement(new Integer(catid));
	names.addElement(rs.getString("name"));
	variations.addElement(rs.getString("variation"));
	
	float ftmp = rs.getFloat("price");
	total += ftmp;
	
	prices.addElement(new Float(ftmp));
      }
      
      rs.close();
      st.close();
    } catch (Exception e) {
      System.err.println("Unable to update shopping cart");
      e.printStackTrace(System.err);
    }
  }

  int count;
  public void reset() {count = -1;}
  public int getCount() {return count;}

  /**
   * This method, and the following get methods, simulate
   * the behavior of a database bean, even though all the data
   * is kept in memory
   */
  public boolean next() {
    count++;
    if(count == catIds.size()) return false;
    return true;
  }

  public String getName() {return (String) names.elementAt(count);}
  public String getVariation() {return (String) variations.elementAt(count);}
  public Float getPrice() {return (Float) prices.elementAt(count);}


  /**
   * This method provides a handy way to delete items from JSPs
   */
  public void setDeleteId(int deleteId) {
    catIds.removeElementAt(deleteId);
    names.removeElementAt(deleteId);
    variations.removeElementAt(deleteId);
    total = total - ((Float) prices.elementAt(deleteId)).floatValue();
    prices.removeElementAt(deleteId);
  }

  public float getTotal() {return total;}

  public void order(UserInfoBean user) {
    try {
      Connection tmp = PersistentConnection.getConnection();
      Statement   st = tmp.createStatement();
      
      for(int i=0;i<catIds.size();i++) {
	st.executeUpdate("insert into orders(userid,catid,status) values(" +
			 user.getUserid() + "," + catIds.elementAt(i) + 
			 ",0);");
	
	/* decrement our count in inventory */
	st.executeUpdate(" update catalog set inventory = invenoty-1" + 
			 " where catid = " + catIds.elementAt(i));
      }
      
      st.close();
      
      catIds     = new Vector();
      names      = new Vector();
      variations = new Vector();
      prices     = new Vector();
      
      /* In a fully real site we would also charge the user here */
    } catch (Exception e) {
      System.err.println("Unable to place order");
    }
  }
}
