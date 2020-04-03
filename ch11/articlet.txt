<%@include file="global/dbconnect.jsp" %>
<%@include file="global/userinfo.jsp" %>

<%-- Set up the section holder --%>
<jsp:useBean id="sections"
     class="com.awl.jspbook.ch11.SectionHolder"
     scope="application"/>

<jsp:useBean id="pageInfo"
    class="com.awl.jspbook.ch11.PageInfo"
    scope="request">
<jsp:setProperty name="pageInfo" property="*"/>
</jsp:useBean>

<jsp:useBean
 id="allBoards"
 class="com.awl.jspbook.ch11.AllBoardsBean"
 scope="application"/>

<jsp:useBean
 id="board"
 class="com.awl.jspbook.ch11.BoardProxyBean"
 scope="page"/>

<%-- This connects the proxy bean to the all boards bean --%>

<jsp:setProperty
 name="board"
 property="allBoards"
 value="<%= allBoards %>"/>


<HTML>
<HEAD>
  <TITLE>
    Java News Today:
    <jsp:getProperty name="pageInfo" property="sectionName"/>
  </TITLE>
</HEAD>

<BODY BGCOLOR="<jsp:getProperty
                name="user"
                property="bgColor"/>"
      TEXT="<jsp:getProperty
                name="user"
                property="textColor"/>"
      LINK="<jsp:getProperty
                name="user"
                property="linkColor"/>"
      VLINK="<jsp:getProperty
                name="user"
                property="vlinkColor"/>">



      <jsp:include page="/ch11/global/header.jsp"
       flush="true"/>

      <HR>

      <%-- Content goes here --%>
      <%-- get the article --%>
      <jsp:useBean
           id="articles"
           class="com.awl.jspbook.ch11.ArticleBean"/>

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
      <jsp:include page="/ch11/board.jsp"
       flush="true"/>

      <HR>
      <jsp:include page="/ch11/global/navigation.jsp"
       flush="true"/>

</BODY>
</HTML>





