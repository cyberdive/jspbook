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
                property=bgColor/>"
      TEXT="<jsp:getProperty
                name="user"
                property=textColor/>"
      LINK="<jsp:getProperty
                name="user"
                property=linkColor/>"
      VLINK="<jsp:getProperty
                name="user"
                property=vlinkColor/>">


<jsp:include page="/ch11/global/header.jsp"
 flush="true"/>

<HR>

      <%-- Content goes here --%>
      <%-- get the last ten articles --%>
      <jsp:useBean
           id="articles"
           class="com.awl.jspbook.ch11.ArticleBean"/>

      <%-- Search in reverse order, to get latest 
           stories first --%>
      <% articles.setOrderBy("articleId desc"); %>
      <% articles.select(); %>

      <%-- Get a maximum of ten stories --%>
      <% int count = 0; %>

      <% while (articles.next() && count < 10) { %>
         <% if(!user.wantsArticle(articles.getSectionId(),
	                         articles.getAuthorId()))
             continue; %>

         <% String URL="article.jsp?sectionId=" +
                        articles.getSectionId() + 
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

   <%-- end content --%>
   <jsp:include page="/ch11/global/navigation.jsp"
    flush="true"/>

</BODY>
</HTML>




