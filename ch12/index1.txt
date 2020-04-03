<%@include file="global/userinfo.jsp" %>

<% if(user.getStyle().equals("navright")) { %>
<jsp:forward page="index1r.jsp"/>
<% } else if(user.getStyle().equals("textonly")) { %>
<jsp:forward page="index1t.jsp"/>
<% } else { %>
<jsp:forward page="index1l.jsp"/>
<% } %>