<%@include file="global/dbconnect.jsp" %>
<%@include file="global/userinfo.jsp" %>

<jsp:useBean id="pageInfo"
    class="com.awl.jspbook.ch12.PageInfo"
    scope="request">
<jsp:setProperty name="pageInfo" property="*"/>
</jsp:useBean>

<HTML>
<HEAD>
  <TITLE>
    Java News Today: The store
  </TITLE>
</HEAD>

<BODY BGCOLOR="<jsp:getProperty
                name="user"
                property="bgColor"/>"
      TEXT="<jsp:getProperty
                name="user"
                property="textColor"/>"
      LINK="<jsp:getProperty
                name="user"
                property="linkColor"/>"
      VLINK="<jsp:getProperty
                name="user"
                property="vlinkColor"/>">


<TABLE BORDER="0" WIDTH="100%">

  <TR>
    <TD BGCOLOR="<jsp:getProperty
                name="user"
                property="headBgColor"/>"
        ALIGN="CENTER" COLSPAN="2">
      <jsp:include page="/ch12/global/header.jsp"
       flush="true"/>
    </TD>
  </TR>

  <TR>
    <TD ALIGN="LEFT" WIDTH="20%" 
        BGCOLOR="<jsp:getProperty
                name="user"
                property="navBgColor"/>">

      <jsp:include page="/ch12/global/navigation.jsp"
       flush="true"/>
    </TD>

    <TD>
      <%-- Content goes here --%>
      <H1>The JNT Online store!</H1>

      <P>
      Thank you for visiting out store.  The items listed
      below have been carefully designed and hand-crafted to
      be fun, cool, and durable.  Click on an item for more
      information, or you can take a look at the current 
      contents of your <A HREF="shoppingcart.jsp">shopping cart</A>.
      </P>

      <jsp:useBean
       id="catalog"
       class="com.awl.jspbook.ch12.DescriptionsBean"/>

      <% catalog.select(); %>

      <DL>
      <% while (catalog.next()) { %>
      <DT><A HREF="item.jsp?itemid=<jsp:getProperty 
           name="catalog" property="itemid"/>">
          <jsp:getProperty name="catalog" property="name"/></A>
      <DD><jsp:getProperty name="catalog" property="shortdesc"/>
      <% } %>
      </DL>
    </TD>

  </TR>
</TABLE>
</BODY>
</HTML>





