<%@ include file="global/dbconnect.jsp" %>
<%@ include file="global/authorvalid.jsp" %>

<jsp:useBean id="sections"
     class="com.awl.jspbook.ch10.SectionHolder"
     scope="application"/>

<% String sectionNames[] = sections.getNames(); %>
<% int      sectionIds[] = sections.getIds(); %>


<HTML>
<HEAD><TITLE>News Desk</TITLE></HEAD>
<BODY>
  <H1>Story Creation Page</H1>

  <P>Create a new story:</P>
  <FORM ACTION="storycreate.jsp" METHOD="POST">

  <TABLE>
  <TR>
    <TD>Choose a section:</TD>
    <TD>
      <SELECT NAME="sectionId">
      <% for(int i=0;i<sectionNames.length; i++) { %>
        <OPTION
         VALUE="<%= sectionIds[i] %>"><%= sectionNames[i] %>
      <% } %>
      </SELECT>
    </TD>
  </TR>

  </TR>
    <TD>Subject:</TD>
    <TD><INPUT TYPE="TEXT" NAME="headline"></TD>
  </TR>

  <TR>
    <TD>Summary:</TD>
    <TD><TEXTAREA ROWS="5" COLS="25" NAME="summary"></TEXTAREA></TD>
  </TR>

  <TR>
    <TD>Body:</TD>
    <TD><TEXTAREA ROWS="5" COLS="25" NAME="body"></TEXTAREA></TD>
  </TR>

  <TR>
    <TD>Select all applicable keywords:</TD>
    <TD>
      <SELECT NAME="keywords" MULTIPLE="yes">
      <jsp:useBean
           id="keyword"
           class="com.awl.jspbook.ch10.KeywordBean"/>
      <% keyword.select(); %>
      <% while (keyword.next()) { %>
        <OPTION VALUE="<jsp:getProperty name="keyword"
                        property="keywordid"/>">
                                    <jsp:getProperty
                                       name="keyword"
                                       property="keyword"/>
      <% } %>
      </SELECT>
    </TD> 
  </TR>

  <TR>
    <TD COLSPAN="2">
      <INPUT TYPE="SUBMIT" NAME="Submit" Value="Submit">
    </TD>
  </TR>
</TABLE>
</BODY>
</HTML>
