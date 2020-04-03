<jsp:useBean
 id="user"
 class="com.awl.jspbook.ch11.UserInfoBean"
 scope="session">

<jsp:setProperty name="user" property="request"
 value="<%= request %>" />

</jsp:useBean>

