package com.awl.jspbook.ch10;

import java.sql.*;

public class KeywordBean {
  private String orderBy     = "";
  private Statement st = null;
  private ResultSet rs;

  public void setOrderBy(String orderBy) {
    this.orderBy = orderBy;
  }

  private int keywordId;
  private boolean keywordIdSet = false;

  public int getKeywordId() {
    if(rs == null) return 0;

    try {
      return rs.getInt("keywordId");
    } catch(Exception e) {
      e.printStackTrace(System.err);
    }
    return 0;
  }

  public void setKeywordId(int keywordId) {
    this.keywordId = keywordId;
    this.keywordIdSet = true;
  }

  private String keyword;
  private boolean keywordSet = false;

  public String getKeyword() {
    if(rs == null) return null;

    try {
      return rs.getString("keyword");
    } catch(Exception e) {
      e.printStackTrace(System.err);
    }
    return null;
  }

  public String getKeywordURLEncoded() {
    if(rs == null) return null;

    try {
      return rs.getString("keyword").replace(' ','+');
    } catch(Exception e) {
      e.printStackTrace(System.err);
    }
    return null;
  }

  public void setKeyword(String keyword) {
    this.keyword = keyword;
    this.keywordSet = true;
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

      String query = "SELECT * FROM keywords";
      String where = buildWhere();
      
      rs = st.executeQuery(query + where + " " + orderBy);

      keywordIdSet = false;
      keywordSet = false;
      descriptionSet = false;

    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
  }

  private String buildWhere() {
    StringBuffer where = new StringBuffer(20);
    boolean nonEmpty   = false;

    if(keywordIdSet) {
      if(nonEmpty) where.append(" AND ");
      where.append("keywordId=");
      where.append(keywordId);
      nonEmpty = true;
    }

    if(keywordSet) {
      if(nonEmpty) where.append(" AND ");
      where.append("keyword=\"");
      where.append(keyword);
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

      StringBuffer query = new StringBuffer(110);

      query.append("INSERT INTO Keywords(keywordId,keyword,description) VALUES(");
      query.append(keywordId);
      query.append(",");
      query.append("\"");
      query.append(keyword);
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

