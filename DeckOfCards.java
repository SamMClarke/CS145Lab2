import java.security.SecureRandom;

public class DeckOfCards
{
    //Initialize variables
    private static final SecureRandom randomNumbers = new SecureRandom();
    private static final int NUMBER_OF_CARDS = 52;
    private static final int POKER_HAND_CARDS = 5;

    private Card[] deck = new Card[NUMBER_OF_CARDS];
    private Card[] hand = new Card[POKER_HAND_CARDS];
    private int currentCard = 0;

    public DeckOfCards() //Fills deck array with cards. Each card has a face (as number), face (as string), and suit
    {
        int[] faces = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        String[] facesAsString = {"Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        for (int count = 0; count < deck.length; count++)
        {
            deck[count] = new Card(faces[count % 13], suits[count / 13], facesAsString[count % 13]);
        }
    }

    public void shuffle() //Shuffles the deck
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

    private Card dealCard() //Deals one card to the hand
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

    public void dealHand() //Deals five cards to the hand
    {
        for (int i = 0; i < POKER_HAND_CARDS; i++)
        {
            hand[i] = dealCard();
        }
        sortHand(hand);
    }

    private void sortHand(Card[] handSorted) //Sorts hand in ascending order
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

    public Card[] getHand() //Returns the hand
    {
        return this.hand;
    }

    private boolean isPair() //Checks if deck contains a pair
    {
        boolean hasPair = false;
        for (int i = 0; i < hand.length; i++)
        {
            for (int j = i + 1; j < hand.length; j++)
            {
                if(hand[i].getFace() == hand[j].getFace())
                {
                    hasPair = true;
                }
            }
        }
        return hasPair;
    }

    private boolean isTwoPair() //Checks if the deck contains two pairs
    {
        boolean hasTwoPair = false;
        boolean hasOnePair = false;
        int pairValue = 0;
        for (int i = 0; i < hand.length; i++)
        {
            for (int j = i + 1; j < hand.length; j++)
            {
                if(hand[i].getFace() == hand[j].getFace())
                {
                    if(!hasOnePair)
                    {
                        hasOnePair = true;
                        pairValue = hand[i].getFace();
                    }
                    else if (hand[i].getFace() != pairValue)
                    {
                        hasTwoPair = true;
                    }
                }
            }
        }
        return hasTwoPair;
    }

    private boolean isThreeOfAKind() //Checks if the deck contains three of a kind
    {
        boolean hasThreeOfAKind = false;
        int kinds = 1;
        for (int i = 0; i < hand.length; i++)
        {
            kinds = 0;
            for (int j = i + 1; j < hand.length; j++)
            {
                if(hand[i].getFace() == hand[j].getFace())
                {
                    kinds++;
                }
            }
            if (kinds == 3)
            {
                hasThreeOfAKind = true;
            }
        }
        return hasThreeOfAKind;
    }

    private boolean isFourOfAKind() //Checks if the deck contains for of a kind
    {
        boolean hasFourOfAKind = false;
        int kinds = 1;
        for (int i = 0; i < hand.length; i++)
        {
            kinds = 0;
            for (int j = i + 1; j < hand.length; j++)
            {
                if(hand[i].getFace() == hand[j].getFace())
                {
                    kinds++;
                }
            }
            if (kinds == 4)
            {
                hasFourOfAKind = true;
            }
        }
        return hasFourOfAKind;
    }

    private boolean isFlush() //Checks if the deck has all the same suit
    {
        boolean hasFlush = true;
        for (int i = 1; i < hand.length; i++)
        {
            if (!hand[0].getSuit().equals(hand[i].getSuit()))
            {
                hasFlush = false;
            }
        }
        return hasFlush;
    }

    private boolean isStright() //Checks if the deck contains cards in order
    {
        boolean hasStraight = true;
        for (int i = 1; i < hand.length; i++)
        {
            if (hand[i-1].getFace() + 1 != (hand[i].getFace()))
            {
                hasStraight = false;
                break;
            }
        }
        if (hand[0].getFace() == 2 && hand[1].getFace() == 3 && hand[2].getFace() == 4 && 
        hand[3].getFace() == 5 && hand[4].getFace() == 14) //Ace can either be high or low
        {
            hasStraight = true;
        }
        return hasStraight;
    }

    public int evalulateStrength() //Evaluates the strength of the hand
    {
        int strength = 0;

        if (isFlush() && isStright() && hand[0].getFace() == 10)
        {
            strength = 9;
            System.out.println("This hand is a royal flush!");
        }
        else if (isFlush() && isStright())
        {
            strength = 8;
            System.out.println("This hand is a straight flush!");
        }
        else if (isFourOfAKind())
        {
            strength = 7;
            System.out.println("This hand is a four of a kind!");
        }
        else if (isTwoPair() && isThreeOfAKind())
        {
            strength = 6;
            System.out.println("This hand is a full house!");
        }
        else if (isFlush())
        {
            strength = 5;
            System.out.println("This hand is a flush!");
        }
        else if (isStright())
        {
            strength = 4;
            System.out.println("This hand is a straight!");
        }
        else if (isThreeOfAKind())
        {
            strength = 3;
            System.out.println("This hand is a three of a kind!");
        }
        else if (isTwoPair())
        {
            strength = 2;
            System.out.println("This hand is a two pair!");
        }
        else if (isPair())
        {
            strength = 1;
            System.out.println("This hand is a pair!");
        }
        else 
        {
            strength = 0;
            System.out.println("This hand sucks!");
        }
        return strength;
    }

    public String compareHands(DeckOfCards other) //Compares the strength of one hand to another
    {
        String message = "";
        System.out.print("First hand: ");
        int thisStrength = evalulateStrength();
        System.out.print("\nSecond hand: ");
        int otherStrength = other.evalulateStrength();

        if (thisStrength > otherStrength)
        {
            message = "\nHand 1 is stronger than hand 2";
        }
        else if (thisStrength < otherStrength)
        {
            message = "\nHand 1 is weaker than hand 2";
        }
        else
        {
            message = "\nHand 1 is equal in strength to hand 2";
        }
        return message;
    }
}