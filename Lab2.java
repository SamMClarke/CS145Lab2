/*
Authors: Sam Clarke, Nick Ivancovich, Jeong Gyu Tak
Date: 1/16/2024
Class: CS 145
Assignment: Lab #2: Card Shuffling and Dealing Program
File: Lab2.java
Source: Deitel / Deitel
Purpose: Creates and evalutates two poker hands
*/

public class Lab2
{
    public static void main(String[] args)
    {
        //Initialize, shuffle, and deal hands for two "players"
        DeckOfCards myDeckOfCards = new DeckOfCards();
        DeckOfCards mySecondDeckOfCards = new DeckOfCards();
        myDeckOfCards.shuffle();
        mySecondDeckOfCards.shuffle();
        myDeckOfCards.dealHand();
        mySecondDeckOfCards.dealHand();

        //Print both hands
        System.out.println("First hand of cards:");
        for (int i = 0; i < 5; i++)
        {
            System.out.printf("%-19s\n", (myDeckOfCards.getHand())[i]);
        }

        System.out.println("\n\nSecond hand of cards:");
        for (int i = 0; i < 5; i++)
        {
            System.out.printf("%-19s\n", (mySecondDeckOfCards.getHand())[i]);
        }

        //Show results
        System.out.println("\n\nResults:");
        System.out.println(myDeckOfCards.compareHands(mySecondDeckOfCards));
    }
}