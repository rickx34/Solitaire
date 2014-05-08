
public class CardList {

    private LinkedList<Card> cards;
    private int openedIndex;
    private Card tailCard;

    public CardList(int listIndex, CardDeck card) {      
        openedIndex = listIndex;
        cards = new LinkedList<Card>();    
        addCardsToList(card);     
    }

    public static void main(String args[]) {
		for(int i = 0;i<7;i++){
			
			//test
	        CardList list = new CardList(i+1,new CardDeck());
	        System.out.println(list);
		}
    }

    //cut the decklist into two seprate list
    public LinkedList<Card> cut(int index) {
        LinkedList<Card> tempList = new LinkedList<Card>();
        if (index == cards.size()) {
            moveTail();
        }
        
	    //run as long as index is => openindex, remove element from list & add it to the new list.
        //starts from the very end till "index" which is ((cards.size()-1) - index).
        if (index >= openedIndex - 1 && index < cards.size()) {
            for (int i = 0; i <= ((cards.size() - 1) - index); i++) {
                tempList.add(i, cards.removeLast());
                System.out.println("index " + cards.size());
            }
            //if list is cut from openindex then openindex--
            openedIndex = cards.size();
            tailCard = cards.getLast();
        }
        return tempList;
    }

    public void link(LinkedList<Card> other) {
        for (int i = 0; i < other.size(); i++) {
            add(other.get(i));
        }
    }

    public boolean add(Card c) {
		//special case for adding queen below king
       if(c.getValue() == Card.QUEEN && cards.getLast().getValue() == Card.KING){
            cards.addLast(c);
            tailCard = cards.getLast();
            return true;
        }
        if (c.getValue() == (cards.getLast().getValue()-1) && !c.getColor().equals(cards.getLast().getColor())) {
            cards.addLast(c);
            tailCard = cards.getLast();
            return true;
        } else {
            return false;
        }
    }

    public Card moveTail() {
        Card temp = cards.remove(tailCard);
        tailCard = cards.getLast();
        openedIndex = cards.size();
        return temp;
    }

    //add cards to this list and remove from cardDeck depending listIndex
    public void addCardsToList(CardDeck deck) {
	
		//without the if statement if would get a noElementError
        for (int i = 0; i < openedIndex; i++) {   								
            cards.addLast(deck.takeCard());           
        }
        if(openedIndex > 0)
	        tailCard = cards.getLast();
    }

    public String toString() {
        String str = "";
        for (int i = 1; i <= cards.size(); i++) {
				
            if (i < openedIndex) {
                str += "BACK ";//back of a card
            }

            if (i >= openedIndex) {
                str += cards.get(i - 1).toString();
            }
        }
        return str;
    }
}
