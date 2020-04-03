package com.awl.jspbook.ch13.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ResponseServlet extends HttpServlet {
  public void doGet(HttpServletRequest req,
		     HttpServletResponse res)
    throws IOException,ServletException
  {
    handle(req,res);
  }


  public void doPost(HttpServletRequest req,
		     HttpServletResponse res)
    throws IOException,ServletException
  {
    handle(req,res);
  }
    

  public void handle(HttpServletRequest req,
		     HttpServletResponse res)
    throws IOException,ServletException
  {
    StringBuffer text = new StringBuffer();

    String name  = req.getParameter("name");
    String value = req.getParameter("value");

    if(name == null) {
      name = "Acookie";
    }

    if(value == null) {
      value = "AcookieValue";
    }

    text.append("<HTML>");
    text.append("<HEAD><TITLE>A servlet</TITLE></HEAD>");
    text.append("<BODY>");
    text.append("<P>Added a cookie whose name is: ");
    text.append(name);
    text.append(" with a value of: ");
    text.append(value);
    text.append("</P>");
    text.append("<FORM ACTION=\"response\" METHOD=\"GET\">");
    text.append("<P>Name: <INPUT TYPE=\"TEXT\" NAME=\"name\"></P>");
    text.append("<P>Value: <INPUT TYPE=\"TEXT\" NAME=\"value\"></P>");
    text.append("<P><INPUT TYPE=\"SUBMIT\"></P>");
    text.append("</FORM>");
    text.append("</BODY>");
    text.append("</HTML>");

    String html = text.toString();

    res.setStatus(res.SC_OK);
    res.setContentType("text/html");
    res.setContentLength(html.length());

    Cookie cookie = new Cookie(name,value);
    cookie.setMaxAge((int) System.currentTimeMillis() +
		     1000 * 60 * 10);
    res.addCookie(cookie);
    
    PrintWriter out = res.getWriter();
    out.print(html);
    out.close();
  }
}
