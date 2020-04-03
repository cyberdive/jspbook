<%! int count = 1; %>

<jsp:useBean id="scounter" 
 class="com.awl.jspbook.ch07.Counter"
 scope="session">

<P>
This is your first visit to this page!
</P>

<jsp:setProperty name="scounter" property="count" value="0"/>

</jsp:useBean>


<HTML>
<BODY>

<P>
This page has been accessed <%= count %> times.
</P>

<P>
You have accessed this page
<jsp:getProperty name="scounter" property="count"/>
times.
</P>

<% count++; %>

</BODY>
</HTML>
