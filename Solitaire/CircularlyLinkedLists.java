import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularlyLinkedLists<E> extends AbstractList<E>{
	protected Element<E> tail;
	protected int size;

	public CircularlyLinkedLists(){
		tail = null;
		size = 0;
	}
	
	@Override
	public int indexOf(E value){
	// pre: value is not null
	// post: returns first index of value;
	// or -1 if value is not found
		if(value != null){
			
			if(tail == null){
				return -1;
			}
			
			Element<E> finger = tail.next;
			int count = 0;
			while(finger != tail && !finger.value.equals(value)){
				count++;
				finger = finger.next;
			}
			
			if(finger.value.equals(value))
				return count;
			else
				return -1;
				
		}else
			return -1;	
	}
	
	@Override
	public E get(int i){
			
		if (i == 0)
			return getFirst();
		else if (i == size -1)
			return getLast();
		
		Element<E> finger = tail.next;
		int compareIndex = 0;
		while (compareIndex < i) {
			finger = finger.next;
			i--;
		}
		return finger.value;
	}
	
	public E getFirst() {
		return tail.next.value;
	}
	
	public E getLast() {
		return tail.value;
	}
	
	@Override
	public void add(int i, E o){
	// pre: 0<=i<=size()
	// post: adds o as the ith entry of list
		if(i>size || size<0)
			throw new IndexOutOfBoundsException();
			
		if(i == 0){
			addFirst(o);
			return;
		}else if(i == size){
			addLast(o);
			return;
		}
			
		if(i != 0 && i != size){
			Element<E> finger = tail.next;
			
			//stop the finger before the ith element, e.g. i=2 i will stop at i=1 so it will add
			//at 2 ith position
			for(int index = 0; index < i-1; index++){
				finger = finger.next;
			}
			Element<E> temp = new Element<E>(o,finger.next);
			finger.next = temp;
			size++;
		}
		
	}
	
	public void addFirst(E value){

		if(tail == null){
			tail = new Element<E>(value,null);
			tail.next = tail;
		}else
			tail.next = new Element<E>(value,tail.next);
			
		size++;
	}
	
	public void addLast(E value){
		addFirst(value);
		tail = tail.next;
	}
	
	@Override
	public E remove(int i){
	// pre: 0<=i<size()
	// post: removes and returns the ith element
		if(i>size || size<0)
			throw new IndexOutOfBoundsException();
			
		if(i == 0){
			return removeFirst();
		}else if(i == size-1)
			return removeLast();
		
		//indexing here is same as in the add(int i, E o) method
		Element<E> finger = tail.next;
		for(int index = 0; index<i-1; index++){
			finger = finger.next;
		}
		Element<E> temp = finger.next;
		finger.next = finger.next.next;
		size--;
		return temp.value;
	}
	
	public E removeLast(){
		
		if(isEmpty())
			throw new NoSuchElementException();
			
		Element<E> finger = tail.next;
		while(finger.next != tail){
			finger = finger.next;
		}
		
		Element<E> temp = tail;
		if(finger == null)
			tail = null;
		else{
			finger.next = tail.next;
			tail = finger;
		}
		size--;
		return temp.value;
	}
	
	public E removeFirst(){
		if(isEmpty())
			throw new NoSuchElementException();
		else if(size == 1){
			tail = null;
			return null;
		}
			
		Element<E> temp = tail.next;	
		tail.next = tail.next.next;
		size--;
		return temp.value;
		
	}
	
	@Override
	public E set(int i, E o){
	// pre: 0<=i<size()
	// post: sets ith entry of list to o;
	// returns old value
		if(i>size || size<0)
			throw new IndexOutOfBoundsException();
			
		//same indexing applies here but without i-1
		Element<E> finger = tail.next;
		for(int index = 0; index<i; index++){
			finger = finger.next;

		}
		Element<E> temp = finger;
		finger.value = o;
		return temp.value;
	}
	
	@Override
	public Iterator<E> iterator(){
	// post: returns an iterator of the list
		return null;
	}
	
	@Override
	public int size(){
	//returns the size
		return size;
	}
	
	@Override
	public void clear(){
	//clears the whole list
		tail = null;
		size = 0;
	}
	public Collection values(){
		return null;
	}
	
	@Override
	public String toString(){
		//converting the values in a linked list to String and storing them into string variable.
		String string = "";

		if(!isEmpty()){
			Element<E> finger = tail.next;
			int split = 0;//this variable is responsible for spliting the string
			
			//this for is used to split the string value into groups instead of displaying them 
			//all in one line.
			for(int i = 0;i <size()-1; i++){
				string += finger.value + ", ";
				finger = finger.next;
				
				//this is what splits the string
				if(i == split+12){
					string += "\n";
					split = split +13;
				}
			}
			if(tail.next != null)
				string += finger.value + "";
			
		}else
			return "List is Empty.";
	
		return string;
	}
	public static void main(String[] args){
		CircularlyLinkedLists<String> list = new CircularlyLinkedLists<String>();
		//testing to see if it works
		list.addFirst("1");
		list.addFirst("2");
		list.addFirst("3");
		list.addFirst("4");
		list.addFirst("5");
		String str = "4";
		
		System.out.println(list.toString());
		System.out.println("Index-"+str+" "+list.indexOf(str));
		System.out.println("Removing-"+list.remove(str));
		System.out.println("Is \"4\" in the list? "+ list.contains(str));
			
		System.out.println(list.toString());
		System.out.println("Last Index: "+list.indexOf(list.getLast())+" Size: "+list.size());
		/******************************OUTPUT**************************/
		/*
		[ 5, 4, 3, 2, 1 ]
		Index-4 2
		Removing-4
		Is "4" in the list? false
		[5, 4, 2, 1 ]
		Last Index: 3 Size: 4
		 */
	}
	protected static class Element<E> {	
		public E value;
		public Element<E> next;
		
		public Element(E value, Element<E> next) {
			this.value = value;
			this.next = next;
		}
	}
}
