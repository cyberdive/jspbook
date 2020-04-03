<jsp:useBean id="which" 
             class="com.awl.jspbook.ch07.WhichPageBean"
             scope="request"/>

<HTML>

<BODY BGCOLOR="#00FF00">

<H1>Welcome to the green page</H1>

Your favorite number is
<jsp:getProperty name="which" property="favorite"/>

</BODY>
</HTML>
