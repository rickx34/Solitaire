public interface Stack<E>{
	
	public E peek();
	// pre: stack is not empty
	// post: top value is returned
	public void push(E o);
	// post: add o to the top of stack
	public E pop();
	// pre: stack is not empty
	// post: remove and return top element
}

