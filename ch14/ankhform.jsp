<jsp:useBean 
id="ankh" 
class="com.awl.jspbook.ch14.AnkhBean"/>

<jsp:setProperty 
name="ankh" 
property="*"/>

<HTML>

<HEAD><TITLE>A generated image</TITLE></HEAD>

<BODY>

<P>Here is the image!
<IMG SRC="ankh.jsp?fgColor=<jsp:getProperty name="ankh"
property="fgColor"/>&bgColor=<jsp:getProperty name="ankh"
property="bgColor"/>">

</P>

<P>
Set new colors below.  Specify both in standard HTML
color syntax, using all 6 digits.
</P>

<FORM ACTION="ankhform.jsp" METHOD="POST">
<P>Foreground: <INPUT TYPE="text" NAME="fgColor"></P>
<P>Background: <INPUT TYPE="text" NAME="bgColor"></P>
<P><INPUT TYPE="Submit">
</FORM>

</BODY>
</HTML>