<HTML>

<BODY BGCOLOR="#FFFFFF">

<P>
You answered 
"<%= request.getParameter("met") %>"
when asked if you've met Mr. Gosling.
</P>


<P>
Given the chance, you would ask the following question:
<%= request.getParameter("question") %>
</P>


<% if (request.getParameter("conferences") == null) { %>
  <P>You have never heard him speak at a conference.</P>
<% }else { %>
  <P>
  You heard him speak at a conference called
  <%= request.getParameter("conferences") %>
  </P>
<% } %>

</BODY>
</HTML>



