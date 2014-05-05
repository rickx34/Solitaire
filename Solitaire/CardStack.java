public class CardStack{
	StackClass<Card> stack;
	
	public CardStack(){
		stack = new StackClass<Card>();
	}
	
	public void add(Card c){
		
		if(stack.isEmpty()){
			stack.push(c);
		}
		else if(c.getValue() == (stack.peek().getValue()+1) && c.getSuit() == stack.peek().getSuit()){
			stack.push(c);
		}
	}
	
	public String toString(){
		return stack.toString();
	}
	
	public static void main(String[] args){
		//test
		CardStack stack = new CardStack();
		stack.add(new Card(Card.ACE, Card.SPADE));
		stack.add(new Card(2, Card.SPADE));
		System.out.println(stack);
	}
}
