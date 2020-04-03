<%@include file="global/userinfo.jsp" %>

<jsp:useBean id="cart"
 class="com.awl.jspbook.ch12.ShoppingCartBean"
 scope="session"/>

<%-- If we were called with shipping info, 
     process it here. --%>
<jsp:setProperty name="user" property="*"/>

<% if (user.canOrder()) { %>

<% cart.order(user); %>

<P>Thank you!  Your order has been placed, and should
be delievered within 5 business days.</P>

<% } else { %>
<P>Please provide the following information, so we can 
process your order:</P>

<FORM ACTION="checkout.jsp">
<P>Billing Address:</P>
<P><TEXTAREA NAME="billAddr"></TEXTAREA></P>

<P>Shipping Address (if different):</P>
<P><TEXTAREA NAME="shipAddr"></TEXTAREA></P>

<P>Credit Card Number:
<INPUT TYPE="TEXT" NAME="creditCardNum"></P>

<P>Month of credit card expiration:
<SELECT NAME="expMonth">
<OPTION>1
<OPTION>2
<OPTION>3
<OPTION>4
<OPTION>5
<OPTION>6
<OPTION>7
<OPTION>8
<OPTION>9
<OPTION>10
<OPTION>11
<OPTION>12
</SELECT>
</P>

<P>Year of credit card expiration:
<SELECT NAME="expYear">
<OPTION>1999
<OPTION>2000
<OPTION>2001
<OPTION>2002
<OPTION>2003
<OPTION>2004
</SELECT>
</P>

<P><INPUT TYPE="SUBMIT" NAME="SUBMIT"></P>
</FORM>

<% } %>
