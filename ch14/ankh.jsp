<% response.setContentType("image/gif"); %><jsp:useBean 
id="ankh" 
class="com.awl.jspbook.ch14.AnkhBean"/><jsp:setProperty 
name="ankh" 
property="*"/><jsp:getProperty 
name="ankh" property="ankh"/>