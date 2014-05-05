import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> extends AbstractList<E>{
	protected Element<E> head;
	protected int size;
	
	public LinkedList(){
		head = null;
		size = 0;
	}
	
	@Override
	public int indexOf(E value){
	// pre: value is not null
	// post: returns first index of value;
	// or -1 if value is not found
		if(value != null){
			
			if(head == null){
				return -1;
			}
			
			Element<E> finger = head;
			int count = 0;
			while(finger != null && !finger.value.equals(value)){
				count++;
				finger = finger.next;
			}
			
			if(finger == null)
				return -1;
			else
				return count;
				
		}else
			return -1;	
	}
	
	@Override
	public E get(int i){
	// pre: 0<=i<size()
	// post: returns the element at location i
		if (i < 0 || i >= size)
			throw new IndexOutOfBoundsException();
		
		if (i == 0) {
			return getFirst();
		} else if (i == size -1) {
			return getLast();
		}
		Element<E> finger = head;
		while (i > 0) {
			finger = finger.next;
			i--;
		}
		return finger.value;
	}
	
	public E getFirst() {
		return head.value;
	}
	
	public E getLast() {
		if (size == 0)
			throw new NoSuchElementException();
		
		Element<E> finger = head;
		
		while(finger.next != null) {
			finger = finger.next;
		}
		
		return finger.value;
	}
	
	@Override
	public void add(int i, E o){
	// pre: 0<=i<=size()
	// post: adds o as the ith entry of list
		if (i < 0 || i > size)
			throw new IndexOutOfBoundsException();
		
		Element<E> temp = new Element<E>(o, null);
		
		if (i == 0) {
			temp.next = head;
			head = temp;
		} else {
			Element<E> finger = head;
			Element<E> previous = null;
			while (i > 0) {
				previous = finger;
				finger = finger.next;
				i--;
			}
			previous.next = temp;
			temp.next = finger;
		}
		
		size++;
	}
	
	public void addFirst(E value) {
		head = new Element<E>(value, head);
		size++;
	}
	
	public void addLast(E value) {
		Element<E> temp = new Element<E>(value, null);
		if (head != null) {
			Element<E> finger = head;
			while(finger.next != null) {
				finger = finger.next;
			}
			finger.next = temp;
		} else {
			head = temp;
		}
		size++;
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
		Element<E> finger = head;
		for(int index = 0; index<i-1; index++){
			finger = finger.next;
		}
		Element<E> temp = finger.next;
		finger.next = finger.next.next;
		size--;
		return temp.value;
	}
	
	public E removeFirst() {
		if (size == 0)
			throw new NoSuchElementException();
		
		Element<E> temp = head;
		head = head.next;
		size--;
		return temp.value;
	}
	
	public E removeLast() {
		if (size == 0)
			throw new NoSuchElementException();
		
		Element<E> finger = head;
		Element<E> previous = null;
		
		while(finger.next != null) {
			previous = finger;
			finger = finger.next;
		}
		
		if(previous == null) {
			head = null;
		} else {
			previous.next = null;
		}
		size--;
		return finger.value;
	}
	
	@Override
	public E set(int i, E o){
	// pre: 0<=i<size()
	// post: sets ith entry of list to o;
	// returns old value
		Element<E> temp = null;
		if (i < 0 || i >= size)
			throw new IndexOutOfBoundsException();
		
		if (i == 0) {
			head.value = o;
		} else {
			Element<E> finger = head;
			while (i > 0) {
				finger = finger.next;
				i--;
			}
			temp = finger;
			finger.value = o;
		}	
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
		head = null;
		size = 0;
	}
	
	@Override
	public Collection values(){
		return null;
	}
	
	@Override
	public String toString() {
		String string = "[ ";
		
		Element<E> finger = head;
		while (finger != null && finger.next != null) {
			string += finger.value + "-";
			finger = finger.next;
		}
		
		if(head != null) string += finger.value + " ]";
		else string += "]";
		
		
		return string;
	}
	
	protected static class Element<E> {
		
		public E value;
		public Element<E> next;
		
		public Element(E value, Element<E> next) {
			this.value = value;
			this.next = next;
		}
	}
		
	public static void main (String args[]) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);
		list.addFirst(4);
		list.addFirst(5);	
		// use false for iterative reverse list order or true for recursive reverse list order
		//list.reverseOrder(false);
		
		System.out.println(list);
	}
}

