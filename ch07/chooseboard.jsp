<jsp:useBean
 id="allBoards"
 class="com.awl.jspbook.ch07.AllBoardsBean"
 scope="application"/>

<%-- If the user requested a new board be created,
     this line will handle the creation.  --%>

<jsp:setProperty name="allBoards" property="*"/>

<HTML>
<HEAD><TITLE>Board chooser</TITLE></HEAD>

<BODY>

<FORM ACTION="readboard.jsp" METHOD="POST">
  <% String boardNames[] = allBoards.getBoardNames(); %>
  <P>Select a board to read:</P>

  <SELECT NAME="boardId">

    <% for (int i=0;i<boardNames.length;i++) { %>
      <OPTION VALUE="<%= boardNames[i] %>"><%= boardNames[i] %>
    <% } %>

  </SELECT>

  <INPUT TYPE="SUBMIT" NAME="Read" VALUE="Read">
</FORM>


<FORM ACTION="chooseboard.jsp" METHOD="POST">
  <P>
  Or, create a new board named:
  <INPUT TYPE="TEXT" name="newBoardName">
  </P>

  <INPUT TYPE="SUBMIT" NAME="Create" VALUE="Create">
</FORM>

</BODY>
</HTML>
