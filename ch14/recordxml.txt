<% response.setContentType("text/xml"); %>

<jsp:useBean id="album" 
 class="com.awl.jspbook.ch14.Tinderbox"/>


<RECORD>
  <TITLE>
    <jsp:getProperty name="album" property="name"/>
  </TITLE>

  <ARTIST>
    <jsp:getProperty name="album" property="artist"/>
  </ARTIST>

  <YEAR>
    <jsp:getProperty name="album" property="year"/>
  </YEAR>

  <% String tracks[] = album.getTracks(); %>

  <TRACKS>
    <% for(int i=0;i<tracks.length;i++) { %>
      <TRACKNAME><%= tracks[i] %></TRACKNAME>
    <% } %>
  </TRACKS>
</RECORD>

