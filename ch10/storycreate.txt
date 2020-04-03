<%@ include file="global/dbconnect.jsp" %>
<%@ include file="global/authorvalid.jsp" %>


<HTML>
<HEAD><TITLE>News Desk: Story created</TITLE></HEAD>
<BODY>
  <jsp:useBean 
    id="article"
    class="com.awl.jspbook.ch10.ArticleBean"/>

  <jsp:setProperty name="article" property="*"/>
  <% article.insert(); %>

  <jsp:setProperty name="article" property="*"/>
  <% article.select(); %>

  <P>Story created with id=<jsp:getProperty 
                            name="article"
                            property="articleid"/></P>

  <% article.updateKeywords(); %>
  
  <P>Return to the <A HREF="newsdesk.jsp">Editor's Desk</A>.</P>
</BODY>
</HTML>
