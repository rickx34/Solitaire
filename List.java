import java.util.Collection;
import java.util.Iterator;

public interface List<E>{
	
	public boolean contains(E value);
	// pre: value is not null
	// post: true iff list contains an object
	// equal to value
	public int indexOf(E value);
	// pre: value is not null
	// post: returns first index of value;
	// or -1 if value is not found
	public E get(int i);
	// pre: 0<=i<size()
	// post: returns the element at location i
	public void add(int i, E o);
	// pre: 0<=i<=size()
	// post: adds o as the ith entry of list
	public E remove(E o);
	// post: removes and returns o if it is in the list;
	// otherwise return null
	public E remove(int i);
	// pre: 0<=i<size()
	// post: removes and returns the ith element
	public E set(int i, E o);
	// pre: 0<=i<size()
	// post: sets ith entry of list to o;
	// returns old value
	public Iterator<E> iterator();
	// post: returns an iterator of the list
	public int size();
	//returns the size
	public boolean isEmpty();
	//return bool
	public void clear();
	//clears the whole list
	public Collection values();
}
