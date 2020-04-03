<%-- Put the favorite number in the request scope,
      by placing it in the  'favorite' attribute
      of the request --%>

<% request.setAttribute("favorite",
                request.getParameter("favorite")); %>

<%-- now dispatch to the user's requested page --%>
<% String which = request.getParameter("which"); %>

<% if (which.equals("red")) { %>
   <jsp:forward page="/ch07/red.jsp"/>
<% } else if (which.equals("green")) { %>
   <jsp:forward page="/ch07/green.jsp"/>
<% } else if (which.equals("blue")) { %>
   <jsp:forward page="/ch07/blue.jsp"/>
<% } %>

<HTML>
<BODY>
You asked for a page which does not exist!
</BODY>
</HTML>


