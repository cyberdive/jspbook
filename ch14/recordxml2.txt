<jsp:root
   xmlns:jsp="http://java.sun.com/products/jsp/dtd/jsp_1_0.dtd">

<jsp:scriptlet>
  response.setContentType("text/xml");
</jsp:scriptlet>

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

  <jsp:scriptlet>
    String tracks[] = album.getTracks();
  </jsp:scriptlet>

  <TRACKS>
    <jsp:scriptlet>
     for(int i=0;i<tracks.length;i++) {
    </jsp:scriptlet>
      <TRACKNAME>
        <jsp:expression>tracks[i]</jsp:expression>
      </TRACKNAME>
    <jsp:scriptlet>}</jsp:scriptlet>
  </TRACKS>
</RECORD>

</jsp:root>
