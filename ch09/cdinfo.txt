<%-- Load the JDBC driver class --%>
<% Class.forName("postgresql.Driver"); %>

<%-- Get a connection --%>
<% java.sql.Connection db = 
   java.sql.DriverManager.getConnection (
                          "jdbc:postgresql:jspbook",
                          "dbuser","dbuser"); %>

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

<% String albumname = request.getParameter("albumname"); %>
<% String albumid   = request.getParameter("albumid"); %>

<% if(albumname != null) { %>

  <%-- Ensure the input is valid --%>
  <% int aId = 0; %>

  <% try {aId = Integer.parseInt(albumid);}
     catch (NumberFormatException e) { %>

  <P>Your input was invalid</P>

  <% } %>


   <H1>Tracks on "<%= albumname %>"</H1>

   <TABLE BORDER="1">
     <TR><TH>Name</TH><TH>Length</TH></TR>

     <%-- Do the search --%>
     <% rs = st.executeQuery(
        "SELECT name,length from track " + 
        "WHERE albumid = " + aId + ";"); %>

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
     <% rs = st.executeQuery("SELECT name,albumid from cd; "); %>

     <%-- go through the results --%>
     <% while (rs.next()) { %>
          <% String name = rs.getString("name"); %>
          <% String name2 = name.replace(' ','+'); %>
          <LI><A HREF="cdinfo.jsp?albumname=<%=
              name2 %>&albumid=<%= rs.getInt("albumid") %>">
              <%= name %></A>
     <% } %>
   </UL>
<% } %>

</BODY>
</HTML>

<%-- Clean up after ourselves --%>
<% rs.close(); %>
<% st.close(); %>
<% db.close(); %>
