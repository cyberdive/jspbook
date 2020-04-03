<% String indexTag      = "&sect;"; %>
<% String industryTag   = "&sect;"; %>
<% String enterpriseTag = "&sect;"; %>
<% String standardTag   = "&sect;"; %>
<% String microTag      = "&sect;"; %>
<% String beanTag       = "&sect;"; %>
<% String editorialTag  = "&sect;"; %>


<% if (request.getRequestURI().indexOf("index") != -1)
   indexTag = "&raquo;"; %>

<% if (request.getRequestURI().indexOf("industry") != -1)
   industryTag = "&raquo;"; %>

<% if (request.getRequestURI().indexOf("enterprise") != -1)
   enterpriseTag = "&raquo;"; %>

<% if (request.getRequestURI().indexOf("standard") != -1)
   standardTag = "&raquo;"; %>

<% if (request.getRequestURI().indexOf("micro") != -1)
   microTag = "&raquo;"; %>

<% if (request.getRequestURI().indexOf("bean") != -1)
   beanTag = "&raquo;"; %>

<% if (request.getRequestURI().indexOf("editorial") != -1)
   editorialTag = "&raquo;"; %>


<%-- Begin Navigation --%>
<FONT COLOR="FFFFFF">
<FONT COLOR="#FF0000"><%= indexTag %></FONT>
Home Page<BR>

<FONT COLOR="#FF0000"><%= industryTag %></FONT>
Industry news<BR>

<FONT COLOR="#FF0000"><%= enterpriseTag %></FONT>
Enterprise Java<BR>

<FONT COLOR="#FF0000"><%= standardTag %></FONT>
Standard Edition Java<BR>

<FONT COLOR="#FF0000"><%= microTag %></FONT>
Micro edition &amp; devices<BR>

<FONT COLOR="#FF0000"><%= beanTag %></FONT>
Beans<BR>

<FONT COLOR="#FF0000"><%= editorialTag %></FONT>
Editorials<BR>


<HR>
Today's quiz:<BR>
<jsp:include page="/ch07/global/quiz.jsp"
 flush="true"/>
<%-- End Navigation --%>

