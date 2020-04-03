<%@include file="global/userinfo.jsp" %>

<jsp:setProperty
 name="user"
 property="articleId"/>

<% if(user.getStyle().equals("navright")) { %>
<jsp:forward page="/ch11/articler.jsp"/>
<% } else if(user.getStyle().equals("textonly")) { %>
<jsp:forward page="/ch11/articlet.jsp"/>
<% } else { %>
<jsp:forward page="/ch11/articlel.jsp"/>
<% } %>