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
	
	public boolean executeCommand(String command){
		return false;
	}
	
	public static void main (String args[]) {
		Solitaire tare = new Solitaire();
		tare.greetingMessage();
		//System.out.println(tare.lists[6]);
	}
	
	private void greetingMessage(){
		
		String greeting = "      	   	         _______  _______  ___      ___   _______  _______  ___   ______    _______" + "\n" +
						  "			|       ||       ||   |    |   | |       ||   _   ||   | |    _ |  |       |" + "\n" +
						  "			|  _____||   _   ||   |    |   | |_     _||  |_|  ||   | |   | ||  |    ___|" + "\n" +
						  "			| |_____ |  | |  ||   |    |   |   |   |  |       ||   | |   |_||_ |   |___ " + "\n" +
						  "			|_____  ||  |_|  ||   |___ |   |   |   |  |       ||   | |    __  ||    ___|" + "\n" +
						  "			 _____| ||       ||       ||   |   |   |  |   _   ||   | |   |  | ||   |___ " + "\n" +
						  "			|_______||_______||_______||___|   |___|  |__| |__||___| |___|  |_||_______|";
		System.out.println(greeting);
	}
}

