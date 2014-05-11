import java.util.Scanner;
import java.util.StringTokenizer;

public class Solitaire {

	CardDeck deck;
	CardStack[] stacks;
	CardList[] lists;
	boolean isRunning;
	Scanner scan;

	public Solitaire() {
		scan = new Scanner(System.in);
		isRunning = true;
		deck = new CardDeck();
		stacks = new CardStack[4];
		lists = new CardList[7];
		//initialise
		for (int i = 0; i < stacks.length; i++) {
			stacks[i] = new CardStack();
		}
		for (int i = 0; i <lists.length; i++) {
			lists[i] = new CardList((i+1), deck);
		}    
	}

	public boolean executeCommand(String command) {
		if(command.equalsIgnoreCase("quit")){
			isRunning = false;
			return true;
		}
		else if(command.equalsIgnoreCase("drawcard")){
			if(deck.drawCard() == null)
				return false;
			else
				return true;
		}
		else if(command.toLowerCase().contains("deckto")){
			StringTokenizer token = new StringTokenizer(command);
			if(token.countTokens() != 2)
				return false;

			token.nextToken();     
			int listNumber = 0;      
			try{
				listNumber = Integer.parseInt(token.nextToken());
			}catch(Exception e){
				return false;
			}

			if(listNumber < 1 || listNumber>7)
				return false;

			if(lists[listNumber-1].add(deck.getCurrentCard())){
				deck.takeCard();
				deck.drawCard();
				return true;	
			}
			else
				return false;

		}else if (command.toLowerCase().contains("link")) {
			StringTokenizer tokenizer = new StringTokenizer(command);
			if (tokenizer.countTokens() != 3) {
				return false;
			}

			tokenizer.nextToken();
			String cardName = tokenizer.nextToken();
			String firstChar = "";

			if(cardName.substring(0,2).equalsIgnoreCase("10"))
				firstChar = "10";
			else if(Character.toString(cardName.charAt(0)).equalsIgnoreCase("a"))
				firstChar = "a";
			else
				firstChar = Character.toString(cardName.charAt(0));

			if(command.toLowerCase().contains("spade"))
				cardName = firstChar+"♠";
			else if(command.toLowerCase().contains("heart"))
				cardName = firstChar+"♥";
			else if(command.toLowerCase().contains("diamond"))
				cardName = firstChar+"♦";
			else if(command.toLowerCase().contains("club"))
				cardName = firstChar+"♣";
			else 
				return false;

			int deckNumber = -1;
			try {
				deckNumber = Integer.parseInt(tokenizer.nextToken());
			} catch (Exception e) {
				return false;
			}
			if (deckNumber < 1 || deckNumber > 7) {
				return false;
			}

			for(int i = 0; i<lists.length; i++){

				for(int j = 0;j<lists[i].getCards().size();j++){

					Card card = lists[i].getCards().get(j);
					if (card.toString().compareToIgnoreCase(cardName) == 0){

						if (lists[i].getOpenIndex() == j+1){
							if (i == deckNumber - 1)
							{
								//adding to the original list, invalid
								return false;
							}			
						}

						if(lists[deckNumber-1].getCards().isEmpty() && card.getValue() == Card.KING){
							lists[deckNumber-1].add(card);
						}

						if(!card.getColor().equals(lists[deckNumber - 1].getCards().getLast().getColor())
								&& card.getValue() == (lists[deckNumber - 1].getCards().getLast().getValue()-1)){
							return lists[deckNumber - 1].link(lists[i].cut(j));

						}else if(card.getValue() == Card.QUEEN && 
								lists[deckNumber-1].getCards().getLast().getValue() == Card.KING){
							lists[deckNumber-1].getCards().addLast(card);
						}
					}	
				}
			} 
			return false;

		}else if(command.compareToIgnoreCase("restart") == 0){
			restart();
			return true;
		}else
			return false;
	}

	public void startGame(){
		while(isRunning){
			if(executeCommand(scan.nextLine())){
				if(isRunning)
					printCurrentStep();
			}else{
				System.err.println("Invalid Move . Try another move");
				System.out.print("Your Next Move: ");
			}
		}
		scan.close();
		System.exit(0);
	}

	public void restart() {
		Solitaire solitaire = new Solitaire();
		solitaire.printCurrentStep();
		solitaire.startGame();

	}

	public void printCurrentStep() {
		System.out.println("\n"+"-----------------Current Step--------------------");
		System.out.printf("Card Deck: " + deck.toString());
		System.out.println("  Open Card:  " + deck.getCurrentCard());
		System.out.printf("Card Stacks:  ");
		for (int i = 0; i < stacks.length; i++) {
			System.out.print(stacks[i] + " ");
		}
		System.out.println("\n");
		System.out.println("Card Lists: ");
		for (int i = 0; i < lists.length; i++) {
			System.out.println(i+1 + ". " + lists[i]);
		}
		System.out.print("\n" + "Your Next Move: ");
	}

	public static void main(String args[]) {
		Solitaire tare = new Solitaire();
		tare.greetingMessage();
		tare.printCurrentStep();
		tare.startGame();
	}

	private void greetingMessage() {

		String greeting = "      	   	         _______  _______  ___      ___   _______  _______  ___   ______    _______" + "\n"
				+ "			|       ||       ||   |    |   | |       ||   _   ||   | |    _ |  |       |" + "\n"
				+ "			|  _____||   _   ||   |    |   | |_     _||  | |  ||   | |   | ||  |    ___|" + "\n"
				+ "			| |_____ |  | |  ||   |    |   |   |   |  |  |_|  ||   | |   |_||_ |   |___ " + "\n"
				+ "			|_____  ||  |_|  ||   |___ |   |   |   |  |       ||   | |    __  ||    ___|" + "\n"
				+ "			 _____| ||       ||       ||   |   |   |  |   _   ||   | |   |  | ||   |___ " + "\n"
				+ "			|_______||_______||_______||___|   |___|  |__| |__||___| |___|  |_||_______|";

		System.out.println(greeting);
	}


}
