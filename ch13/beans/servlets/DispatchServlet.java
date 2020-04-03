package com.awl.jspbook.ch13.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class DispatchServlet extends HttpServlet {
  public void doGet(HttpServletRequest req,
		     HttpServletResponse res)
    throws IOException,ServletException
  {
    ServletContext sc    = getServletContext();
    RequestDispatcher rd;

    String which = req.getParameter("which");

    if(which != null) {
      if(which.equals("red")) {
	rd = sc.getRequestDispatcher("/ch07/red.jsp");
	rd.forward(req,res);
      } else if(which.equals("green")) {
	rd = sc.getRequestDispatcher("/ch07/green.jsp");
	rd.forward(req,res);
      } else if(which.equals("blue")) {
	rd = sc.getRequestDispatcher("/ch07/blue.jsp");
	rd.forward(req,res);
      } else {
	res.sendError(res.SC_INTERNAL_SERVER_ERROR,
		      "A page was requested that does exist!");
      }
    } else {
      res.sendError(res.SC_INTERNAL_SERVER_ERROR,
		    "No destination page was specified!");
    }
  }
}
