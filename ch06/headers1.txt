<HTML>

<BODY>

<% java.util.Enumeration e = request.getHeaderNames(); %>

<P>Here are the names of the headers that have been sent:</P>
<UL>

<% while (e.hasMoreElements()) { %>
<LI> <%= e.nextElement() %>
<% } %>

</UL>


</BODY>
</HTML>
