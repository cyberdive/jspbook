<%@ include file="global/dbconnect.jsp" %>
<%@ include file="global/userinfo.jsp" %>


<HTML>
<HEAD>
  <TITLE>
    Java News Today: Account creation
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
    <TD ALIGN="TOP" WIDTH="20%" BGCOLOR="#000077">
      <jsp:include page="/ch12/global/navigation.jsp"
       flush="true"/>
    </TD>

    <TD>
      <%-- Content goes here --%>
<% if(request.getParameter("name") != null) { %>

  <jsp:setProperty
    name="user"
    property="*"/>

  <% if(user.nameInUse()) { %>
   Sorry, that name is already in use.  Please choose another.
  <FORM ACTION="createacct.jsp" METHOD="POST">
     <P>Username:
     <INPUT TYPE="TEXT" NAME="name"></P>
     <P>Password:
     <INPUT TYPE="PASSWORD" NAME="password"></P>
     <P>Email address
     <INPUT TYPE="TEXT" NAME="email"></P>
     <P><INPUT TYPE="SUBMIT" NAME="Login" VALUE="Login"></P>
  </FORM>
  <% } else { %>
    <% user.insert(); %>
    <P>Account created!</P>
    <P>Return to the Java News Today
    <A HREF="index1.jsp">home page</A> or set your
    <A HREF="userprefs.jsp">preferences</A></P>
  <% } %>
<% } else { %>
  <P>Create a new account:</P>
  <FORM ACTION="createacct.jsp" METHOD="POST">
     <P>Username:
     <INPUT TYPE="TEXT" NAME="name"></P>
     <P>Password:
     <INPUT TYPE="PASSWORD" NAME="password"></P>
     <P>Email address
     <INPUT TYPE="TEXT" NAME="email"></P>
     <P><INPUT TYPE="SUBMIT" NAME="Login" VALUE="Login"></P>
  </FORM>
<% } %>

      <%-- end content --%>
    </TD>
  </TR>
</TABLE>
</BODY>
</HTML>
