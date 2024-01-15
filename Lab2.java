public class Lab2
{
    public static void main(String[] args)
    {
        DeckOfCards myDeckOfCards = new DeckOfCards();
        DeckOfCards mySecondDeckOfCards = new DeckOfCards();
        myDeckOfCards.shuffle();
        mySecondDeckOfCards.shuffle();
        myDeckOfCards.dealHand();
        mySecondDeckOfCards.dealHand();
        
        System.out.println("First hand of cards:");
        for (int i = 0; i < 5; i++)
        {
            System.out.printf("%-19s", (myDeckOfCards.getHand())[i]);
        }
        System.out.println("\nSecond hand of cards:");
        for (int i = 0; i < 5; i++)
        {
            System.out.printf("%-19s", (mySecondDeckOfCards.getHand())[i]);
        }

        System.out.println("\nResults:");
        System.out.println(myDeckOfCards.compareHands(mySecondDeckOfCards));
    }
}