<%! String machineName; %>

<% machineName = request.getRemoteHost(); %>

<HTML>
<BODY>

<P> You are using a computer called <%= machineName %>.</P>

</BODY>
</HTML>

