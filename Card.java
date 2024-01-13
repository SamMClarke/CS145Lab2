public class Card
{
    private final int face;
    private final String suit;
    private final String faceAsString;

    public Card(int cardFace, String cardSuit, String cardFaceAsString)
    {
        this.face = cardFace;
        this.suit = cardSuit;
        this.faceAsString = cardFaceAsString;
    }

    public int getFace()
    {
        return this.face;
    }

    public String getSuit()
    {
        return this.suit;
    }

    public String getFaceAsString()
    {
        return this.faceAsString;
    }

    public String toString()
    {
        return faceAsString + " of " + suit;
    }
}