<%@include file="global/dbconnect.jsp" %>
<%@include file="global/userinfo.jsp" %>

<jsp:useBean id="description"
  class="com.awl.jspbook.ch12.DescriptionsBean"/>

<jsp:useBean id="item"
  class="com.awl.jspbook.ch12.CatalogBean"/>

<jsp:setProperty name="description" property="*"/>
<% description.select(); %>
<% description.next(); %>

<jsp:setProperty name="item" property="*"/>
<% item.select(); %>

<HTML>
<HEAD>
<TITLE>JNT: Item description</TITLE>
</HEAD>

<BODY>

<H1><jsp:getProperty name="description" property="name"/></H1>

<P>
<jsp:getProperty name="description" property="fulldesc"/>
</P>

<P>Variations:</P>
<UL>

<% while(item.next()) { %>
<LI><jsp:getProperty name="item" property="variation"/> -
$<jsp:getProperty name="item" property="price"/>.

<A HREF="shoppingcart.jsp?catid=<jsp:getProperty 
name="item" property="catid"/>">Buy it!</A>
<% } %>

</UL>

</BODY>
</HTML>
