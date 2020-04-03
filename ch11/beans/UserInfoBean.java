package com.awl.jspbook.ch11;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.*;

public class UserInfoBean implements java.io.Serializable {
  public static final Integer ONE = new Integer(1);

  private String name;
  private String password;
  private HttpServletRequest request;

  private int authors[];
  private int sections[];
  private boolean wantsquiz;
  private String  wantsQuizBugFix;
  private Hashtable interests;
  private int       mostInterestingKeywordId;
  private int       mostInterestingKeywordScore;
  private String    email;

  private int     userid;
  private boolean loggedIn;
  private String  style;
  private String  color;

  public void setStyle(String style) {this.style=style.trim();}
  public void setColor(String color) {
    this.color=color.trim();
    if(this.color.equals("reds"))        colorId = 0;
    else if(this.color.equals("greens")) colorId = 1;
    else if(this.color.equals("blues"))  colorId = 2;
    else if(this.color.equals("greys"))  colorId = 3;
  }

  /* Reds, Greens, Blues, Greys */
  private static String bgColors[] = 
  {"#110000","#001100","#000011","#111111"};

  private static String headBgColors[] = 
  {"#770000","#007700","#000077","#777777"};

  private static String navBgColors[] = 
  {"#770000","#007700","#000077","#777777"};

  private static String textColors[] = 
  {"#FF0000","#00FF00","#0000FF","#FFFFFF"};

  private static String linkColors[] = 
  {"#AA0000","#00AA00","#0000AA","#AAAAAA"};

  private static String vlinkColors[] = 
  {"#AA0000","#00AA00","#0000AA","#AAAAAA"};

  private int colorId = 3;

  public String getBgColor()      {return bgColors[colorId];}
  public String getHeadBgColor()  {return headBgColors[colorId];}
  public String getNavBgColor()   {return navBgColors[colorId];}
  public String getTextColor()    {return textColors[colorId];}
  public String getLinkColor()    {return linkColors[colorId];}
  public String getVlinkColor()   {return vlinkColors[colorId];}


  public String getColor() {return color;}
  public String getStyle() {return style;}

  public String getEmail() {return email;}
  public void setEmail(String email) {this.email = email;}

  public UserInfoBean() {
    loggedIn  = false;
    wantsquiz = true;
    style     = "navleft";
    color     = "greys";
    interests = new Hashtable();
  }

  public void setRequest(Object request) {
    this.request = (HttpServletRequest) request;
    name         = "user from " + this.request.getRemoteHost();
  }

  public void setName(String name) {this.name = name;}
  public String getName() {return name;}

  public void setPassword(String password) {this.password = password;}
  public String getPassword() {return password;}

  public void setWantsQuizBugFix(String b) {
    wantsquiz = b.equals("true");
  }
  public void setWantsQuiz(boolean b) {wantsquiz = b;}
  public boolean getWantsQuiz() {return wantsquiz;}

  public boolean isLoggedIn() {return loggedIn;}

