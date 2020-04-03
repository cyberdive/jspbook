<jsp:useBean
 id="winners"
 class="com.awl.jspbook.ch12.WinnerBean"
 scope="application"/>

<jsp:useBean
 id="user"
 class="com.awl.jspbook.ch12.UserInfoBean"
 scope="session"/>

<jsp:useBean id="quiz1" 
 class="com.awl.jspbook.ch12.TodaysQuiz"/>

<jsp:setProperty name="quiz1" property="*"/>

<%! int rightCount = 0; %>
<%! int wrongCount = 0; %>

<HTML>
<HEAD><TITLE>Java News Today: Quiz Result</TITLE>

<BODY BGCOLOR="#FFFFFF">

<TABLE BORDER="0" WIDTH="100%">

  <TR>
    <TD BGCOLOR="#0000FF" ALIGN="CENTER" COLSPAN="2">
      <jsp:include page="global/header.jsp" flush="true"/>
    </TD>
  </TR>

  <TR>
    <TD ALIGN="LEFT" WIDTH="20%" BGCOLOR="#000077">
      <jsp:include page="global/navigation.jsp" flush="true"/>
    </TD>

    <TD VALIGN="TOP">
      <%-- Content starts here --%>

      <P>
      The question was: 
      <jsp:getProperty name="quiz1" property="question"/>
      </P>

      <P>
      You responded
      "<jsp:getProperty name="quiz1" property="guess"/>"
      </P>

      <% if (quiz1.isRight()) { %>
        <% rightCount++; %>

        <P>That's exactly right!</P>

        <%-- Add a point to this user's score! --%>
        <jsp:setProperty
         name="winners"
         property="name"
         value="<%= user.getName() =>"/>

      <% } else { %>

        <% wrongCount++; %>

        <P>
        Sorry, that's wrong.  You might want to read more
        on this topic, 
      <A HREF="<jsp:getProperty name="quiz1" property="url"/>">
      here</A>.
       </P>
      <% } %>


      <P><%= rightCount %> people have answered this
          question currently, and <%= wrongCount %>
          people have answered incorrectly.</P>

      <%-- Show the top 10 guessers, and their scores --%>
      <% String names[] = winners.getNames(); %>
      <% int scores[]   = winners.getScores(); %>

      <P>Top ten quizmasters:</P>
      <OL>
      <% for (int i=0;i<10;i++) { %>
        <LI><%= names[i] %> (<%= scores[i] %> right)
      <% } %>
      </OL>

      <%-- End of content area --%>
    </TD>
  </TR>
</TABLE>
</BODY>
</HTML>