<%! String confs[] = null; %>

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


<% confs = request.getParameterValues("conferences"); %>

<% if (confs == null) { %>
  <P>You have never heard him speak at a conference.</P>
<% } else { %>
  <P>You heard him speak at the following conferences:</P>
  <UL>
  <% for (int i=0;i<confs.length;i++) { %>
    <LI><%= confs[i] %>
  <% } %>

  </UL>
<% } %>

</BODY>
</HTML>



