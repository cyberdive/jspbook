<%! int count =0; %>

<HTML>

<HEAD><TITLE>A Counter</TITLE></HEAD>

<BODY>
<% count = count + 1; %>

<P>This page has been accessed <%= count %> times.</P>

<%
if (count == 1) {
   out.print("<P>Welcome, first visitor!</P>"); 
}
%>

</BODY>
</HTML>
