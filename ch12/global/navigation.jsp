<%@include file="dbconnect.jsp" %>
<%@include file="userinfo.jsp" %>

<jsp:useBean id="sections"
     class="com.awl.jspbook.ch12.SectionHolder"
     scope="application"/>

<jsp:useBean id="pageInfo"
    class="com.awl.jspbook.ch12.PageInfo"
    scope="request"/>

<% String sectionNames[] = sections.getNames(); %>
<% int      sectionIds[] = sections.getIds(); %>

<%-- Begin Navigation --%>
<FONT COLOR="FFFFFF">

<% if(user.isLoggedIn()) { %>
  * <A HREF="userprefs.jsp">Change Preferences</A><P>
<% } else { %>

  <P>Login!</P>
   <FORM ACTION="userlogin.jsp" METHOD="POST">
     <P>Username:
     <INPUT TYPE="TEXT" NAME="name"></P>
     <P>Password:
     <INPUT TYPE="PASSWORD" NAME="password"></P>
     <P><INPUT TYPE="SUBMIT" NAME="Login" VALUE="Login"></P>
   </FORM>
  <P>If you don't have an account yet, 
  you can <A HREF="createacct.jsp">create one</A> free!
  </P>
<% } %>

<HR>

<% for (int i=0;i<sectionNames.length;i++) { %>
   <% if (user.wantsSection(sectionIds[i])) { %>
     <% if (sectionIds[i] == pageInfo.getSectionId()) { %>
       <FONT COLOR="#FF0000"><B>&raquo;<B></FONT>
       <%= sectionNames[i] %><BR>
     <% } else { %>
       <FONT COLOR="#FF0000"><B>&sect;<B></FONT>
       <A HREF="section.jsp?sectionId=<%= sectionIds[i] %>">
       <%= sectionNames[i] %></A><BR>
     <% } %>
  <% } %>
<% } %>


<% if (user.getWantsQuiz()) { %>
<HR>
Today's quiz:<BR>
<jsp:include page="/ch12/global/quiz.jsp"
 flush="true"/>
<% } %>

<HR>
<%-- End Navigation --%>