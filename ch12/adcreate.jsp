<%@ include file="global/dbconnect.jsp" %>

<jsp:useBean id="ad" class="com.awl.jspbook.ch12.AdsBean"/>

<HTML>
<HEAD><TITLE>News Desk: Ad created</TITLE></HEAD>
<BODY>

  <jsp:setProperty name="ad" property="*"/>
  <% ad.insert(); %>

  <P>Ad created</P>  
  <P>Return to the<A HREF="addesk.jsp">Ad Desk</A>.</P>
</BODY>
</HTML>
