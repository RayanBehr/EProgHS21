/**
 * A linked list of persons.
 */
public class LinkedPersonList {
    
    private PersonNode first;
    private PersonNode last;
    private int size;
    
    /**
     * Return the person at position 'index'
     */
    public Person get(int index) {
        return getNode(index).get();
    }
    
    /**
     * Set the person at position 'index' to 'person'
     */
    public void set(int index, Person person) {
        getNode(index).setPerson(person);
    }
    
    /**
     * Returns whether this list is empty (has no values)
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Inserts 'person' at position 0 in this list.
     */
    public void addFirst(Person person) {
        PersonNode newNode = new PersonNode(person);
        newNode.setNext(first);
        first = newNode;
        if(last == null)
            last = newNode;
        size++;
    }
    
    /**
     * Appends 'person' at the end of this list.
     */
    public void addLast(Person person) {
        PersonNode newNode = new PersonNode(person);
        if(isEmpty())
            first = newNode;
        else
            last.setNext(newNode);
        
        last = newNode;
        size++;
    }
    
    /**
     * Removes and returns the first person in this list.
     */
    public Person removeFirst() {
        if(isEmpty())
            throw new AssertionError();
        
        Person value = first.get();
        if(first == last) {
            // List has only one element, so just clear it
            clear();
        }
        else {
            first = first.next();
            size--;
        }
        
        return value;
    }
    
    /**
     * Removes and returns the last person in this list.
     */
    public Person removeLast() {
        if(isEmpty())
            throw new AssertionError();
        
        Person person = last.get();
        if(first == last) {
            // List has only one element, so just clear it
            clear();
        }
        else {
            // List has more than one element
            PersonNode currentNode = first;
            while(currentNode.next() != last)
                currentNode = currentNode.next();
            
            currentNode.setNext(null);
            last = currentNode;
            size--;
        }
        return person;
    }
    
    /**
     * Removes all persons from this list, making this list empty.
     */
    public void clear() {
        first = last = null;
        size = 0;
    }
    
    public Person[] toArray() {
        Person[] array = new Person[size];
        int i = 0;
        for(PersonNode n = first; n != null; n = n.next(), i++)
            array[i] = n.get();
        return array;
    }
    
    /**
     * Returns the first node in this list, which allows clients to iterate over it.
     */
    public PersonNode first() {
        return first;
    }
    
    private PersonNode getNode(int index) {
        if(index >= size)
            throw new AssertionError();
        
        PersonNode current = first;
        for(int i = 0; i < index; i++)
            current = current.next();
        return current;
    }
}
