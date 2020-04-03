<jsp:useBean id="quiz" 
  class="com.awl.jspbook.ch10.QuizBean"/>


<P>
<jsp:getProperty name="quiz" property="question"/>
</P>

<FORM ACTION="quizresult.jsp" METHOD="POST">

<INPUT TYPE="radio" NAME="guess" VALUE="1">
<jsp:getProperty name="quiz" property="answer1"/><BR>

<INPUT TYPE="radio" NAME="guess" VALUE="2">
<jsp:getProperty name="quiz" property="answer2"/><BR>

<INPUT TYPE="radio" NAME="guess" VALUE="3">
<jsp:getProperty name="quiz" property="answer3"/><BR>

<INPUT TYPE="Submit" NAME="Go" VALUE="Go">
</FORM>
