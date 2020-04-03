<HTML>
<HEAD><TITLE>Another counter</TITLE></HEAD>

<BODY>

<% Integer count = (Integer)
   pageContext.getAttribute("count",
                            PageContext.SESSION_SCOPE); %>

<% if (count == null) { %>
   <P>This is your first visit to this page!</P>
   <% count = new Integer(1); %>
<% } else { %>
   <P>You have seen this page
   <%= count %> times before </P>
   
   pageContext.setAttribute("count",
                            new Integer(count.intValue()+1),
                            PageContext.SESSION_SCOPE); %>
<% } %>

</BODY>
</HTML>