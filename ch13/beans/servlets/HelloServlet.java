package com.awl.jspbook.ch13.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class HelloServlet extends HttpServlet {
  private String message;

  public void init(ServletConfig sc) 
    throws ServletException
  {
    super.init(sc);
    message = sc.getInitParameter("message");
    if (message == null)
      message = "Hello, world!";
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
    out.println("<HEAD><TITLE>A servlet</TITLE></HEAD>");
    out.println("<BODY>");
    out.println(message);
    out.println("</BODY>");
    out.println("</HTML>");

    out.close();
  }

  public void destroy() {
    return;
  }
}
