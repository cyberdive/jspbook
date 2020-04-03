<%! java.util.Date now = new java.util.Date(); %>

<HTML>

<HEAD><TITLE>Current time</TITLE></HEAD>

<BODY>

<% now = new java.util.Date(); %>

Hello!  At the tone, the time will be exactly
<%= now.getHours() %>:<%= now.getMinutes() %>

and <%= now.getSeconds() %> seconds.
<P>

<B>BEEEP!</B>

</BODY>

</HTML>
