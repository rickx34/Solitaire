public class StackClass<E> extends LinkedList<E> implements Stack<E>{
	
	public StackClass(){

	}
	
	@Override
	public E peek(){
	// pre: stack is not empty
	// post: top value is returned
		return getFirst();
	}
	
	@Override
	public void push(E o){
	// post: add o to the top of stack
		addFirst(o);
	}
	
	@Override
	public E pop(){
	// pre: stack is not empty
	// post: remove and return top element
		return removeFirst();
	}
	
	@Override
	public int size(){
		return super.size();
	}
	
	@Override
	public boolean isEmpty(){
		return super.isEmpty();
	}
	
	@Override
	public String toString(){
		return super.toString();
	}
	
}
