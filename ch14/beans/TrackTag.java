package com.awl.jspbook.ch14;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.Hashtable;
import java.io.Writer;
import java.io.IOException;
import java.sql.*;

public class TrackTag implements Tag, BodyTag {
  private BodyContent bodyOut;
  private PageContext pageContext;
  private Tag parent;
  
  private Connection theConnection;
  private Statement  theStatement;
  private ResultSet  results;
  private String     cd;
  private boolean anyRows = false;

  
  public void setCD(String cd) {this.cd = cd;}
  
  public void setParent(Tag parent) {
    this.parent = parent;
  }
  
  public void setBodyContent(BodyContent bodyOut) {
    this.bodyOut = bodyOut;
  }
  
  public void setPageContext(PageContext pageContext) {
    this.pageContext = pageContext;
  }
  
  public Tag getParent() {
    return this.parent;
  }
    
  public int doStartTag() {
    try {
      Class.forName("postgresql.Driver");
      theConnection = DriverManager.getConnection (
			"jdbc:postgresql:jspbook",
			"dbuser",
			"dbuser");
      theStatement  = theConnection.createStatement();
      results       = theStatement.executeQuery(
 	                "SELECT track.name,track.length " +
			"FROM track,cd " + 
			"WHERE cd.albumid=track.albumid " +
			"AND cd.name = '" +
			cd + "'");
    } catch (Exception e) {
      System.err.println("Unable to connect to DB");
      e.printStackTrace();
      return SKIP_BODY;
    }
    return EVAL_BODY_TAG;
  }
  
  public int doEndTag() throws JspException {
    return EVAL_PAGE;
  }
  
  
  public void doInitBody() throws JspError {
    try {
      if(results.next()) {
	pageContext.setAttribute(
			"name", 
		        results.getString("name"));
	pageContext.setAttribute(
			"length",
			new Integer(results.getInt("length")));
	anyRows = true;
      }
    } catch (Exception e) {
      e.printStackTrace();
      throw new JspError("Unable to get data");
    }
  }
  
  public void release() {
    bodyOut     = null;
    pageContext = null;
    parent      = null;
    try {
      results.close();
      theStatement.close();
      theConnection.close();
    } catch (Exception e) {}
    results       = null;
    theStatement  = null;
    theConnection = null;
  }
  
  public int doAfterBody() throws JspError {
    try {
      if(!results.next()) {
	if (anyRows) 
	  bodyOut.writeOut(bodyOut.getEnclosingWriter());
	return SKIP_BODY;
      } else {
	pageContext.setAttribute(
			    "name", 
			    results.getString("name"));
	pageContext.setAttribute(
			    "length",
			    new Integer(results.getInt("length")));
	anyRows = true;
	return EVAL_BODY_TAG;
      }
    } catch (Exception e) {
      return SKIP_BODY;
    }
  }
}
