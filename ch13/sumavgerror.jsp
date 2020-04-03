<jsp:useBean 
  class="com.awl.jspbook.ch13.SumAvgBean"
  id="data" 
  scope="request"/>

<HTML>
<HEAD><TITLE>Error</TITLE></HEAD>
<BODY>

<P>
I was unable to complete your request, because
<jsp:getProperty name="data" property="bad"/>
is not a number.
</P>

<FORM ACTION="/jspbook/ch13/sumavg" METHOD="POST">
<INPUT TYPE="TEXT" NAME="values"
  VALUE="<jsp:getProperty name="data" property="values"/>">
<INPUT TYPE="SUBMIT">
</FORM>

</BODY>
</HTML>

