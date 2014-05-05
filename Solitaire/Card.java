
public class Card {
	
    private int cardIndex;
    private final int suit;
    public static final int ACE = 1;
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    public static final int CLUB = 0;
    public static final int SPADE = 1;
    public static final int DIAMOND = 2;
    public static final int HEART = 3;
	
    public Card(int cardIndex, int suit)
    {
		this.cardIndex = cardIndex%13;
		this.suit = suit;
    }
	
    public static void main (String args[]) {
		
		Card card = new Card(52,SPADE);
		System.out.println(card);
    }
	
    public int getSuit()
    {
		return suit;
    }
	
    public int getValue()
    {
		return cardIndex;
	}
	
	public String getValueString(){
		if(cardIndex == ACE)
	    {
			return "Ace";
		}
		else if(cardIndex == JACK){
			return "Jack";
		}
		else if(cardIndex == QUEEN){
			return "Queen";
		}
		else if(cardIndex == KING){
			return "King";
		}
		else{
			return Integer.toString(cardIndex);
		}
	}
	
	public String getColor(){
		if(getSuit() == CLUB || getSuit() == SPADE)
			return "Black";
		else
		return "Red";
	}
	
	public String toString(){
		String str = "";
		if(getSuit() == CLUB)
			str ="Club";
		else if(getSuit() == SPADE)
			str ="Spade";
		else if(getSuit() == DIAMOND)
			str= "Diamond";
		else if(getSuit() == HEART)
			str= "Heart";
		
		if(getValueString().equals("10"))
			return str + getValueString().substring(0,2);
		else
			return str + getValueString().charAt(0);
	}
	
	
}

