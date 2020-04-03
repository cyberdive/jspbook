<%@include file="global/userinfo.jsp" %>

<% if(user.getStyle().equals("navright")) { %>
<jsp:forward page="/ch12/sectionr.jsp"/>
<% } else if(user.getStyle().equals("textonly")) { %>
<jsp:forward page="/ch12/sectiont.jsp"/>
<% } else { %>
<jsp:forward page="/ch12/sectionl.jsp"/>
<% } %>