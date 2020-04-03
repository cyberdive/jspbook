package com.awl.jspbook.ch07;

public class HangmanBean implements java.io.Serializable {
  private String word;

  private String clue1;
  private String clue2;
  private int    numClues;

  private int numGuessesLeft;
  private int numGuesses;

  private byte wordSoFarA[];
  private String wordSoFar;

  private byte lettersUsedA[];
  private String lettersUsed;


  public String getWord() {return word;}

  public String getClue1() {return clue1;}
  public void setClue1(String clue) {this.clue1 = clue;}

  public String getClue2() {return clue2;}
  public void setClue2(String clue) {this.clue2 = clue;}

  public int getNumGuesses() {return numGuesses;}
  public void setNumGuesses(int numGuesses) {this.numGuesses = numGuesses;}

  public int getNumClues() {return numClues;}
  public void setNumClues(int numClues) {this.numClues = numClues;}

  public int getNumGuessesLeft() {return numGuessesLeft;}
  public void setNumGuessesLeft(int GuessesLeft) {
    this.numGuessesLeft = GuessesLeft;
  }

  

  public void setGuess(String guess) {
    // If this guess is empty, return
    if(guess == null || guess.length() == 0) return;

    // Make sure we're dealing with upper case only
    guess = guess.toUpperCase();

    // If we've already seen this guess, don't do anything
    if (lettersUsed.indexOf(guess) != -1) return;

    // Add this guess to the letters so far
    byte letter = (byte) guess.charAt(0);
    lettersUsedA[letter - 'A'] = letter;
    lettersUsed = new String(lettersUsedA);
    
    // find all the matches in our word
    int pos       = 0;
    boolean found = false;
    while((pos = word.indexOf(letter,pos)) != -1) {
      wordSoFarA[pos] = letter;
      found           = true;
      pos++;
    }

    if (found) {
      wordSoFar = new String(wordSoFarA);
    } else {
      numGuesses++;
      numGuessesLeft--;
    }
  }


  public void setWord(String wordp) {
    word  = wordp.toUpperCase();
    
    wordSoFarA   = new byte[word.length()];
    lettersUsedA = new byte[26];

    for(int i=0;i<word.length();i++) {
      wordSoFarA[i] = '_';
    }

    for(int i=0;i<26;i++) {
      lettersUsedA[i] = '_';
    }

    wordSoFar   = new String(wordSoFarA);
    lettersUsed = new String(lettersUsedA);
    numClues    = 0;
    numGuesses  = 0;
  }
  
  public void setType(String type) {
    if(type.equals("clue")) {
      numClues++;
      numGuesses++;
      numGuessesLeft--;
    }
  }

  public boolean hasWon() {
    return (wordSoFar.indexOf('_') == -1);
  }

  public boolean hasLost() {
    return (numGuessesLeft  < 1);
  }

  public String getWordSoFar() {return wordSoFar;}
  public String getLettersUsed() {return lettersUsed;}
}
