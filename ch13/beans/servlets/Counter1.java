package com.awl.jspbook.ch13.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Counter1 extends HttpServlet {
  private int count;
  
  public void init(ServletConfig sc) 
    throws ServletException
  {
    super.init(sc);
    count = 0;
  }

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
    out.println("<HEAD><TITLE>A Counter</TITLE></HEAD>");
    out.println("<BODY>");
    out.println("This page has been accessed ");
    out.println(count);
    out.println(" times");
    out.println("</BODY>");
    out.println("</HTML>");

    count++;
    out.close();
  }
}
