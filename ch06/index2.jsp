<%! int count = 0; %>

<HTML>
<HEAD><TITLE>Java News Today!</TITLE>

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

    <TD>

      <FONT SIZE="-1"> 
        <% count = count + 1; %>
        <P>This page has had <%= count %> visitors</P>
      </FONT>

      <!-- Content goes here -->
    </TD>
  </TR>
</TABLE>
</BODY>
</HTML>