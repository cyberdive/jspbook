package com.awl.jspbook.ch13.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.beans.*;

public class CDInfo extends HttpServlet {
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
    AlbumInfo tinderbox;

    res.setStatus(res.SC_OK);
    res.setContentType("text/html");
    
    PrintWriter out = res.getWriter();

    try {
      tinderbox = (AlbumInfo) Beans.instantiate(
				    getClass().getClassLoader(),
				    "tinderbox13");
    } catch (Exception e) {
      tinderbox = null;
    }


    out.println("<HTML>");
    out.println("<HEAD><TITLE>Album Info</TITLE></HEAD>");
    out.println("<BODY>");

    if(tinderbox == null) {
      out.println("The bean could not be found or loaded");
    } else {
      out.println("<P>Album name: "
		  + tinderbox.getName() + "</P>");

      String tracks[] = tinderbox.getTracks();

      out.println("<P>Tracks:</P>");
      out.println("<OL>");
      for(int i=0;i<tracks.length;i++) {
	out.println("<LI>" + tracks[i]);
      }
      out.println("</OL>");
    }

    out.println("</BODY>");
    out.println("</HTML>");

    out.close();
  }
}
