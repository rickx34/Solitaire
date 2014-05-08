
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

    public String toString() {
        return null;
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
            
            if(listNumber < 0 || listNumber>6)
                return false;
                
            if(lists[listNumber-1].add(deck.takeCard()))
                return true;	
            else
                return false;
            
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

    public void printCurrentStep() {
        System.out.println("\n"+"-----------------Current Step--------------------");
        System.out.printf("Card Deck: " + deck.toString());
        System.out.println("  Open Card: " + deck.getCurrentCard());
        System.out.printf("Card Stacks: ");
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
