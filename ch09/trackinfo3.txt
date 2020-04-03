<%@ include file="dbconnect.jsp" %>

<jsp:useBean id="track" class="com.awl.jspbook.ch09.TrackBean"/>

<jsp:setProperty name="track" property="*"/>

<% track.select(); %>

<HTML>
<HEAD><TITLE>Track List</TITLE></HEAD>
<BODY>

<P>
Tracks on "<%= request.getParameter("albumName") %>"
</P>

<TABLE BORDER="1">
  <TR><TH>Name</TH><TH>Length</TH></TR>

  <% while (track.next()) { %>
    <TR>
     <TD><jsp:getProperty name="track" property="name"/></TD>
     <TD><jsp:getProperty name="track" property="length"/></TD>
    </TR>
  <% } %>
</TABLE>


</BODY>
</HTML>

<% track.cleanup(); %>