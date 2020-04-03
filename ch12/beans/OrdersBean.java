package com.awl.jspbook.ch12;

import java.sql.*;
import java.text.*;

public class OrdersBean {
  private String orderBy  = "";
  private Statement st    = null;
  private ResultSet rs;
  
  private int orderid;
  private boolean orderidSet;
  
  public int getOrderid() {
    if(rs == null) return 0;
    try {
      return rs.getInt("orderid");
    } catch (Exception e) {
    }
    return 0;
  }
  
  public void setOrderid(int orderid) {
    this.orderid = orderid;
    this.orderidSet = true;
  }
  
  private int userid;
  private boolean useridSet;
  
  public int getUserid() {
    if(rs == null) return 0;
    try {
      return rs.getInt("userid");
    } catch (Exception e) {
    }
    return 0;
  }
  
  public void setUserid(int userid) {
    this.userid = userid;
    this.useridSet = true;
  }
  
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
  
  private int status;
  private boolean statusSet;
  
  public int getStatus() {
    if(rs == null) return 0;
    try {
      return rs.getInt("status");
    } catch (Exception e) {
    }
    return 0;
  }
  
  public void setStatus(int status) {
    this.status = status;
    this.statusSet = true;
  }
  
  public void select() {
    try {
      if (rs != null) {rs.close(); rs = null;}
      if (st != null) {st.close(); st = null;}
      Connection tmp = PersistentConnection.getConnection();
      st = tmp.createStatement();
      String query = "SELECT * FROM orders";
      String where = buildWhere();
      rs = st.executeQuery(query + where + " " + orderBy);
      if(rs != null) rs.next();
      orderidSet = false;
      useridSet = false;
      catidSet = false;
      statusSet = false;
    } catch (Exception e) {
    }
  }
  
  private String buildWhere() {
    StringBuffer where = new StringBuffer(40);
    boolean nonEmpty   = false;
    
    if(orderidSet) {
      if(nonEmpty) where.append(" AND ");
      where.append("orderid=");
      where.append(orderid);
      nonEmpty = true;
    }
    if(useridSet) {
      if(nonEmpty) where.append(" AND ");
      where.append("userid=");
      where.append(userid);
      nonEmpty = true;
    }
    if(catidSet) {
      if(nonEmpty) where.append(" AND ");
      where.append("catid=");
      where.append(catid);
      nonEmpty = true;
    }
    if(statusSet) {
      if(nonEmpty) where.append(" AND ");
      where.append("status=");
      where.append(status);
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
      query.append("INSERT INTO orders(userid,catid,status) VALUES(");
      query.append(userid);
      query.append(',');
      query.append(catid);
      query.append(',');
      query.append(status);
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
