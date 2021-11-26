/**
 * A person in the {@link MigrosSimulation}. If has a (private, immutable) number of initial items,
 * a number of current items and the time it spent in a queue.
 */
public class Person {
    
    private int initialItems;    
    int currentItems;
    int timeInQueue = 0;
    
    public Person(int initialItems) {
        this.initialItems = initialItems;
        this.currentItems = initialItems;
    }
    
    public int getInitialItems() {
        return initialItems;
    }
}
