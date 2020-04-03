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
  <% if (confs.length == 1) {%>
    <P>
    You heard him speak at a conference called
    <%= confs[0] %>.
    </P>
  <% } else if (confs.length == 2) { %>
    <P>
    You heard him speak at a conference called
    <%= confs[0] %>, and one called <%= confs[1] %>.
    </P>
  <% } else { %>
    <P>You have heard him speak at more than 2 conferences.</P>
  <% } %>
<% } %>

</BODY>
</HTML>



