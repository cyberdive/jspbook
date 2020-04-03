package com.awl.jspbook.ch11;

import java.sql.*;

public class SectionBean {
  private String orderBy     = "";
  private Statement st = null;
  private ResultSet rs;

  public void setOrderBy(String orderBy) {
    this.orderBy = orderBy;
  }

  private int sectionId;
  private boolean sectionIdSet = false;

  public int getSectionId() {
    if(rs == null) return 0;

    try {
      return rs.getInt("sectionId");
    } catch(Exception e) {
      e.printStackTrace(System.err);
    }
    return 0;
  }

  public void setSectionId(int sectionId) {
    this.sectionId = sectionId;
    this.sectionIdSet = true;
  }

  private String name;
  private boolean nameSet = false;

  public String getName() {
    if(rs == null) return null;

    try {
      return rs.getString("name");
    } catch(Exception e) {
      e.printStackTrace(System.err);
    }
    return null;
  }

  public String getNameURLEncoded() {
    if(rs == null) return null;

    try {
      return rs.getString("name").replace(' ','+');
    } catch(Exception e) {
      e.printStackTrace(System.err);
    }
    return null;
  }

  public void setName(String name) {
    this.name = name;
    this.nameSet = true;
  }

  private String description;
  private boolean descriptionSet = false;

  public String getDescription() {
    if(rs == null) return null;

    try {
      return rs.getString("description");
    } catch(Exception e) {
      e.printStackTrace(System.err);
    }
    return null;
  }

  public String getDescriptionURLEncoded() {
    if(rs == null) return null;

    try {
      return rs.getString("description").replace(' ','+');
    } catch(Exception e) {
      e.printStackTrace(System.err);
    }
    return null;
  }

  public void setDescription(String description) {
    this.description = description;
    this.descriptionSet = true;
  }

  public void select() {
    try {
      if (rs != null) rs.close();
      if (st != null) st.close();

      Connection tmp = PersistentConnection.getConnection();
      st = tmp.createStatement();

      String query = "SELECT * FROM Sections";
      String where = buildWhere();
      
      rs = st.executeQuery(query + where + " " + orderBy);

      sectionIdSet = false;
      nameSet = false;
      descriptionSet = false;

    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
  }

  private String buildWhere() {
    StringBuffer where = new StringBuffer(20);
    boolean nonEmpty   = false;

    if(sectionIdSet) {
      if(nonEmpty) where.append(" AND ");
      where.append("sectionId=");
      where.append(sectionId);
      nonEmpty = true;
    }

    if(nameSet) {
      if(nonEmpty) where.append(" AND ");
      where.append("name=\"");
      where.append(name);
      where.append("\"");
      nonEmpty = true;
    }

    if(descriptionSet) {
      if(nonEmpty) where.append(" AND ");
      where.append("description=\"");
      where.append(description);
      where.append("\"");
      nonEmpty = true;
    }

    String res = where.toString();

    if(nonEmpty) res = " WHERE " + res;

    return res;
  }

  public void insert() {
    try {
      if (rs != null) rs.close();
      if (st != null) st.close();

      Connection tmp = PersistentConnection.getConnection();
      st = tmp.createStatement();

      StringBuffer query = new StringBuffer(100);

      query.append("INSERT INTO Sections(sectionId,name,description) VALUES(");
      query.append(sectionId);
      query.append(",");
      query.append("\"");
      query.append(name);
      query.append("\"");
      query.append(",");
      query.append("\"");
      query.append(description);
      query.append("\"");
      query.append(")");
      st.executeUpdate(query.toString());
    } catch (Exception e) {
      e.printStackTrace(System.err);
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

