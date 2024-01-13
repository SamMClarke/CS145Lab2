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
        
        for (int i = 0; i < 5; i++)
        {
            System.out.printf("%-19s", (myDeckOfCards.getHand())[i]);
        }
        System.out.println();
        for (int i = 0; i < 5; i++)
        {
            System.out.printf("%-19s", (mySecondDeckOfCards.getHand())[i]);
        }
        System.out.println();

        System.out.println(myDeckOfCards.compareHands(mySecondDeckOfCards));
    }
}