  public void select() {
    String query     = "SELECT * from users";
    String where     = "";
    boolean hasWhere = false;
    Vector tmp       = new Vector();
    int i;

    if(name != null) {
      hasWhere = true;
      where = where + "AND name = '" + name + "'";
    }

    if(password != null) {
      hasWhere = true;
      where = where + "AND password = '" + password + "'";
    }
    
    if(hasWhere) {
      query = query + " WHERE " + where.substring(4);
    }

    try {
      Statement st = PersistentConnection.getConnection().createStatement();
      ResultSet r  = st.executeQuery(query);

      if(r.next()) {
	loggedIn  = true;
	userid    = r.getInt("userid");
	color     = r.getString("color").trim();
	style     = r.getString("style").trim();
	wantsquiz = r.getString("wantsquiz").trim().toLowerCase().equals("y");
	email     = r.getString("email");
	r.close();

	r = st.executeQuery("SELECT sectionid from usersections " +
			    "WHERE userid = " + userid);
	while(r.next())
	  tmp.addElement(new Integer(r.getInt("sectionid")));

	sections = new int[tmp.size()];
	for(i=0;i<tmp.size();i++) {
	  sections[i] = ((Integer) tmp.elementAt(i)).intValue();
	}

	tmp.removeAllElements();
	r.close();

	r = st.executeQuery("SELECT authorid from userauthors " +
			    "WHERE userid = " + userid);
	while(r.next())
	  tmp.addElement(new Integer(r.getInt("authorid")));

	authors = new int[tmp.size()];
	for(i=0;i<tmp.size();i++) {
	  authors[i] = ((Integer) tmp.elementAt(i)).intValue();
	}

	tmp.removeAllElements();
	r.close();
	st.close();

	initializeInterests();
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
  }

  public boolean nameInUse() {
    boolean res = true;

    try {
      Statement st = PersistentConnection.getConnection().createStatement();
      ResultSet r  = st.executeQuery("SELECT * from users where name = '" +
				     name + "';");

      res = r.next();
      r.close();
      st.close();
    } catch (Exception e) {
      System.err.println("Unable to get user info");
      e.printStackTrace(System.err);
    }

    return res;
  }

  public boolean wantsSection(int section) {
    if (!loggedIn || sections == null) return true;

    for(int i=0;i<sections.length;i++) {
      if(sections[i] == section) return false;
    }
    return true;
  }

  public boolean wantsAuthor(int authorId) {
    if (!loggedIn || authors == null) return true;

    for(int i=0;i<authors.length;i++)
      if(authors[i] == authorId) return false;

    return true;
  }

  public boolean wantsArticle(int sectionId,int authorId) {
    if (!loggedIn) return true;

    if(sections != null) {
      for(int i=0;i<sections.length;i++)
	if(sections[i] == sectionId) return false;
    }

    if(authors != null) {
      for(int j=0;j<authors.length;j++)
	if(authors[j] == authorId) return false;
    }

    return true;
  }


  /** This needs to get all authors, then remove unwanted */
  public void setAuthors(String authorsS[]) {
    int tmp[] = new int[authorsS.length];
    Vector v  = new Vector();
    int i;

    for (i=0;i<tmp.length;i++) {
      try {
	tmp[i] = Integer.parseInt(authorsS[i].trim());
      } catch (NumberFormatException e) {
	tmp[i] = -1;
      }
    }

    try {
      Statement st = PersistentConnection.getConnection().createStatement();
      ResultSet r  = st.executeQuery("SELECT authorid FROM authors");

      while(r.next()) {
	boolean listed = false;
	int authId     = r.getInt("authorId");

	for(i=0;i<tmp.length && !listed;i++) {
	  listed = (tmp[i] == authId);
	}
      
	if(!listed) v.addElement(new Integer(authId));
      }

      r.close();

    } catch (Exception e) {
      System.out.println("Unable to set authors");
      e.printStackTrace();
    }

    authors = new int[v.size()];
    for(i=0;i<authors.length;i++) {
      authors[i] = ((Integer) v.elementAt(i)).intValue();
    }
  }


  public void insert() {
    try {
      Statement st = PersistentConnection.getConnection().createStatement();

      st.executeUpdate("INSERT INTO Users(name,password,style,color,wantsquiz) " +
		       "VALUES('" + name + "','" + 
		       password + "','navright','blues','y')");

      ResultSet r  = st.executeQuery("SELECT userid FROM users WHERE " +
				     "name = '" + name + "'");

      if (r.next())
	userid = r.getInt("userid");

      loggedIn = true;

      r.close();
      st.close();
    } catch (Exception e) {
      System.out.println("Unable to insert");
      e.printStackTrace();
    }
  }


  /** This needs to get all sections, then remove unwanted */
  public void setSections(String sectionsS[]) {
    int  s[]      = new int[sectionsS.length];
    Vector v      = new Vector();
    int sectIds[] = SectionHolder.getIds();

    int i,j;

    for (i=0;i<sectionsS.length;i++) {
      try {
	s[i] = Integer.parseInt(sectionsS[i].trim());
      } catch (NumberFormatException e) {
	s[i] = -1;
      }
    }

    for(i=0;i<sectIds.length;i++) {
      boolean listed = false;

      for(j=0;j<s.length && !listed;j++) {
	listed = (sectIds[i] == s[j]);
      }
      
      if(!listed) v.addElement(new Integer(sectIds[i]));
    }

    sections = new int[v.size()];
    for(i=0;i<sections.length;i++) {
      sections[i] = ((Integer) v.elementAt(i)).intValue();
    }
  }

  public void update() {
    int i;

    try {
      Statement st = PersistentConnection.getConnection().createStatement();
      
      st.executeUpdate("DELETE from UserSections WHERE userid = " + userid);
      st.executeUpdate("DELETE from UserAuthors WHERE userid = " + userid);

      for(i=0;i<sections.length;i++) 
	st.executeUpdate("INSERT INTO UserSections VALUES("
			 + userid + "," + sections[i] + ")");

      for(i=0;i<authors.length;i++) 
	st.executeUpdate("INSERT INTO UserAuthors VALUES("
			 + userid + "," + authors[i] + ")");

      st.executeUpdate("UPDATE users SET style = '" + style + 
		       "', color = '" + color + 
		       "', wantsquiz = '" + (wantsquiz ? "y" : "n") +
		       "' WHERE userid = " + userid);
		       

      st.close();
    } catch (Exception e) {
      System.err.println("Unable to update");
      e.printStackTrace();
    }
  }

  /**
   * Initializes the interests hashtable with info from the 
   * database.
   */
  private void initializeInterests() {
    interests                   = new Hashtable();
    mostInterestingKeywordScore = -1;
    mostInterestingKeywordId    = 0;

    try {
      String query = "SELECT * FROM userinterests WHERE userid = " +
	             userid;

      Statement st = PersistentConnection.getConnection().createStatement();
      ResultSet r  = st.executeQuery(query);

      while(r.next()) {
	int keywordid = r.getInt("keywordid");
	int score     = r.getInt("score");

	interests.put(new Integer(keywordid),new Integer(score));

	/* See if this is the keyword the user is most interested in */
	if(score > mostInterestingKeywordScore)
	  mostInterestingKeywordId = keywordid;
      }

      r.close();
      st.close();
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
  }



  /**
   * flags that the user is interested in this article.  This looks
   * up all keywords associated with the article, and increments
   * the count for each in the hastable.
   */
  public void setArticleId(int articleId) {
    String query = "select * from articlekeywords where articleid=" +
                   articleId;

    try {
      Statement st = PersistentConnection.getConnection().createStatement();
      ResultSet r  = st.executeQuery(query);

      while(r.next()) {
	int keywordid     = r.getInt("keywordid");
	Integer KeywordId = new Integer(keywordid);
	Integer oldValue  = (Integer) interests.get(KeywordId);
	int newValue      = 1;

	if(oldValue == null) {
	  interests.put(KeywordId,ONE);
	} else {
	  newValue = oldValue.intValue() + 1;
	  interests.put(KeywordId,new Integer(newValue));
	}

	if(newValue > mostInterestingKeywordScore) {
	  mostInterestingKeywordId    = keywordid;
	  mostInterestingKeywordScore = newValue;
	}
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
  }


  /**
   * Indicates whether user is interested in a given article.
   * finds the keyword with the current highest score,
   * if the article has that keyword, then it is marked as
   * of interest.
   */
  public boolean interestedIn(int articleId) {
    String query = "select * from articlekeywords where articleid=" +
                   articleId;

    try {
      Statement st = PersistentConnection.getConnection().createStatement();
      ResultSet r  = st.executeQuery(query);

      while(r.next()) {
	if(r.getInt("keywordid") == mostInterestingKeywordId) return true;
      }

      st.close();
    } catch (Exception e) {
    }

    return false;
  }
}
