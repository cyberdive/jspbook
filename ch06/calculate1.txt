<jsp:useBean id="calc" class="com.awl.jspbook.ch06.CalcBean"/>

<jsp:setProperty name="calc" property="*"/>

<HTML>
<HEAD><TITLE>A simple calculator: results</TITLE></HEAD>
<BODY>

<% if (calc.isValid()) { %>
<P>
The sum of your two numbers is 
<jsp:getProperty name="calc" property="sum"/>
</P>
<% } else { %>
<P>
Sorry, I could not compute the sum becuase
<jsp:getProperty name="calc" property="reason"/>
</P>
<% } %>

</BODY>
</HTML>
