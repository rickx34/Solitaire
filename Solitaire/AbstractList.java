public abstract class AbstractList<E> implements List<E>{
    
	public boolean isEmpty(){
		return size()==0;
	}
	
	public boolean contains(E o){
		return indexOf(o) != -1;
	}
	
	public E remove(E o){
		int i=indexOf(o);
		if (i!=-1) return remove(i);
		else return null;
	}	
}
