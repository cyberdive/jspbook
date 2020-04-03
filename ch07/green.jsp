<HTML>

<BODY BGCOLOR="#00FF00">

<H1>Welcome to the green page</H1>

Your favorite number is
<%= request.getAttribute("favorite") %>

Here is the full list of attributes:

<TABLE BORDER="1">
  <TR><TH>Name</TH><TH>Value</TH></TR>

  <% java.util.Enumeration e = request.getAttributeNames(); %>
  <% while(e.hasMoreElements()) { %>
    <% String name = (String) e.nextElement(); %>
    <TR>
      <TD><%= name %></TD>
      <TD><%= request.getAttribute(name) %></TD>
    </TR>
  <% } %>

</TABLE>


</BODY>
</HTML>
