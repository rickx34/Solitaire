public class CardList {

    private LinkedList<Card> cards;
    private int openedIndex;
    private Card tailCard;

    public CardList(int listIndex, CardDeck card) {      
        openedIndex = listIndex;
        cards = new LinkedList<Card>();    
        addCardsToList(card);     
        tailCard = cards.getLast();
    }

    public static void main(String args[]) {
		//test
		CardDeck deck = new CardDeck();
		CardList list1 = new CardList(1,deck);
		CardList list2 = new CardList(2,deck);
		CardList list3 = new CardList(3,deck);
		CardList list4 = new CardList(4,deck);
		
		//list1.link(list2.cut(1));
		//list1.link(list3.cut(2));
		//list3.link(list1.cut(1));
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(list3);
		System.out.println(list4);
		
		
		
    }

    //cut the decklist into two seprate list
    public LinkedList<Card> cut(int index) {
        LinkedList<Card> tempList = new LinkedList<Card>();
        if (index == cards.size()-1) {
            tempList.addLast(moveTail());
            return tempList;
            
        }
        
	    //run as long as index is => openindex, remove element from list & add it to the new list.
        //starts from the very end till "index" which is ((cards.size()-1) - index).
        if (index >= openedIndex-1 && index < cards.size()) {
			int sizeIndex = cards.size() - 1;
            for (int i = 0; i <= (sizeIndex - index); i++) {
                tempList.add(i, cards.removeLast());;
            }
            //if list is cut from openindex then openindex--
            openedIndex = cards.size();
            if(cards.isEmpty())
	            tailCard = null;
	        else
				tailCard = cards.getLast();
        }
        return tempList;
    }
    
    //link one list to another
    public boolean link(LinkedList<Card> other) {
		boolean bool = false;
		int size = other.size();
        for (int i = 0; i < size; i++) {
            add(other.removeLast());
            
            if(other.isEmpty()){
				bool = true;
			}
			else{
				bool = false;
			}	
        }
        return bool;      
    }

    public boolean add(Card c) {
		//if list is empty add king
		if(cards.isEmpty() && c.getValue() == Card.KING){
			cards.addLast(c);
			return true;
		}
		//special case for adding queen below king
       else if(c.getValue() == Card.QUEEN && cards.getLast().getValue() == Card.KING
			&& !c.getColor().equals(cards.getLast().getColor())){
			
            cards.addLast(c);
            tailCard = cards.getLast();
            return true;
        }
        else if (c.getValue() == (cards.getLast().getValue()-1) && !c.getColor().equals(cards.getLast().getColor())) {
            cards.addLast(c);
            tailCard = cards.getLast();
            return true;
        } else {
            return false;
        }
    }

    public Card moveTail() {
		if(cards.size() == 1){
			Card temp = cards.remove(tailCard);
			tailCard = null;
			openedIndex = cards.size();
			return temp;
		}
        Card temp = cards.remove(tailCard);
        tailCard = cards.getLast();
        openedIndex = cards.size();
        return temp;
    }
    
    public LinkedList<Card> getCards(){
		return cards;
	}

    //add cards to this list and remove from cardDeck depending on listindex which is from 1 to 7
    public void addCardsToList(CardDeck deck) {
	
		//without the if statement it would get a noElementError
        for (int i = 0; i < openedIndex; i++) { 
            cards.addLast(deck.takeCard());           
        }
        if(openedIndex > 0)
	        tailCard = cards.getLast();
    }
    
    public int getOpenIndex(){
		return openedIndex;
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
