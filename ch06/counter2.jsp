<%! int count =0; %>

<HTML>

<HEAD><TITLE>A Counter</TITLE></HEAD>

<BODY>
<% count = count + 1; %>

<% if (count == 1) { %>
   <P>Welcome, first visitor!</P>
<% } else { %>
   <P>You are not the first visitor. <%= count-1 %> other
   visitors have already been here,</P>
<% }%>

</BODY>
</HTML>
