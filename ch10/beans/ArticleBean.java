package com.awl.jspbook.ch10;

import java.sql.*;
import java.text.SimpleDateFormat;

public class ArticleBean {
  private String orderBy  = "";
  private Statement st    = null;
  private ResultSet rs;

  private String keywords[];

  public ArticleBean () {
    setPubtime((new java.util.Date()).getTime());
  }

  public void setKeywords(String keywords[]) {
    this.keywords = keywords;
  }

  public void updateKeywords() {
    if(keywords == null) return;

    try {
      if (rs != null) {rs.close(); rs = null;}
      if (st != null) {st.close(); st = null;}
      
      Connection tmp = PersistentConnection.getConnection();
      st = tmp.createStatement();
      
      for (int i=0;i<keywords.length;i++) {
	String query = "INSERT INTO articlekeywords VALUES(" +
	  articleId + "," + keywords[i].trim() + ");";

	st.executeUpdate(query);
      }
      st.close();
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
  }
    
  public void setOrderBy(String orderBy) {
    this.orderBy = "ORDER BY " + orderBy;
  }

  private int articleId;
  private boolean articleIdSet = false;

  public int getArticleId() {
    if(rs == null) return 0;

    try {
      articleId = rs.getInt("articleId");
      return articleId;
    } catch(Exception e) {
      e.printStackTrace(System.err);
    }
    return 0;
  }

  public String getArticleIdString() {
    if(rs == null) return "0";

    try {
      return "" + rs.getInt("articleId");
    } catch(Exception e) {
      e.printStackTrace(System.err);
    }
    return "0";
  }

  public void setArticleId(int articleId) {
    this.articleId = articleId;
    this.articleIdSet = true;
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
    if(sectionId == 0) {
      this.sectionId    = 0;
      this.sectionIdSet = false;
    } else {
      this.sectionId = sectionId;
      this.sectionIdSet = true;
    }
  }

  private int authorId;
  private boolean authorIdSet = false;

  public int getAuthorId() {
    if(rs == null) return 0;

    try {
      return rs.getInt("authorId");
    } catch(Exception e) {
      e.printStackTrace(System.err);
    }
    return 0;
  }

  public void setAuthorId(int authorId) {
    this.authorId = authorId;
    this.authorIdSet = true;
  }

  private long pubtime;
  private boolean pubtimeSet = false;

  public long getPubtime() {
    if(rs == null) return 0;

    try {
      return rs.getLong("pubtime");
    } catch(Exception e) {
      e.printStackTrace(System.err);
    }
    return 0;
  }

  public void setPubtime(long pubtime) {
    this.pubtime = pubtime;
    this.pubtimeSet = true;
  }

  private String headline;
  private boolean headlineSet = false;

  public String getHeadline() {
    if(rs == null) return null;

    try {
      return rs.getString("headline");
    } catch(Exception e) {
      e.printStackTrace(System.err);
    }
    return null;
  }

  public String getHeadlineURLEncoded() {
    if(rs == null) return null;

    try {
      return rs.getString("headline").replace(' ','+');
    } catch(Exception e) {
      e.printStackTrace(System.err);
    }
    return null;
  }

  public void setHeadline(String headline) {
    this.headline = headline.replace('\n',' ');
    this.headlineSet = true;
  }

  private String summary;
  private boolean summarySet = false;

  public String getSummary() {
    if(rs == null) return null;

    try {
      return rs.getString("summary");
    } catch(Exception e) {
      e.printStackTrace(System.err);
    }
    return null;
  }

  public String getSummaryURLEncoded() {
    if(rs == null) return null;

    try {
      return rs.getString("summary").replace(' ','+');
    } catch(Exception e) {
      e.printStackTrace(System.err);
    }
    return null;
  }

  public void setSummary(String summary) {
    this.summary = summary.replace('\n',' ');
    this.summarySet = true;
  }

  private String body;
  private boolean bodySet = false;

  public String getBody() {
    if(rs == null) return null;

    try {
      return rs.getString("body");
    } catch(Exception e) {
      e.printStackTrace(System.err);
    }
    return null;
  }

  public String getBodyURLEncoded() {
    if(rs == null) return null;

    try {
      return rs.getString("body").replace(' ','+');
    } catch(Exception e) {
      e.printStackTrace(System.err);
    }
    return null;
  }

  public void setBody(String body) {
    this.body = body.replace('\n',' ');
    this.bodySet = true;
  }

  public void select() {
    try {
      if (rs != null) {rs.close(); rs = null;}
      if (st != null) {st.close(); st = null;}

      Connection tmp = PersistentConnection.getConnection();
      st = tmp.createStatement();

      String query = "SELECT * FROM Articles";
      String where = buildWhere();

      rs = st.executeQuery(query + where + " " + orderBy);

      rs.next();
      articleIdSet = false;
      sectionIdSet = false;
      authorIdSet = false;
      pubtimeSet = false;
      headlineSet = false;
      summarySet = false;
      bodySet = false;

    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
  }

  private String buildWhere() {
    StringBuffer where = new StringBuffer(20);
    boolean nonEmpty   = false;

    if(articleIdSet) {
      if(nonEmpty) where.append(" AND ");
      where.append("articleId=");
      where.append(articleId);
      nonEmpty = true;
    }

    if(sectionIdSet) {
      if(nonEmpty) where.append(" AND ");
      where.append("sectionId=");
      where.append(sectionId);
      nonEmpty = true;
    }

    if(authorIdSet) {
      if(nonEmpty) where.append(" AND ");
      where.append("authorId=");
      where.append(authorId);
      nonEmpty = true;
    }

    if(headlineSet) {
      if(nonEmpty) where.append(" AND ");
      where.append("headline='");
      where.append(headline);
      where.append("'");
      nonEmpty = true;
    }

    if(summarySet) {
      if(nonEmpty) where.append(" AND ");
      where.append("summary='");
      where.append(summary);
      where.append("'");
      nonEmpty = true;
    }

    if(bodySet) {
      if(nonEmpty) where.append(" AND ");
      where.append("body='");
      where.append(body);
      where.append("'");
      nonEmpty = true;
    }

    String res = where.toString();

    if(nonEmpty) res = " WHERE " + res;

    return res;
  }

  public void insert() {
    try {
      if (rs != null) {rs.close(); rs = null;}
      if (st != null) {st.close(); rs = null;}

      Connection tmp = PersistentConnection.getConnection();
      st = tmp.createStatement();

      StringBuffer query = new StringBuffer(100);

      query.append("INSERT INTO articles(sectionId,authorId,pubtime,headline,summary,body) VALUES(");

      query.append(sectionId);
      query.append(",");
      query.append(authorId);
      query.append(",'");

      SimpleDateFormat sdf = new SimpleDateFormat();
      
      query.append(sdf.format(new java.util.Date()));
      query.append("',");
      query.append("'");
      query.append(headline);
      query.append("'");
      query.append(",");
      query.append("'");
      query.append(summary);
      query.append("'");
      query.append(",");
      query.append("'");
      query.append(body);
      query.append("'");
      query.append(")");
      int tmp2 = st.executeUpdate(query.toString());

      System.err.println("Insert returned " + tmp2);

      sectionIdSet = authorIdSet = articleIdSet = headlineSet = summarySet = bodySet = false;

      st.close();
      st = null;
      PersistentConnection.reset();
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

