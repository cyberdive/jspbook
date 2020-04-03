<%@include file="dbconnect.jsp" %>

<jsp:useBean id="pageInfo"
    class="com.awl.jspbook.ch10.PageInfo"
    scope="request"/>

<jsp:useBean id="sections"
     class="com.awl.jspbook.ch10.SectionHolder"
     scope="application"/>

<% String sectionNames[] = sections.getNames(); %>
<% int      sectionIds[] = sections.getIds(); %>

<%-- Begin Navigation --%>
<FONT COLOR="FFFFFF">

<% for (int i=0;i<sectionNames.length;i++) { %>
   <% if (sectionIds[i] == pageInfo.getSectionId()) { %>
     <FONT COLOR="#FF0000"><B>&raquo;<B></FONT>
     <%= sectionNames[i] %><BR>
   <% } else { %>
     <FONT COLOR="#FF0000"><B>&sect;<B></FONT>
     <A HREF="section.jsp?sectionId=<%= sectionIds[i] %>">
     <%= sectionNames[i] %></A><BR>
   <% } %>
<% } %>


<HR>
Today's quiz:<BR>
<jsp:include page="/ch10/global/quiz.jsp"
 flush="true"/>
<%-- End Navigation --%>

