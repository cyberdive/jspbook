<%! String url = "jdbc:postgresql:jspbook"; %>

<%-- Load the JDBC driver class --%>
<% Class.forName("postgresql.Driver"); %>

<%-- Get a connection from the application scope --%>
<% javax.servlet.ServletContext sc = 
   getServletConfig().getServletContext(); %>

<% java.sql.Connection db = 
   (java.sql.Connection) sc.getAttribute("connection"); %>

<% if (db == null)
      db = java.sql.DriverManager.getConnection (url,
                            "dbuser","dbuser");
   sc.setAttribute("connection",db); %>

<%-- Get a statement --%>
<% java.sql.Statement st = db.createStatement(); %>

<%-- Prepare a result set --%>
<% java.sql.ResultSet rs; %>

<HTML>
<HEAD>
  <TITLE>CD info</TITLE>
</HEAD>

<%-- if the user has asked for detail on an album, 
     provide it --%>

<% String albumName = request.getParameter("albumName"); %>
<% String albumId   = request.getParameter("albumId"); %>

<% if(albumName != null) { %>

   <H1>Tracks on "<%= albumName %>"</H1>

   <TABLE BORDER="1">
     <TR><TH>Name</TH><TH>Length</TH></TR>

     <%-- Do the search --%>
     <% rs = st.executeQuery(
        "SELECT name,length from Track " + 
        "WHERE albumId = " + albumId); %>

     <%-- go through the results --%>
     <% while (rs.next()) { %>
        <TR>
          <TD><%= rs.getString("name") %></TD>
          <TD><%= rs.getInt("length") %></TD>
        </TR>
     <% } %>
   </TABLE>
<% } else { %>
   <%-- No album requested, give a list -- %>
   <H1>Select an album:</H1>

   <UL>
     <%-- Do the search --%>
     <% rs = st.executeQuery("SELECT name,albumId from CD "); %>

     <%-- go through the results --%>
     <% while (rs.next()) { %>
          <% String name = rs.getString("name"); %>
          <% String name2 = name.replace(' ','+'); %>
          <LI><A HREF="cdinfo2.jsp?albumName=<%=
              name2 %>&albumId=<%= rs.getInt("albumId") %>">
              <%= name %></A>
     <% } %>
   </UL>
<% } %>

</BODY>
</HTML>

<%-- Clean up after ourselves --%>
<% rs.close(); %>
<% st.close(); %>
