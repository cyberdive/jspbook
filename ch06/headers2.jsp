<HTML>

<BODY>

<% java.util.Enumeration e = request.getHeaderNames(); %>

<P>Here are the names and values of all the headers that have 
been sent:</P> <UL>

<TABLE BORDER="1">

<TR><TH>Name</TH><TH>Value</TH><TR>

<% while (e.hasMoreElements()) { %>
   <% String name = (String) e.nextElement(); %>

   <TR>
     <TD><%= name %></TD>
     <TD><%= request.getHeader(name) %></TD>
   </TR>

<% } %>

</TABLE>
</BODY>
</HTML>
