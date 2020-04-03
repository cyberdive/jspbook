package com.awl.jspbook.ch09;

import java.sql.*;

import java.net.URLEncoder;

public class CDBean {
  private String name;
  private int artistid;
  private int albumId;

  private boolean nameSet    = false;
  private boolean artistSet  = false;
  private boolean albumIdSet = false;

  private String orderBy     = "";

  private Statement st = null;
  private ResultSet rs;


  /**
   * Sets the orderBy field, which changes the 
   * order in which the results are returned
   */
  public void setOrderBy(String orderBy) {
    this.orderBy = orderBy;
  }

  /**
   * Sets the name field, and indicate that it changed
   */
  public void setName(String name) {
    this.name = name;
    nameSet   = true;
  }

  /**
   * Sets the artist field, and indicate that it changed
   */
  public void setArtistId(int artistid) {
    this.artistid = artistid;
    artistSet     = true;
  }

  /**
   * Sets the albumId field, and indicate that it changed
   */
  public void setAlbumId(int albumId) {
    this.albumId = albumId;
    albumIdSet   = true;
  }

  /**
   * Do a select, based on which fields have been set
   * then reset all the change indicators
   */
  public void select() {
    try {
      if (rs != null) rs.close();
      if (st != null) st.close();

      Connection tmp = PersistentConnection.getConnection();
      st = tmp.createStatement();

      String query = "SELECT * FROM cd ";
      String where = buildWhere();
      
      rs = st.executeQuery(query + where + " " + orderBy);

      albumIdSet = false;
      nameSet    = false;
      artistSet  = false;
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
  }

  /**
   * Does an insert, creating a new row from all
   * current values.
   */
  public void insert() {
    try {
      if (rs != null) rs.close();
      if (st != null) st.close();

      Connection tmp = PersistentConnection.getConnection();
      st = tmp.createStatement();

      StringBuffer query = new StringBuffer(100);

      query.append("INSERT INTO cd VALUES(");
      query.append(albumId);
      query.append(",");
      query.append(artistid);
      query.append(",\"");
      query.append(name);
      query.append("\")");

      st.executeUpdate(query.toString());
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
  }

  /**
   * Does an update, changing all fields, using the 
   * albumId as primary key
   */
  public void update() {
    try {
      if (rs != null) rs.close();
      if (st != null) st.close();

      Connection tmp = PersistentConnection.getConnection();
      st = tmp.createStatement();

      StringBuffer query = new StringBuffer(100);

      query.append("UPDATE cd ");
      
      if(nameSet) {
	query.append(" SET name = \"");
	query.append(name);
	query.append("\" ");
      }

      if(artistSet) {
	query.append(" SET artistid = ");
	query.append(artistid);
	query.append(" ");
      }


      query.append("WHERE albumid=");
      query.append(albumId);

      st.executeUpdate(query.toString());
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
  }


  /**
   * Constructs a where clause from the currently
   * set fields
   */
  private String buildWhere() {
    StringBuffer where = new StringBuffer(20);
    boolean nonEmpty    = false;

    if(nameSet) {
      where.append("name = \"");
      where.append(name);
      where.append("\" ");
      nonEmpty = true;
    }
    
    if(artistSet) {
      if(nonEmpty) where.append(" AND");
      where.append(" artistid = ");
      where.append(artistid);
      where.append(" ");
      nonEmpty = true;
    }

    if(albumIdSet) {
      if(nonEmpty) where.append(" AND");
      where.append(" albumId = ");
      where.append(albumId);
      nonEmpty = true;
    }

    String res = where.toString();

    if(nonEmpty) res = " WHERE " + res;

    return res;
  }     

  /**
   * Goes to the next row
   */
  public boolean next() {
    if(rs == null) return false;
    try {
      return rs.next();
    } catch (Exception e) {
      e.printStackTrace(System.err);
      return false;
    }
  }

  /**
   * Gets the name field from the current row
   */
  public String getName() {
    if(rs == null) return null;

    try {
      return rs.getString("name");
    } catch (Exception e) {
      e.printStackTrace(System.err);
      return null;
    }
  }

  /**
   * Gets the artist field from the current row
   */
  public int getArtistId() {
    if(rs == null) return 0;

    try {
      return rs.getInt("artistid");
    } catch(Exception e) {
      e.printStackTrace(System.err);
      return 0;
    }
  }


  /**
   * Gets a URL-encoded version of the name field.
   */
  public String getNameURLEncoded() {
    if(rs == null) return null;

    try {
      return URLEncoder.encode(rs.getString("name"));
    } catch (Exception e) {
      e.printStackTrace(System.err);
      return null;
    }
  }

  /**
   * Gets the albumId field from the current row
   */
  public int getAlbumId() {
    if(rs == null) return 0;

    try {
      return rs.getInt("albumId");
    } catch(Exception e) {
      e.printStackTrace(System.err);
      return 0;
    }
  }

  /**
   * Cleans up by closing all open
   * objects.
   */
  public void cleanup() {
    try {
      if (rs != null) rs.close();
      if (st != null) st.close();
    } catch (Exception e) {
    }
  }
}
