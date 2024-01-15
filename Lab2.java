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
            System.out.printf("%-19s", (myDeckOfCards.getHand())[i]);
        }
        System.out.println("\nSecond hand of cards:");
        for (int i = 0; i < 5; i++)
        {
            System.out.printf("%-19s", (mySecondDeckOfCards.getHand())[i]);
        }

        //Show results
        System.out.println("\nResults:");
        System.out.println(myDeckOfCards.compareHands(mySecondDeckOfCards));
    }
}