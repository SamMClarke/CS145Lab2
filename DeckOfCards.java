import java.security.SecureRandom;

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

    private Card dealCard()
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

    public Card[] getHand()
    {
        return this.hand;
    }

    private boolean isPair()
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

    private boolean isTwoPair()
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

    private boolean isThreeOfAKind()
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

    private boolean isFourOfAKind()
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

    private boolean isFlush()
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

    private boolean isStright()
    {
        boolean hasStraight = true;
        for (int i = 1; i < hand.length; i++)
        {
            if (hand[i-1].getFace() + 1 != (hand[i].getFace()))
            {
                if (hand[i-1].getFace() != 5 && hand[i].getFace() != 14)
                {
                    hasStraight = false;
                }
            }
        }
        return hasStraight;
    }

    private int evalulateStrength()
    {
        int strength = 0;
        if (isFlush() && isStright() && hand[0].getFace() == 10)
        {
            strength = 9;
        }
        else if (isFlush() && isStright())
        {
            strength = 8;
        }
        else if (isFourOfAKind())
        {
            strength = 7;
        }
        else if (isTwoPair() && isThreeOfAKind())
        {
            strength = 6;
        }
        else if (isFlush())
        {
            strength = 5;
        }
        else if (isStright())
        {
            strength = 4;
        }
        else if (isThreeOfAKind())
        {
            strength = 3;
        }
        else if (isTwoPair())
        {
            strength = 2;
        }
        else if (isPair())
        {
            strength = 1;
        }
        else 
        {
            strength = 0;
        }
        return strength;
    }

    public String compareHands(DeckOfCards other)
    {
        String message = ""; 
        if (evalulateStrength() > other.evalulateStrength())
        {
            message = "Hand 1 is stronger than hand 2";
        }
        else if (evalulateStrength() < other.evalulateStrength())
        {
            message = "Hand 1 is weaker than hand 2";
        }
        else
        {
            message = "Hand 1 is equal in strength to hand 2";
        }
        return message;
    }
}