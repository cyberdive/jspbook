<jsp:useBean id="pageInfo"
    class="com.awl.jspbook.ch11.PageInfo"
    scope="request"/>

<jsp:useBean
 id="allBoards"
 class="com.awl.jspbook.ch11.AllBoardsBean"
 scope="application"/>

<jsp:useBean
 id="user"
 class="com.awl.jspbook.ch11.UserInfoBean"
 scope="session"/>

<jsp:useBean
 id="board"
 class="com.awl.jspbook.ch11.BoardProxyBean"
 scope="page"/>


<%-- This will create the board if it
     doesn't exist yet --%>

<jsp:setProperty name="allBoards" 
    property="newBoardName"
    value="<%= pageInfo.getArticleIdString() %>"/>

<%-- This connects the proxy bean to the all boards bean --%>

<jsp:setProperty
 name="board"
 property="allBoards"
 value="<%= allBoards %>"/>

<%-- This sets the board bean to the specific board we're
     interested in --%>

<jsp:setProperty
 name="board"
 property="boardId"
 value="<%= pageInfo.getArticleIdString() %>"/>

<%-- This creates a new message, if requested --%>
<jsp:setProperty name="board" property="*"/>

<% while(board.hasMoreMessages()) { %>
  <P>
  From: <jsp:getProperty name="board" property="from"/><BR>
  Subject: <jsp:getProperty name="board" property="subject"/><BR>
  <BLOCKQUOTE>
  <jsp:getProperty name="board" property="text"/>
  </BLOCKQUOTE>
  </P>
  <HR>
<% } %>

<P>Leave a message:</P>
<FORM ACTION="<%= request.getRequestURI() %>" METHOD="POST">
  <INPUT TYPE="HIDDEN" NAME="articleId"
   VALUE="<jsp:getProperty name="pageInfo"
           property="articleid"/>">

  <INPUT TYPE="HIDDEN" NAME="sectionId"
   VALUE="<jsp:getProperty name="pageInfo"
           property="sectionid"/>">

  <INPUT TYPE="HIDDEN" NAME="boardId"
   VALUE="<jsp:getProperty name="pageInfo"
           property="articleid"/>">

  <INPUT TYPE="HIDDEN" NAME="from"
   VALUE="<jsp:getProperty name="user"
           property="name"/>">

  <P>
  Subject: <INPUT TYPE="TEXT" NAME="subject"><BR>
  Text: <TEXTAREA NAME="text"></TEXTAREA>
  </P>

  <INPUT TYPE="SUBMIT" NAME="Submit" VALUE="Submit">
</FORM>

