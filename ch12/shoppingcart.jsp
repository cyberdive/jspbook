<%@include file="global/dbconnect.jsp" %>
<%@include file="global/userinfo.jsp" %>

<jsp:useBean id="cart"
  class="com.awl.jspbook.ch12.ShoppingCartBean"
  scope="session"/>

<jsp:setProperty name="cart" property="*"/>

<HTML>
<HEAD><TITLE>JNT: Shopping cart</TITLE></HEAD>

<BODY>

<P>
Your shopping cart currently contains the following:
</P>

<TABLE BORDER="1">
<TR>
 <TH>Name</TH>
 <TH>Variation</TH>
 <TH>Price</TH>
 <TH>Delete</TH>
</TR>

<% cart.reset(); %>
<% while(cart.next()) { %>
<TR>
  <TD><jsp:getProperty name="cart" property="name"/></TD>
  <TD><jsp:getProperty name="cart" property="variation"/></TD>
  <TD>$<jsp:getProperty name="cart" property="price"/></TD>
  <TD><A HREF="shoppingcart.jsp?deleteId=<jsp:getProperty name="cart" 
      property="count"/>">Delete</A></TD>
</TR>
<% } %>

<TR>
<TD COLSPAN="3" ALIGN="LEFT">Total:</TD>
<TD>$<jsp:getProperty name="cart" property="total"/></TD>
</TR>

</TABLE>

<A HREF="catalog.jsp">Continue Shopping</A><P>
<A HREF="checkout.jsp">Checkout!</A>

</BODY>
</HTML>
