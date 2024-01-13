public class Lab2
{
    public static void main(String[] args)
    {
        DeckOfCards myDeckOfCards = new DeckOfCards();
        myDeckOfCards.shuffle();
        myDeckOfCards.dealHand();
        
        for (int i = 0; i < 5; i++)
        {
            System.out.printf("%-19s", (myDeckOfCards.getHand())[i]);
        }
    }
}