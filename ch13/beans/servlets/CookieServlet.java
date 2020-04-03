package com.awl.jspbook.ch13.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class CookieServlet extends HttpServlet {
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
    res.setStatus(res.SC_OK);
    res.setContentType("text/html");
    
    PrintWriter out = res.getWriter();

    out.println("<HTML>");
    out.println("<HEAD><TITLE>Cookies</TITLE></HEAD>");
    out.println("<BODY>");

    Cookie cookies[] = req.getCookies();

    if(cookies == null || cookies.length == 0) {
      out.println("You have no cookies");
    } else {
      out.println("<TABLE>");

      out.println("<TR>");
      out.println("<TH>Name</TH>");
      out.println("<TH>Domain</TH>");
      out.println("<TH>Path</TH>");
      out.println("<TH>Value</TH>");
      out.println("<TH>Max Age</TH>");
      out.println("</TR>");

      for(int i=0;i<cookies.length;i++) {
	out.println("<TR>");
        out.println("<TD>" + cookies[i].getName() + "</TD>");
        out.println("<TD>" + cookies[i].getDomain() + "</TD>");
        out.println("<TD>" + cookies[i].getPath() + "</TD>");
        out.println("<TD>" + cookies[i].getValue() + "</TD>");
        out.println("<TD>" + cookies[i].getMaxAge() + "</TD>");
	out.println("</TR>");
      }
    }

    out.println("</TABLE>");

    if(req.isRequestedSessionIdValid()) {
      if(req.isRequestedSessionIdFromCookie()) {
	out.println("This session is from a cookie");
      }

      if(req.isRequestedSessionIdFromURL()) {
	out.println("This session is from the URL");
      }
    } else {
      out.println("There is no session associated ");
      out.println("with this request");
    }

    out.println("</BODY>");
    out.println("</HTML>");

    out.close();
  }
}
