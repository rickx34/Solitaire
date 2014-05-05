public class CardList {
	
	private LinkedList<Card> cards;
	private int openedIndex;
	private Card tailCard;
	
	public CardList(int listIndex){
		openedIndex = listIndex;
		cards = new LinkedList<Card>();
		CardDeck card = new CardDeck();
		addCardsToList(card);
		tailCard = null;
	}
	
	public static void main (String args[]) {
		CardList list = new CardList(7);
		LinkedList<Card> ls = list.cut(6);
		System.out.println(list);
	}
	
	//cut the decklist into two seprate list
	public LinkedList<Card> cut(int index){
		LinkedList<Card> tempList = new LinkedList<Card>();
		
		//run as long as index is => openindex, remove element from list & add it to the new list.
		//starts from the very end till "index" which is ((cards.size()-1) - index).
		if(index >= openedIndex-1 && index<cards.size()){	
			for(int i = 0;i <= ((cards.size()-1) - index);i++){
				tempList.add(i,cards.removeLast());
			}
			
			//if list is cut from openindex then openindex--
			if(index == openedIndex-1){
				openedIndex = cards.size()-1;;
			}
			tailCard = cards.getLast();
		}
		return tempList;
	}
	
	public void add(Card c){
		if(c.getValue() < cards.getLast().getValue() && !c.getColor().equals(cards.getLast().getColor())){
			
			cards.addLast(c);
			tailCard = cards.getLast();;
		}
	}
	
	//add cards to this list and remove from cardDeck depending listIndex
	private void addCardsToList(CardDeck deck){
		for(int i = 0;i < openedIndex;i++){
			cards.addLast(deck.drawCard());
			deck.takeCard();
		}	
	}
	
	public String toString(){
		return cards.toString();
	}
}

