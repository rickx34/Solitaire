import java.util.Random;
public class CardDeck {
	
    private CircularlyLinkedLists<Card> cards;
    private Card currentCard;
    private Card removeCard;
    final static int NUM_OF_CARDS = 52;
    private int listIndex;//this variable is used for getting the next index in the list, used in drawCard()
    
    public CardDeck(){
		cards = new CircularlyLinkedLists<Card>();
		removeCard = null;
		addCards(cards);
		shuffleCards();
		currentCard = drawCard();//cards.getFirst();
		listIndex = 0;
    }
    
    private void addCards(CircularlyLinkedLists<Card> cards){
		int suit = Card.CLUB;//for changing suits, start from clubs
		int suitChanger = 0;//this variable is responsible for changing the suit every 13th run
		
		for(int i = Card.ACE ;i <= NUM_OF_CARDS; i++){
			cards.addLast(new Card(i,suit));//adding cards from Ace to i, and starting carindex from 0
			
			//change suit
			if(i == suitChanger+13){
				suitChanger = suitChanger+13;
				suit++;
			}
		}
	}
	
	public Card drawCard(){
		//get the next index in the list, which basically is drawing the next card
		currentCard = cards.get(cards.indexOf(currentCard)+1);
		if(currentCard.equals(cards.getLast())){
			return currentCard = cards.getFirst();	
		}
		return currentCard;
	}
	
	public boolean isEmpty(){
		return cards.isEmpty();
	}
	
	public Card takeCard(){
		/*Card temp=null;
		if(!cards.contains(currentCard)){
			temp = cards.removeFirst();
		}
		else{
			temp = cards.remove(currentCard);
		}
		return temp;*/
		removeCard = currentCard;
		currentCard = cards.get(cards.indexOf(removeCard)-1);
		cards.remove(removeCard);
		return currentCard;
	}
		
	public void shuffleCards(){
		Random random = new Random();
		for(int i = NUM_OF_CARDS;i > 0; i--){
			int randomInt = random.nextInt(52);
			Card temp = cards.get(randomInt);
			cards.set(randomInt,cards.get(i-1));
			cards.set(i-1,temp);	
		}
	}
	
	public Card getCurrentCard(){
		return currentCard;
	}
	
	public String toString(){
		if(cards.isEmpty()){
			return "Empty";
		}else
			return "Not Empty";
	}

    public static void main(String[] args){
		CardDeck cardss = new CardDeck();
		System.out.println(cardss);
    }
}
