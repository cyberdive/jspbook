<jsp:useBean id="quiz1" 
 class="com.awl.jspbook.ch06.TodaysQuiz"/>

<jsp:setProperty name="quiz1" property="*"/>

<%! int rightCount = 0; %>
<%! int wrongCount = 0; %>

<HTML>
<HEAD><TITLE>Java News Today: Quiz Result</TITLE>

<BODY BGCOLOR="#FFFFFF">

<TABLE BORDER="0" WIDTH="100%">

  <TR>
    <TD BGCOLOR="#0000FF" ALIGN="CENTER" COLSPAN="2">
      <%@include file="global/header.jsp"%>
    </TD>
  </TR>

  <TR>
    <TD ALIGN="LEFT" WIDTH="20%" BGCOLOR="#000077">
      <%@include file="global/navigation.jsp"%>
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

      <%-- End of content area --%>
    </TD>
  </TR>
</TABLE>
</BODY>
</HTML>