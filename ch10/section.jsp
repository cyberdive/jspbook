<%@include file="global/dbconnect.jsp" %>

<%-- Set up the section holder --%>
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


<jsp:useBean
 id="allBoards"
 class="com.awl.jspbook.ch10.AllBoardsBean"
 scope="application"/>

<jsp:useBean
 id="board"
 class="com.awl.jspbook.ch10.BoardProxyBean"
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
      <%-- get the last ten articles --%>
      <jsp:useBean
           id="articles"
           class="com.awl.jspbook.ch10.ArticleBean"/>

      <%-- restrict the search to this section --%>
      <jsp:setProperty
           name="articles"
           property="*"/>

      <%-- Search in reverse order, to get latest 
           stories first --%>
      <% articles.setOrderBy("articleId desc"); %>
      <% articles.select(); %>

      <%-- Get a maximum of ten stories --%>
      <% int count = 0; %>

      <% while (articles.next() && count < 10) { %>
         <% count++; %>
         <% String URL="article.jsp?sectionId=" +
                        pageInfo.getSectionId() + 
                        "&articleId=" +
		        articles.getArticleId(); %>

         <FONT SIZE="+1">
           <A HREF="<%= URL %>"><jsp:getProperty
                                     name="articles"
                                     property="headline"/></A>
         </FONT>

         <BLOCKQUOTE>
           <jsp:getProperty name="articles" property="summary"/>
         </BLOCKQUOTE>

         <!-- top three comments from board go here. -->

         <%-- This will create the board if it
          doesn't exist yet --%>

         <jsp:setProperty name="allBoards" 
          property="newBoardName"
          value="<%= articles.getArticleIdString() %>"/>


         <%-- This sets the board bean to the specific board 
              we're interested in --%>

         <jsp:setProperty
          name="board"
          property="boardId"
          value="<%= articles.getArticleIdString() %>"/>

         <%-- Get up to three messages --%>
         <UL>
         <% while(board.hasMoreMessages()) { %>
           <LI>
           <jsp:getProperty name="board" property="subject"/>
         <% } %>
         </UL>

         <HR>
      <% } %>

    </TD>
  </TR>
</TABLE>
</BODY>
</HTML>




