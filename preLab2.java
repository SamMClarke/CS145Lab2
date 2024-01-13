/*
Sam Clarke
1/12/2024
CS 145

This program evalulates poker hands and tells the user which hand is better.
*/ 

//A lot of the methods will be directly taken from the textbook,
//but these are the ones that I will write myself

//Gets the face value of a given card as an integer (ex, 13 = king, 12 = queen, etc.)
public int getFace()
//Simply returns the face value using this.face

//Gets the suit value of a given card
public String getSuit()
//Simply returns the suit value using this.suit

//Gets the face value of a given card as a String (ex. Ace, King, etc.)
public String getFaceAsString()
//Simply returns the face value using this.faceAsString

//Deals five cards to the users "hand"
public void dealHand()
//Deals 5 cards to the player using the dealCard() method from the textbook,
//and stores them in a hand[] array.

//Gets the poker hand
public Card[] getHand()
//Simply returns the hand array using this.hand

//Sorts the hand in ascending order
public void sortHand()
//Using nested for loops, go through each element of the array and swap it,
//if it is out of order. Do this for all elements and the array should be fully sorted.

//Determines whether a hand contains a pair
public boolean isPair()
//Using a for loop, cycle through the face values of each card in a hand
//checking if any other card has the same face value. If one does, return true. 
//Otherwise return false

//Determines whether a hand contains two pairs
public boolean isTwoPair()
//Using a for loop, cycle through the face values of each card in a hand
//checking if any other card has the same face value. If one does, store its
//value in a pairValue variable, and keep interating through the hand. 
//If another pair is found and its value isn't equal to pairValue, another
//pair has been found and return true

//Determines whether a hand contains three of a kind
public boolean isThreeOfAKind()
//Using a for loop, cycle through the face values of each card in a hand
//checking if any other card has the same face value. If two such cards exist
//return true

//Determines whether a hand contains four of a kind
public boolean isFourOfAKind()
//Using a for loop, cycle through the face values of each card in a hand
//checking if any other card has the same face value. If 3 such cards exist
//return true

//Determines whether a hand contains a flush
public boolean isFlush()
//Using a for loop, cycle through the suit values of each card in a hand
//checking if any other card has the suit face value. If all the cards have
//the same suit, return true.

//Determines whether a hand contains a straight
public boolean isStraight()
//Start at the first element of the hand array and check if the next element
//has a face value of 1 more than it. If this continues all the way down the array, return true

//Determines whether a hand contains a full house
public boolean isFullHouse()
//Using methods above, if a hand isTwoPair AND isThreeOfAKind, then return true

//Evalulates a hands strength
public int evalulateStrength()
//Using the methods above, evalulate the strength of a given hand
//and return a strength value with 0 being a weak hand and 9 being the strongest

//Compares two hands and determines which is stronger
public Card[] compareHands()
//Using evalulateStrength return which hand has a higher strength value