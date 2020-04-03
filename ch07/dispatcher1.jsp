<jsp:useBean id="which"
             class="com.awl.jspbook.ch07.WhichPageBean"
             scope="request"/>

<jsp:setProperty name="which" property="*"/>

<% if (which.getWhich().equals("red")) { %>
   <jsp:forward page="/ch07/red1.jsp"/>
<% } else if (which.getWhich().equals("green")) { %>
   <jsp:forward page="/ch07/green1.jsp"/>
<% } else if (which.getWhich().equals("blue")) { %>
   <jsp:forward page="/ch07/blue1.jsp"/>
<% } %>

<HTML>
<BODY>
You asked for a page which does not exist!
</BODY>
</HTML>


