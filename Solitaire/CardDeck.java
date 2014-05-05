import java.util.Random;
public class CardDeck {
	
    private CircularlyLinkedLists<Card> cards;
    private Card currentCard;
    final static int NUM_OF_CARDS = 52;
    private int listIndex;//this variable is used for getting the next index in the list, used in drawCard()
    
    public CardDeck(){
		cards = new CircularlyLinkedLists<Card>();
		addCards(cards);
		shuffleCards();
		currentCard = cards.getFirst();
		listIndex = 0;
    }
    
    private void addCards(CircularlyLinkedLists<Card> cards){		
		int suit = Card.CLUB;//for changing suits, start from clubs
		int suitChanger = 0;//this variable is responsible for changing the suit every 13th run
		
		for(int i = 0 ;i < NUM_OF_CARDS; i ++){
			cards.addLast(new Card(i,suit));//adding cards from 0 to i, and starting carindex from 0
			
			//change suit
			if(i == suitChanger+12){
				suitChanger = suitChanger+13;
				suit++;
			}
		}
	}
	
	public Card drawCard(){
	//get the next index in the list, which basically is drawing the next card
		if(!currentCard.equals(cards.getLast())){
			currentCard = cards.get(listIndex);
			listIndex++;
			return currentCard;
			
		}else
			return null;
	}
	
	public Card takeCard(){
		Card temp = cards.remove(currentCard);
		return temp;
	}
	
	public void shuffleCards(){
		Random random = new Random();
		for(int i = NUM_OF_CARDS;i > 0; i-- ){
			int randomInt = random.nextInt(52);
			Card temp = cards.get(randomInt);
			cards.set(randomInt,cards.get(i-1));
			cards.set(i-1,temp);	
		}
	}
	
	public String toString(){
		return cards.toString();
	}

    public static void main(String[] args){
		CardDeck cardss = new CardDeck();
		System.out.println(cardss);
    }
}

