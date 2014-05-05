public class Solitaire {
	
	CardDeck deck;
	CardStack[] stacks;
	CardList[] lists;
	
	public Solitaire(){
		deck = new CardDeck();
		stacks = new CardStack[4];
		lists = new CardList[7];
		//initialise
		for(int i = 0; i < stacks.length; i++){
			stacks[i] = new CardStack();
		}
		for(int i = 0; i < lists.length; i++){
			lists[i] = new CardList(i+1);
		}
	}
	
	public String toString(){
		//for(int i = 0; i<)
		return null;
	}
	
	public static void main (String args[]) {
		Solitaire tare = new Solitaire();
		System.out.println(tare.lists[6]);
	}
}

