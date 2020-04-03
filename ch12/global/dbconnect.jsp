<%-- Create the connection, if it does not yet exist --%>

<jsp:useBean 
     id="dbConnection" 
     class="com.awl.jspbook.ch12.PersistentConnection"
     scope="application">

  <%-- If we are creating this bean now, initialize it --%>
  <jsp:setProperty
       name="dbConnection"
       property="dbUserName"
       value="dbuser"/>

  <jsp:setProperty
       name="dbConnection"
       property="dbPassword"
       value="dbuser"/>

  <jsp:setProperty
       name="dbConnection"
       property="dbClass"
       value="postgresql.Driver"/>

  <jsp:setProperty
       name="dbConnection"
       property="url"
       value="jdbc:postgresql:jspbook"/>

</jsp:useBean>

