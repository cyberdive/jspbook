<HTML>
<HEAD><TITLE>Hangman</TITLE></HEAD>

<BODY>

<jsp:useBean id="game"
 class="com.awl.jspbook.ch07.HangmanBean"
 scope="session">

  <%-- this is done when the bean is first created --%>

  <P>Welcome to hangman, JSP edition!</P>
  <P>
  At each turn, you may either guess a letter
  or ask for a clue.  Getting a clue or guessing
  a letter that is not in the word costs you
  one turn.  Good luck!
  </P>

  <jsp:setProperty name="game"
   property="word"
   value="disintegration"/>

  <% String tmp ="One of the kids on \"South Park\" once " +
     "called this 'The greatest album ever.'"; %>

  <jsp:setProperty name="game"
   property="clue1" 
   value="<%= tmp %>"/>

  <jsp:setProperty 
   name="game"
   property="clue2" 
   value="The Cure's 1989 release."/>

  <jsp:setProperty
   name="game"
   property="numGuessesLeft"
   value="7"/>
</jsp:useBean>

<%-- everything else is outside the useBean tag,
     so it will happen for every request --%>

<%-- Load the form variables --%>
<jsp:setProperty name="game" property="*"/>

<% if(game.hasLost()) { %>
    <%-- Do this if the user has lost --%>
    <P>
    Sorry, you're out of turns!  The word was
    "<jsp:getProperty name="game" property="word"/>"
    </P>

    <P>
    Better luck next time!
    </P>

<% } else if(game.hasWon()) { %>
    <%-- Do this if the user has won --%>
    <P>
    You've won!  You guessed the word
    <jsp:getProperty name="game" property="word"/>
    with
    <jsp:getProperty name="game" property="numGuessesLeft"/>
    guesses left!
    </P>

<% } else { %>
    <%-- The JSP comes here if the game
      has neither been won or lost --%>

    <P>
    Word so far:
    <jsp:getProperty name="game" property="wordSoFar"/>
    </P>

    <P>
    Letters used:
    <jsp:getProperty name="game" property="lettersUsed"/>
    </P>

    <P>Clues:</P>
    <UL>

    <% if(game.getNumClues() == 1) { %>
      <LI><jsp:getProperty name="game" property="clue1"/>
    <% } %>


    <% if(game.getNumClues() == 2) { %>
      <LI><jsp:getProperty name="game" property="clue1"/>
      <LI><jsp:getProperty name="game" property="clue2"/>
    <% } %>

    </UL>

    <FORM ACTION="hangman.jsp" METHOD="POST">
      <P>
      What would you like to do:<BR>
      <INPUT TYPE="radio" NAME="type" VALUE="guess">
      Guess the letter:
      <INPUT TYPE="TEXT" NAME="guess" SIZE="1"><BR>

      <INPUT TYPE="radio" NAME="type" VALUE="clue">
      Get a clue
      </P>

      <INPUT TYPE="SUBMIT" NAME="Ok" VALUE="Ok">
    </FORM>

    <P>
    You have
    <jsp:getProperty name="game" property="numGuessesLeft"/>
    guesses remaining.
<% } %>

</BODY>
</HTML>