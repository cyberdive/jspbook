<%@include file="global/dbconnect.jsp" %>
<%@include file="global/userinfo.jsp" %>

<jsp:useBean id="sections"
     class="com.awl.jspbook.ch11.SectionHolder"
     scope="application"/>

<HTML>
<HEAD>
  <TITLE>
    Java News Today: User preferences
  </TITLE>
</HEAD>

<BODY BGCOLOR="#FFFFFF">

<TABLE BORDER="0" WIDTH="100%">

  <TR>
    <TD BGCOLOR="#0000FF" ALIGN="CENTER" COLSPAN="2">
      <jsp:include page="/ch11/global/header.jsp"
       flush="true"/>
    </TD>
  </TR>

  <TR>
    <TD ALIGN="LEFT" WIDTH="20%" BGCOLOR="#000077">
      <jsp:include page="/ch11/global/navigation.jsp"
       flush="true"/>
    </TD>

    <TD>
      <%-- Content goes here --%>

<H1>User Preferences</H2>

<P>Welcome <jsp:getProperty 
             name="user"
             property="name"/>.  Use this page to
configure Java News Today to your tastes.  You can select
a style for pages, a color scheme, and add or remove sections
from your personal edition.</P>


<FORM ACTION="setprefs.jsp" METHOD="GET">

<TABLE BORDER="1">

  <TR>
    <TD><FONT="+1">Choose a style</FONT></TD>
    <TD><FONT="+1">Choose a color scheme</FONT></TD>
  </TR>

  <TR>
    <TD>
      <INPUT TYPE="RADIO" NAME="style" VALUE="navright"
      <% if(user.getStyle().equals("navright")) { %>
       CHECKED
      <% } %>>Navigation on the right
      <INPUT TYPE="RADIO" NAME="style" VALUE="navleft"
      <% if(user.getStyle().equals("navleft")) { %>
       CHECKED
      <% } %>>Navigation on the left
      <INPUT TYPE="RADIO" NAME="style" VALUE="textonly"
      <% if(user.getStyle().equals("textonly")) { %>
       CHECKED
      <% } %>>Text Only
    </TD>


    <TD>
      <INPUT TYPE="RADIO" NAME="color" VALUE="blues"
      <% if(user.getColor().equals("blues")) { %>
       CHECKED
      <% } %>>Blues
      <INPUT TYPE="RADIO" NAME="color" VALUE="reds"
      <% if(user.getColor().equals("reds")) { %>
       CHECKED
      <% } %>>Reds
      <INPUT TYPE="RADIO" NAME="color" VALUE="greens"
      <% if(user.getColor().equals("greens")) { %>
       CHECKED
      <% } %>>Greens
      <INPUT TYPE="RADIO" NAME="color" VALUE="greys"
      <% if(user.getColor().equals("greys")) { %>
       CHECKED
      <% } %>>Greys
    </TD>
  </TR>

  <TR>
    <TD COLSPAN="2">Which sections do you want to include?</TD>
  </TR>

  <TR>
    <% String sectionNames[] = sections.getNames(); %>
    <% int      sectionIds[] = sections.getIds(); %>

    <TD>
      <% for (int i=0;i<sectionIds.length;i+=2) { %>
        <INPUT TYPE="CHECKBOX" NAME="sections"
         VALUE="<%= sectionIds[i] %>" 
         <% if(user.wantsSection(sectionIds[i])) { %>
         CHECKED
         <% } %>><%= sectionNames[i] %><BR>
      <% } %>
    </TD>

    <TD>
      <% for (int i=1;i<sectionIds.length;i+=2) { %>
        <INPUT TYPE="CHECKBOX" NAME="sections"
         VALUE="<%= sectionIds[i] %>" 
         <% if(user.wantsSection(sectionIds[i])) { %>
         CHECKED
         <% } %>><%= sectionNames[i] %><BR>
      <% } %>
    </TD>

   </TR>

  <TR>
    <TD COLSPAN="2">Which writers do you want to include?</TD>
  </TR>

  <jsp:useBean
    id="authors"
    class="com.awl.jspbook.ch11.AuthorBean"/>

  <% authors.select(); %>

  <TR>
    <TD COLSPAN="2">
    <% while (authors.next()) { %>
      <INPUT TYPE="CHECKBOX" NAME="authors" 
       VALUE="<%= authors.getAuthorId() %>"
           <% if(user.wantsAuthor(authors.getAuthorId())) { %>
            CHECKED
           <% } %>>
      <jsp:getProperty
           name="authors"
           property="firstName"/> <jsp:getProperty
                                   name="authors"
                                   property="lastName"/><BR>
    <% } %>
    </TD>
  </TR>

  <TR>
    <TD COLSPAN="2">
    Do you want the daily quiz?
    <INPUT TYPE="RADIO" NAME="wantsQuizBugFix" value="true" 
     <% if (user.getWantsQuiz()) { %>CHECKED<% } %>>Yes
    <INPUT TYPE="RADIO" NAME="wantsQuizBugFix" value="false"
     <% if (!user.getWantsQuiz()) { %>CHECKED<% } %>>No
    </TD>
  </TR>

  <TR>
    <TD COLSPAN="2" ALIGN="CENTER">
     <INPUT TYPE="SUBMIT" NAME="Go!" VALUE="Go!">
   </TD>
  </TR>

</TABLE>
</TABLE>
</BODY>
</HTML>