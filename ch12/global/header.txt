<jsp:useBean
 id="user"
 class="com.awl.jspbook.ch12.UserInfoBean"
 scope="session"/>

<jsp:useBean
 id="ads"
 class="com.awl.jspbook.ch12.AdHolder"
 scope="application"/>

<jsp:useBean id="pageInfo"
    class="com.awl.jspbook.ch12.PageInfo"
    scope="request"/>

<%-- Begin Header --%>

<H1>Welcome To Java News Today</H1>

<HR>
<jsp:getProperty name="user" property="ad"/>
</HR>

<H2>
<jsp:getProperty name="pageInfo" property="sectionName"/>
</H2>

<P>
<jsp:getProperty name="pageInfo" property="sectionDescription"/>
</P>

<% if (user.isLoggedIn()) { %>
<CENTER>
  <FONT SIZE="-1">
    Welcome back,
    <jsp:getProperty name="user" property="name"/>!
  </FONT>
</CENTER>
<% } %>
<%-- End Header --%>
