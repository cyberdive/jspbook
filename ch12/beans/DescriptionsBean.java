package com.awl.jspbook.ch12;

import java.sql.*;
import java.text.*;

public class DescriptionsBean {
  private String orderBy  = "";
  private Statement st    = null;
  private ResultSet rs;
  
  private int itemid;
  private boolean itemidSet;
  
  public int getItemid() {
    if(rs == null) return -1;
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
  
  private String name;
  private boolean nameSet;
  
  public String getName() {
    if(rs == null) return null;
    try {
      return rs.getString("name");
    } catch (Exception e) {
    }
    return null;
  }
  
  public void setName(String name) {
    this.name = name;
    this.nameSet = true;
  }
  
  private String shortdesc;
  private boolean shortdescSet;
  
  public String getShortdesc() {
    if(rs == null) return null;
    try {
      return rs.getString("shortdesc");
    } catch (Exception e) {
    }
    return null;
  }
  
  public void setShortdesc(String shortdesc) {
    this.shortdesc = shortdesc;
    this.shortdescSet = true;
  }
  
  private String fulldesc;
  private boolean fulldescSet;
  
  public String getFulldesc() {
    if(rs == null) return null;
    try {
      return rs.getString("fulldesc");
    } catch (Exception e) {
    }
    return null;
  }
  
  public void setFulldesc(String fulldesc) {
    this.fulldesc = fulldesc;
    this.fulldescSet = true;
  }
  
  public void select() {
    try {
      if (rs != null) {rs.close(); rs = null;}
      if (st != null) {st.close(); st = null;}
      Connection tmp = PersistentConnection.getConnection();
      st = tmp.createStatement();
      String query = "SELECT * FROM descriptions";
      String where = buildWhere();
      rs = st.executeQuery(query + where + " " + orderBy + ";");

      itemidSet = false;
      nameSet = false;
      shortdescSet = false;
      fulldescSet = false;
    } catch (Exception e) {
    }
  }
  
  private String buildWhere() {
    StringBuffer where = new StringBuffer(40);
    boolean nonEmpty   = false;
    
    if(itemidSet) {
      if(nonEmpty) where.append(" AND ");
      where.append("itemid=");
      where.append(itemid);
      nonEmpty = true;
    }
    if(nameSet) {
      if(nonEmpty) where.append(" AND ");
      where.append("name=");
      where.append("'");
      where.append(name);
      where.append("'");
      nonEmpty = true;
    }
    if(shortdescSet) {
      if(nonEmpty) where.append(" AND ");
      where.append("shortdesc=");
      where.append("'");
      where.append(shortdesc);
      where.append("'");
      nonEmpty = true;
    }
    if(fulldescSet) {
      if(nonEmpty) where.append(" AND ");
      where.append("fulldesc=");
      where.append("'");
      where.append(fulldesc);
      where.append("'");
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
      query.append("INSERT INTO descriptions(name,shortdesc,fulldesc) VALUES(");
      query.append("'");
      query.append(name);
      query.append("'");
      query.append(',');
      query.append("'");
      query.append(shortdesc);
      query.append("'");
      query.append(',');
      query.append("'");
      query.append(fulldesc);
      query.append("'");
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
