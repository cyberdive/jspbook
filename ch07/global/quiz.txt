<jsp:useBean id="quiz1" class="com.awl.jspbook.ch07.TodaysQuiz"/>

<P>
<jsp:getProperty name="quiz1" property="question"/>
</P>

<FORM ACTION="quizresult.jsp" METHOD="POST">

<INPUT TYPE="radio" NAME="guess" VALUE="1">
<jsp:getProperty name="quiz1" property="answer1"/><BR>

<INPUT TYPE="radio" NAME="guess" VALUE="2">
<jsp:getProperty name="quiz1" property="answer2"/><BR>

<INPUT TYPE="radio" NAME="guess" VALUE="3">
<jsp:getProperty name="quiz1" property="answer3"/><BR>

<INPUT TYPE="Submit" NAME="Go" VALUE="Go">
</FORM>
