import java.security.SecureRandom;
import java.util.*;
import java.lang.Integer;

public class DeckOfCards
{
    private static final SecureRandom randomNumbers = new SecureRandom();
    private static final int NUMBER_OF_CARDS = 52;
    private static final int POKER_HAND_CARDS = 5;

    private Card[] deck = new Card[NUMBER_OF_CARDS];
    private Card[] hand = new Card[POKER_HAND_CARDS];
    private int currentCard = 0;

    public DeckOfCards()
    {
        int[] faces = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        String[] facesAsString = {"Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        for (int count = 0; count < deck.length; count++)
        {
            deck[count] = new Card(faces[count % 13], suits[count / 13], facesAsString[count % 13]);
        }
    }

    public void shuffle()
    {
        currentCard = 0;

        for (int first = 0; first < deck.length; first++)
        {
            int second = randomNumbers.nextInt(NUMBER_OF_CARDS);

            Card temp = deck[first];
            deck[first] = deck[second];
            deck[second] = temp;
        }
    }

    public Card dealCard()
    {
        if (currentCard < deck.length)
        {
            return deck[currentCard++];
        }
        else
        {
            return null;
        }
    }

    public void dealHand()
    {
        for (int i = 0; i < POKER_HAND_CARDS; i++)
        {
            hand[i] = dealCard();
        }
        sortHand(hand);
    }

    public Card[] getHand()
    {
        return this.hand;
    }

    private void sortHand(Card[] handSorted)
    {
        Card temp = new Card(0, null, null);
        for (int i = 0; i < handSorted.length; i++)
        {
            for (int j = i+1; j < handSorted.length; j++)
            {
                if (handSorted[i].getFace() > handSorted[j].getFace())
                {
                    temp = handSorted[i];
                    handSorted[i] = handSorted[j];
                    handSorted[j] = temp;
                }
            }
        }
    }

}