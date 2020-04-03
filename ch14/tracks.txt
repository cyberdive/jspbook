<HTML>

<BODY>
<%@ taglib
  uri="http://java.apache.org/tomcat/examples-taglib"
  prefix="awl" %>

<H1>Tracks</H1>

<TABLE BORDER="1">
  <TR><TH>Name</TH><TH>Length</TH></TR>

  <awl:tracks CD="Liquid">
    <TR>
      <TD><%= name %></TD>
      <TD><%= length %></YD>
    </TR>
  </awl:tracks>

</TABLE>
</BODY>
</HTML>