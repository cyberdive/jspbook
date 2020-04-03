<HTML>

<HEAD><TITLE>A simple calculator: results</TITLE></HEAD>

<BODY>

<P>
<% try { %>

<% int result = 
  Integer.parseInt(request.getParameter("value1")) +
  Integer.parseInt(request.getParameter("value2")); %>

<P>The sum of your two numbers is <%= result %></P>

<% } catch (NumberFormatException nfe) { %>


<P>
Sorry, I was unable to compute the result, because one of the 
values provided was not an integer.
</P>

<% } %>

</BODY>
</HTML>
