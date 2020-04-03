<%@include file="global/dbconnect.jsp"%>
<%@include file="global/userinfo.jsp"%>

<jsp:setProperty name="user" property="*"/>

<% user.update(); %>

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
      <P>Your preferences have been changed!</P>
      <%-- end content --%>
    </TD>
  </TR>
</TABLE>
</BODY>
</HTML>
