import java.security.DrbgParameters.NextBytes;
import java.util.NoSuchElementException;

public class CircularLinkedIntList implements IntList {

	IntNode last;
	int size;
	
	@Override
	public int get(int index) {		
		IntNode temp = last; // this is the first element
		for(int i = -1; i < index; i++) {
			temp = last.next;
		} return temp.value;
	}	
	@Override
	public void set(int index, int value) {
		IntNode temp = last; // this is the first element
		for(int i = -1; i < index; i++) {
			temp = last.next;
		} temp.value = value;
	}
	@Override
	public boolean isEmpty() {
		return size == 0; // we construct a bolean
	}
	@Override
	public int getSize() {
		return size; // just return the size
	}
	@Override
	public void addFirst(int value) {
		// firstInsert will be our first node
		IntNode firstInsert = new IntNode(value); 
		if(!isEmpty())
		{	
			// we get the successor of our current first node
			// and assign that referenct as next of firstInsert
			firstInsert.next = last.next; 	
			
			// finally we say that firstInsert is our new first
			last.next = firstInsert;		
			
			// we increment the size of our data structure by 1
		} else {
			last = firstInsert;
			last.next = last;
		}
		
		size++;
	}
	@Override
	public void addLast(int value) {
		IntNode lastInsert = new IntNode(value);
		if(!isEmpty())
		{
			lastInsert.next = last.next;	
			last.next = lastInsert;
			last = lastInsert;
		} else {
			last = lastInsert;
			last.next = last;
		}
		
		size++;
	}
	@Override
	public int removeFirst() {
		int ret = last.next.value;
		if(!isEmpty()) // ???
		{
			last.next = last.next.next;	
			size--;
		}
		return ret;
	}
	@Override
	public int removeLast() {
		int ret = last.value;
		if(size == 1)
			last = null;
		else if(!isEmpty()) // ???
		{
			IntNode temp = last;
			while(temp.next != last)
				temp = temp.next;
			temp.next = last.next;
			last = temp;
			size--;
		}
		return ret;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub	
	}
	@Override
	public int[] toArray() {	
		int[] ret = new int[size];	
		IntNode temp = last;
		ret[0] = temp.value;
		for(int i = 1; i < size; i++) {
			temp = last.next;
			ret[i] = temp.value;
		}return ret;
	}
	
	// TODO: Implementieren Sie die Methoden für das IntList Interface
}
