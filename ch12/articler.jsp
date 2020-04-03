<%@include file="global/dbconnect.jsp" %>
<%@include file="global/userinfo.jsp" %>

<%-- Set up the section holder --%>
<jsp:useBean id="sections"
     class="com.awl.jspbook.ch12.SectionHolder"
     scope="application"/>

<jsp:useBean id="pageInfo"
    class="com.awl.jspbook.ch12.PageInfo"
    scope="request">
<jsp:setProperty name="pageInfo" property="*"/>
</jsp:useBean>

<jsp:useBean
 id="allBoards"
 class="com.awl.jspbook.ch12.AllBoardsBean"
 scope="application"/>

<jsp:useBean
 id="board"
 class="com.awl.jspbook.ch12.BoardProxyBean"
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


<TABLE BORDER="0" WIDTH="100%">

  <TR>
    <TD BGCOLOR="<jsp:getProperty
                name="user"
                property="headBgColor"/>"
        ALIGN="CENTER" COLSPAN="2">
      <jsp:include page="/ch12/global/header.jsp"
       flush="true"/>
    </TD>
  </TR>

  <TR>
    <TD>
      <%-- Content goes here --%>
      <%-- Content goes here --%>
      <%-- get the article --%>
      <jsp:useBean
           id="articles"
           class="com.awl.jspbook.ch12.ArticleBean"/>

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
      <jsp:include page="/ch12/board.jsp"
       flush="true"/>
    </TD>

    <TD ALIGN="LEFT" WIDTH="20%" 
        BGCOLOR="<jsp:getProperty
                name="user"
                property=navBgColor/>">

      <jsp:include page="/ch12/global/navigation.jsp"/>
    </TD>

  </TR>
</TABLE>
</BODY>
</HTML>





