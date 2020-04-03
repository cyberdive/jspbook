<%@ include file="global/dbconnect.jsp" %>

<jsp:useBean 
     id="authors"
     class="com.awl.jspbook.ch10.AuthorBean"/>

<HTML>
<HEAD>
<TITLE>News desk: Login</TITLE>
</HEAD>

<BODY>


<FORM ACTION="newsdesk.jsp" METHOD="POST">
<P>
Who are you:
<SELECT NAME="authorId">

<% authors.select(); %>

<% while (authors.next()) { %>
<OPTION  VALUE="<%= authors.getAuthorId() %>"><jsp:getProperty
                     name="authors"
                     property="firstName"/> <jsp:getProperty
                     name="authors"
                     property="lastName"/>
<% } %>

</SELECT>
</P>

<P>
Password:
<INPUT TYPE="PASSWORD" NAME="password">
</P>

<P>
<INPUT TYPE="SUBMIT" NAME="Login" Value="Login">
</FORM>
</HTML>


 