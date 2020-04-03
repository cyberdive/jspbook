<%@ include file="global/dbconnect.jsp" %>

<HTML>
<HEAD><TITLE>Ad Desk</TITLE></HEAD>
<BODY>
  <H1>Ad Creation Page</H1>

  <P>Create a new ad:</P>
  <FORM ACTION="adcreate.jsp" METHOD="POST">

  <TABLE>
  <TR>
    <TD>Ad text:</TD>
    <TD><TEXTAREA NAME="adbody"></TEXTAREA></TD>
  </TR>

  <TR>
    <TD>Number of Impressions:</TD>
    <TD><INPUT TYPE="TEXT" NAME="impressions"></TD>
  </TR>

  <TR>
    <TD>Provide a weight for all keywords:</TD>
    <TD>
      <jsp:useBean
           id="keyword"
           class="com.awl.jspbook.ch12.KeywordBean"/>
      <% keyword.select(); %>
      <% while (keyword.next()) { %>
        <INPUT TYPE="TEXT" NAME="keyweight" 
         VALUE="1" SIZE="3"><jsp:getProperty
                                 name="keyword"
                                 property="keyword"/><BR>
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
