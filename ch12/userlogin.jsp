<%@ include file="global/dbconnect.jsp" %>
<%@ include file="global/userinfo.jsp" %>


<HTML>
<HEAD>
  <TITLE>
    Java News Today: Login
  </TITLE>
</HEAD>

<BODY BGCOLOR="#FFFFFF">

<TABLE BORDER="0" WIDTH="100%">

  <TR>
    <TD BGCOLOR="#0000FF" ALIGN="CENTER" COLSPAN="2">
      <jsp:include page="/ch12/global/header.jsp"
       flush="true"/>
    </TD>
  </TR>

  <TR>
    <TD ALIGN="LEFT" WIDTH="20%" BGCOLOR="#000077">
      <jsp:include page="/ch12/global/navigation.jsp"
       flush="true"/>
    </TD>

    <TD>
      <%-- Content goes here --%>

<jsp:setProperty name="user" property="*"/>

<% user.select(); %>

<% if (request.getParameter("password") != null) { %>
   <% if (user.isLoggedIn()) { %>
     <P>Thank you, you are now logged in!</P>
     <P>Return to the Java News Today
     <A HREF="index1.jsp">home page</A> or set your
     <A HREF="userprefs.jsp">preferences</A></P>
   <% } else { %>
     <P>Sorry, that login is incorrect.  Please try again.
        or <A HREF="createacct.jsp">create a new account</A>.</P>
     <FORM ACTION="/jspbook/ch12/userlogin.jsp" method="post">
       <P>Username:
       <INPUT TYPE="TEXT" NAME="name"></P>
       <P>Password:
       <INPUT TYPE="PASSWORD" NAME="password"></P>
       <P><INPUT TYPE="SUBMIT" NAME="Login" VALUE="Login"></P>
     </FORM>
   <% } %>
<% } else { %>
   <P>Please login:</P>
   <FORM ACTION="/jspbook/ch12/userlogin.jsp" METHOD="POST">
     <P>Username:
     <INPUT TYPE="TEXT" NAME="name"></P>
     <P>Password:
     <INPUT TYPE="PASSWORD" NAME="password"></P>
     <P><INPUT TYPE="SUBMIT" NAME="Login" VALUE="Login"></P>
   </FORM>
<% } %>

      <%-- End Content --%>
    </TD>
  </TR>
</TABLE>
</BODY>
</HTML>
