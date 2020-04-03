<%@include file="global/userinfo.jsp" %>

<jsp:setProperty
 name="user"
 property="articleId"/>

<% if(user.getStyle().equals("navright")) { %>
<jsp:forward page="/ch12/articler.jsp"/>
<% } else if(user.getStyle().equals("textonly")) { %>
<jsp:forward page="/ch12/articlet.jsp"/>
<% } else { %>
<jsp:forward page="/ch12/articlel.jsp"/>
<% } %>