<%@include file="global/userinfo.jsp" %>

<% if(user.getStyle().equals("navright")) { %>
<jsp:forward page="/ch11/sectionr.jsp"/>
<% } else if(user.getStyle().equals("textonly")) { %>
<jsp:forward page="/ch11/sectiont.jsp"/>
<% } else { %>
<jsp:forward page="/ch11/sectionl.jsp"/>
<% } %>