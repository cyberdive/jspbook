package com.awl.jspbook.ch13.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Counter2 extends HttpServlet {
  private static final Integer ONE = new Integer(1);

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
    HttpSession theSession = req.getSession();
    Integer count = (Integer) theSession.getAttribute("count");

    res.setStatus(res.SC_OK);
    res.setContentType("text/html");
    
    PrintWriter out = res.getWriter();

    out.println("<HTML>");
    out.println("<HEAD><TITLE>A Counter</TITLE></HEAD>");
    out.println("<BODY>");

    if(count == null) {
      out.println("This is your first visit to this page!");
      count = ONE;
    } else {
      out.println("You have seen this page ");
      out.println(count);
      out.println(" times before");
    }

    theSession.setAttribute("count",
			    new Integer(count.intValue() + 1));

    out.println("</BODY>");
    out.println("</HTML>");

    out.close();
  }
}
