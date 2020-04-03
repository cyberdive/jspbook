<%! int count = 0; %>

<HTML>
<BODY>

<P>
This page has been accessed <%= count %> times.
</P>

<% HttpSession theSession = request.getSession(true); %>
<% Integer scount = 
   (Integer) theSession.getValue("scount"); %>

<% if (scount == null) { %>
<P>
This is your first visit to this page!
</P>

<% theSession.putValue("scount",new Integer(1)); %>

<% } else { %>

<P>
You have accessed this page
<%= scount %> times.
</P>

<% theSession.putValue("scount",
       new Integer(scount.intValue() + 1)); %>
<% } %>

<% count++; %>

</BODY>
</HTML>
