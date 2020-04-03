package com.awl.jspbook.ch09;

import java.sql.*;

import java.net.URLEncoder;

public class TrackBean {
  private String name;
  private int    length;
  private int    albumId;

  private boolean albumIdSet = false;
  private boolean nameSet    = false;
  private boolean lengthSet  = false;

  private Statement st = null;
  private ResultSet rs;

  public void setName(String name) {
    this.name = name;
    nameSet   = true;
  }

  public void setLength(int length) {
    this.length = length;
    lengthSet   = true;
  }

  public void setAlbumId(int albumId) {
    this.albumId = albumId;
    albumIdSet   = true;
  }

  public void select() {
    try {
      if (rs != null) rs.close();
      if (st != null) st.close();

      Connection tmp = PersistentConnection.getConnection();
      st = tmp.createStatement();

      String query = "SELECT * FROM Track ";
      String where = "";
      
      if(nameSet)
	where = where + " AND name = \"" + name + "\" ";
      
      if(lengthSet)
	where = where + " AND length = " + length + " ";
      
      if(albumIdSet)
	where = where + " AND albumId = " + albumId + " ";
      
      if(!where.equals("")) where = " WHERE " + where.substring(4);
      
      rs = st.executeQuery(query + where);
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

  public String getName() {
    if(rs == null) return null;

    try {
      return rs.getString("name");
    } catch (Exception e) {
      e.printStackTrace(System.err);
      return null;
    }
  }

  public String getNameURLEncoded() {
    if(rs == null) return null;

    try {
      return URLEncoder.encode(rs.getString("name"));
    } catch (Exception e) {
      e.printStackTrace(System.err);
      return null;
    }
  }


  public int getLength() {
    if(rs == null) return 0;

    try {
      return rs.getInt("length");
    } catch(Exception e) {
      e.printStackTrace(System.err);
      return 0;
    }
  }


  public int getAlbumId() {
    if(rs == null) return 0;

    try {
      return rs.getInt("albumId");
    } catch(Exception e) {
      e.printStackTrace(System.err);
      return 0;
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
