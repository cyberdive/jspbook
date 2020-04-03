<HTML>
<HEAD><TITLE>Some declared variables</TITLE></HEAD>

<BODY>

<%! int anInteger = 5; %>
<%! int anotherInt = 7; %>
<%! double pi = 3.1415926; %>

<P>The value of anInteger is now <%= anInteger %>.</P>
<P>The value of anotherInt is now <%= anotherInt %>.</P>
<P>The value of pi is now <%= pi %>.</P>

<P>The value of anInteger + 1 is <%= anInteger + 1 %>.</P>

<P>The area of a circle with a radius of 2 inches is
   <%= pi * 2 * 2 %> inches.</P>


<%! java.util.Date now = new java.util.Date(); %>
<P>Today's date is 
   <%= now.getMonth() +1 %>/<%= now.getDate() %>
</P>

</BODY>
</HTML>
