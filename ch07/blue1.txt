<jsp:useBean id="which" 
             class="com.awl.jspbook.ch07.WhichPageBean"
             scope="request"/>

<HTML>

<BODY BGCOLOR="#0000FF">

<H1>Welcome to the blue page</H1>

Your favorite number is
<jsp:getProperty name="which" property="favorite"/>

</BODY>
</HTML>
