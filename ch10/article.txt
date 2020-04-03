<%@include file="global/dbconnect.jsp" %>

<jsp:useBean id="sections"
     class="com.awl.jspbook.ch10.SectionHolder"
     scope="application"/>

<jsp:useBean id="pageInfo"
    class="com.awl.jspbook.ch10.PageInfo"
    scope="request">
<jsp:setProperty name="pageInfo" property="*"/>
</jsp:useBean>

<jsp:useBean
 id="user"
 class="com.awl.jspbook.ch10.UserInfoBean"
 scope="session">

<jsp:setProperty name="user" property="request"
 value="<%= request %>" />

</jsp:useBean>


<HTML>
<HEAD>
  <TITLE>
    Java News Today:
    <jsp:getProperty name="pageInfo" property="sectionName"/>
  </TITLE>
</HEAD>

<BODY BGCOLOR="#FFFFFF">

<TABLE BORDER="0" WIDTH="100%">

  <TR>
    <TD BGCOLOR="#0000FF" ALIGN="CENTER" COLSPAN="2">
      <jsp:include page="/ch10/global/header.jsp"
       flush="true"/>
    </TD>
  </TR>

  <TR>
    <TD ALIGN="LEFT" WIDTH="20%" BGCOLOR="#000077">
      <jsp:include page="/ch10/global/navigation.jsp"
       flush="true"/>
    </TD>

    <TD>
      <%-- Content goes here --%>
      <%-- get the article --%>
      <jsp:useBean
           id="articles"
           class="com.awl.jspbook.ch10.ArticleBean"/>

      <%-- restrict the search to this section and article --%>
      <jsp:setProperty
           name="articles"
           property="*"/>

      <% articles.select(); %>
      <% articles.next(); %>

      <H1>
      <jsp:getProperty
           name="articles"
	   property="headline"/>
      </H1>

      <P>
      <jsp:getProperty
           name="articles"
	   property="body"/>
      </P>

      <HR>
      <jsp:include page="/ch10/board.jsp" flush="true"/>

    </TD>
  </TR>
</TABLE>
</BODY>
</HTML>
