/**
 * A node in a {@link LinkedPersonList}
 */
public class PersonNode {
    
    private Person person;
    private PersonNode next;
    
    public PersonNode(Person person) {
        this.person = person;
    }
    
    public Person get() {
        return person;
    }
    
    public PersonNode next() {
        return next;
    }
    
    /**
     * For internal use. Should only be called from {@link LinkedPersonList}.
     */
    void setNext(PersonNode next) {
        this.next = next;
    }
    
    /**
     * For internal use. Should only be called from {@link LinkedPersonList}.
     */
    void setPerson(Person person) {
        this.person = person;
    }
}
