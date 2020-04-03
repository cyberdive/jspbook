<%@ include file="dbconnect.jsp" %>

<jsp:useBean id="cd" class="com.awl.jspbook.ch09.CDBean"/>

<% cd.select(); %>

<HTML>
<HEAD><TITLE>CD List</TITLE></HEAD>
<BODY>

<P>Please select a CD for more info:</P>

<UL>

<% while (cd.next()) { %>
   <LI><A HREF="trackinfo3.jsp?albumId=<jsp:getProperty 
        name="cd" 
        property="albumId"/>&albumName=<jsp:getProperty 
        name="cd"
        property="nameURLEncoded"/>">
       <jsp:getProperty name="cd" property="name"/></A>
<% } %>

</UL>

</BODY>
</HTML>

<% cd.cleanup(); %>