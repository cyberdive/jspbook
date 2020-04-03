<jsp:useBean 
     id="authorvalid"
     class="com.awl.jspbook.ch12.AuthorValidBean"
     scope="session">

<% if (!authorvalid.isValid()) { %>
  <% if(request.getParameter("authorId") == null) { %>
    <jsp:forward page="/ch12/login.jsp"/>
  <% } else { %>
    <jsp:useBean 
         id="authors"
         class="com.awl.jspbook.ch12.AuthorBean"/>

    <jsp:setProperty name="authors" property="*"/>

    <%-- If the name does not match the password, no rows 
         will match the where clause --%>

    <% authors.select(); %>

    <% if(!authors.next()) { %>
      <jsp:forward page="/ch12/login.jsp"/>
    <% } else { %>
      <jsp:setProperty name="authorvalid"
         property="valid" value="true"/>
    <% } %>
  <% } %>
<% } %>

</jsp:useBean>
