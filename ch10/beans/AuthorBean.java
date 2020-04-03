package com.awl.jspbook.ch10;

import java.sql.*;

public class AuthorBean {
  private String orderBy     = "";
  private Statement st = null;
  private ResultSet rs;

  public void setOrderBy(String orderBy) {
    this.orderBy = orderBy;
  }

  private int authorId;
  private boolean authorIdSet = false;

  public String getAuthorId() {
    if(rs == null) return "0";

    try {
      return "" + rs.getInt("authorId");
    } catch(Exception e) {
      e.printStackTrace(System.err);
    }
    return "0";
  }

  public void setAuthorId(String authorId) {
    this.authorId = Integer.parseInt(authorId.trim());
    this.authorIdSet = true;
  }

  private String firstName;
  private boolean firstNameSet = false;

  public String getFirstName() {
    if(rs == null) return null;

    try {
      return rs.getString("firstName");
    } catch(Exception e) {
      e.printStackTrace(System.err);
    }
    return null;
  }

  public String getFirstNameURLEncoded() {
    if(rs == null) return null;

    try {
      return rs.getString("firstName").replace(' ','+');
    } catch(Exception e) {
      e.printStackTrace(System.err);
    }
    return null;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
    this.firstNameSet = true;
  }

  private String lastName;
  private boolean lastNameSet = false;

  public String getLastName() {
    if(rs == null) return null;

    try {
      return rs.getString("lastName");
    } catch(Exception e) {
      e.printStackTrace(System.err);
    }
    return null;
  }

  public String getLastNameURLEncoded() {
    if(rs == null) return null;

    try {
      return rs.getString("lastName").replace(' ','+');
    } catch(Exception e) {
      e.printStackTrace(System.err);
    }
    return null;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
    this.lastNameSet = true;
  }

  private String email;
  private boolean emailSet = false;

  public String getEmail() {
    if(rs == null) return null;

    try {
      return rs.getString("email");
    } catch(Exception e) {
      e.printStackTrace(System.err);
    }
    return null;
  }

  public String getEmailURLEncoded() {
    if(rs == null) return null;

    try {
      return rs.getString("email").replace(' ','+');
    } catch(Exception e) {
      e.printStackTrace(System.err);
    }
    return null;
  }

  public void setEmail(String email) {
    this.email = email;
    this.emailSet = true;
  }

  private String password;
  private boolean passwordSet = false;

  public String getPassword() {
    if(rs == null) return null;

    try {
      return rs.getString("password");
    } catch(Exception e) {
      e.printStackTrace(System.err);
    }
    return null;
  }

  public String getPasswordURLEncoded() {
    if(rs == null) return null;

    try {
      return rs.getString("password").replace(' ','+');
    } catch(Exception e) {
      e.printStackTrace(System.err);
    }
    return null;
  }

  public void setPassword(String password) {
    this.password = password;
    this.passwordSet = true;
  }

  private String bio;
  private boolean bioSet = false;

  public String getBio() {
    if(rs == null) return null;

    try {
      return rs.getString("bio");
    } catch(Exception e) {
      e.printStackTrace(System.err);
    }
    return null;
  }

  public String getBioURLEncoded() {
    if(rs == null) return null;

    try {
      return rs.getString("bio").replace(' ','+');
    } catch(Exception e) {
      e.printStackTrace(System.err);
    }
    return null;
  }

  public void setBio(String bio) {
    this.bio = bio;
    this.bioSet = true;
  }

  public void select() {
    try {
      if (rs != null) rs.close();
      if (st != null) st.close();

      Connection tmp = PersistentConnection.getConnection();
      st = tmp.createStatement();

      String query = "SELECT * FROM authors";
      String where = buildWhere();
      
      rs = st.executeQuery(query + where + " " + orderBy);

      authorIdSet = false;
      firstNameSet = false;
      lastNameSet = false;
      emailSet = false;
      passwordSet = false;
      bioSet = false;

    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
  }

  private String buildWhere() {
    StringBuffer where = new StringBuffer(20);
    boolean nonEmpty   = false;

    if(authorIdSet) {
      if(nonEmpty) where.append(" AND ");
      where.append("authorId=");
      where.append(authorId);
      nonEmpty = true;
    }

    if(firstNameSet) {
      if(nonEmpty) where.append(" AND ");
      where.append("firstName='");
      where.append(firstName);
      where.append("'");
      nonEmpty = true;
    }

    if(lastNameSet) {
      if(nonEmpty) where.append(" AND ");
      where.append("lastName='");
      where.append(lastName);
      where.append("'");
      nonEmpty = true;
    }

    if(emailSet) {
      if(nonEmpty) where.append(" AND ");
      where.append("email='");
      where.append(email);
      where.append("'");
      nonEmpty = true;
    }

    if(passwordSet) {
      if(nonEmpty) where.append(" AND ");
      where.append("password='");
      where.append(password);
      where.append("'");
      nonEmpty = true;
    }

    if(bioSet) {
      if(nonEmpty) where.append(" AND ");
      where.append("bio='");
      where.append(bio);
      where.append("'");
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

      query.append("INSERT INTO Authors VALUES(");
      query.append(authorId);
      query.append(",");
      query.append("'");
      query.append(firstName);
      query.append("'");
      query.append(",");
      query.append("'");
      query.append(lastName);
      query.append("'");
      query.append(",");
      query.append("'");
      query.append(email);
      query.append("'");
      query.append(",");
      query.append("'");
      query.append(password);
      query.append("'");
      query.append(",");
      query.append("'");
      query.append(bio);
      query.append("'");
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

