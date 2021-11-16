/**
 * A singly-linked list of {@link Room}s with fast {@link #addFirst(Room)} and
 * {@link #addLast(Room)} methods.
 */

public class LinkedRoomList {
    
    RoomNode first;
    RoomNode last;
    int size;
    
    Room get(int index) {
        return getNode(index).value;
    }
    
    void set(int index, Room value) {
        getNode(index).value = value;
    }
    
    boolean isEmpty() {
        return size == 0;
    }
    
    void addFirst(Room value) {
        RoomNode newNode = new RoomNode(value);
        newNode.next = first;
        first = newNode;
        if(last == null)
            last = newNode;
        size++;
    }
    
    void addLast(Room value) {
        RoomNode newNode = new RoomNode(value);
        if(isEmpty())
            first = newNode;
        else
            last.next = newNode;
        
        last = newNode;
        size++;
    }
    
    Room removeFirst() {
        if(isEmpty())
            throw new AssertionError();
        
        Room value = first.value;
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
    
    Room removeLast() {
        if(isEmpty())
            throw new AssertionError();
        
        Room value = last.value;
        if(first == last) {
            // List has only one element, so just clear it
            clear();
        }
        else {
            // List has more than one element
            RoomNode currentNode = first;
            while(currentNode.next != last)
                currentNode = currentNode.next;
            
            currentNode.next = null;
            last = currentNode;
            size--;
        }
        return value;
    }
    
    boolean contains(Room room) {
    	for(RoomNode n = first; n != null; n = n.next) {
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
    
    Room[] toArray() {
        Room[] array = new Room[size];
        int i = 0;
        for(RoomNode n = first; n != null; n = n.next, i++)
            array[i] = n.value;
        return array;
    }
    
    /**
     * For internal use only.
     */
    RoomNode getNode(int index) {
        if(index >= size)
            throw new AssertionError();
        
        RoomNode current = first;
        for(int i = 0; i < index; i++) {
        	current = current.next;
        }
        return current;
    }
}
