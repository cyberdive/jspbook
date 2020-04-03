<jsp:useBean
 id="allBoards"
 class="com.awl.jspbook.ch07.AllBoardsBean"
 scope="application"/>

<jsp:useBean
 id="board"
 class="com.awl.jspbook.ch07.BoardProxyBean"
 scope="page"/>

<%-- This connects the proxy bean to the all boards bean --%>

<jsp:setProperty
 name="board"
 property="allBoards"
 value="<%= allBoards %>"/>

<%-- This sets the board bean to the specific board we're
     interested in --%>

<jsp:setProperty
 name="board"
 property="boardId"/>

<%-- This creates a new message, if requested --%>
<jsp:setProperty name="board" property="*"/>

<HTML>

<HEAD>
  <TITLE>
    Boards: 
    <jsp:getProperty name="board" property="boardId"/>
  </TITLE>
</HEAD>

<BODY>

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
<FORM ACTION="readboard.jsp" METHOD="POST">
  <INPUT TYPE="HIDDEN" NAME="boardId"
   VALUE="<jsp:getProperty name="board"
           property="boardId"/>">

  <P>
  Your name: <INPUT TYPE="TEXT" NAME="from"><BR>
  Subject: <INPUT TYPE="TEXT" NAME="subject"><BR>
  Text: <TEXTAREA NAME="text" ROWS="5" COLS="20"></TEXTAREA>
  </P>

  <INPUT TYPE="SUBMIT" NAME="Submit" VALUE="Submit">
</FORM>

</BODY>
</HTML>