/**
 * A singly-linked list of {@link Ball}s with fast {@link #addFirst(Ball)} and
 * {@link #addLast(Ball)} methods.
 */

public class LinkedBallList {
    
    BallNode first;
    BallNode last;
    int size;
    
    Ball get(int index) {
        return getNode(index).value;
    }
    
    void set(int index, Ball value) {
        getNode(index).value = value;
    }
    
    Ball remove(int index) { 
    	
    	if (index == size-1) {
        	return removeLast();
    	} 
    	
    	if (index == 0) {
    		return removeFirst();
    	} 
    	
    	if(index >= size || index < 0) {
        	throw new AssertionError();
        }
		
		BallNode current = first;
		BallNode last = null;
        for(int i = 0; i < index; i += 1) {
        	last = current;
        	current = current.next;
        }
        
        last.next = current.next;
        size--;
        
        return current.value;
    }
    
    boolean isEmpty() {
        return size == 0;
    }
    
    void addFirst(Ball value) {
        BallNode newNode = new BallNode(value);
        newNode.next = first;
        first = newNode;
        if(last == null) {
        	last = newNode;
        }
        size++;
    }
    
    void addLast(Ball value) {
        BallNode newNode = new BallNode(value);
        if(isEmpty()) {
        	first = newNode;
        } else {
        	last.next = newNode;
        }
        
        last = newNode;
        size++;
    }
    
    Ball removeFirst() {
        if(isEmpty()) {
        	throw new AssertionError();
        }
        
        Ball value = first.value;
        if(first == last) {
            // List has only one element, so just clear it
            clear();
        }
        else {
            first = first.next;
            size--;
        }
        
        return value;
    }
    
    Ball removeLast() {
        if(isEmpty()) {
        	throw new AssertionError();
        }
        
        Ball value = last.value;
        if(first == last) {
            // List has only one element, so just clear it
            clear();
        }
        else {
            // List has more than one element
            BallNode currentNode = first;
            while(currentNode.next != last) {
            	currentNode = currentNode.next;
            }
            
            currentNode.next = null;
            last = currentNode;
            size--;
        }
        return value;
    }
    
    boolean contains(Ball room) {
    	for(BallNode n = first; n != null; n = n.next) {
    		if (n.value == room) {
    			return true;
    		}
    	}
    	return false;
    }
    
    void clear() {
        first = last = null;
        size = 0;
    }
    
    Ball[] toArray() {
        Ball[] array = new Ball[size];
        int i = 0;
        for(BallNode n = first; n != null; n = n.next, i++) {
        	array[i] = n.value;
        }
            
        return array;
    }
    
    /**
     * For internal use only.
     */
    BallNode getNode(int index) {
        if(index >= size) {
        	throw new AssertionError();
        }
        
        BallNode current = first;
        for(int i = 0; i < index; i++) {
        	current = current.next;
        }
        return current;
    }
}
