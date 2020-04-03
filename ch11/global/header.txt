<jsp:useBean
 id="user"
 class="com.awl.jspbook.ch11.UserInfoBean"
 scope="session"/>

<jsp:useBean id="pageInfo"
    class="com.awl.jspbook.ch11.PageInfo"
    scope="request"/>

<%-- Begin Header --%>

<H1>Welcome To Java News Today</H1>

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
