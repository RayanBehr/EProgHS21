import java.util.Random;

/**
 * A simulation of queues in a Migros supermarket. Use the {@link #run(int)} method to run the
 * simulation and afterwards obtain the results using the various getter methods.
 */
public class MigrosSimulation {
    
    // TODO: May visualize simulation using Gui class
    
    private double[] queueDefs;
    private double spawnProb;
    private int maxItems;
    private int lazyness;
    
    private LinkedPersonList[] queues;
    
    private LinkedPersonList finished;
    private double[] avgQueueLengths;
    private int[] maxQueueLengths;
    
    public MigrosSimulation(double[] queueDefs, double spawnProb, int maxItems, int lazyness) {
        this.queueDefs = queueDefs;
        this.spawnProb = spawnProb;
        this.maxItems = maxItems;
        this.lazyness = lazyness;
    }
    
    /**
     * Returns all persons that made it through the queues during the simulation.
     */
    public LinkedPersonList getFinished() {
        return finished;
    }
    
    /**
     * Returns the average length of each queue. The order of the values corresponds to the order of
     * the queue definitions given to the constructor.
     */
    public double[] getAvgQueueLengths() {
        return avgQueueLengths;
    }
    
    /**
     * Returns the maximum length of each queue. The order of the values corresponds to the order of
     * the queue definitions given to the constructor.
     */
    public int[] getMaxQueueLengths() {
        return maxQueueLengths;
    }
    
    /**
     * Runs the simulation once for the given number of time steps.
     */
    public void run(int steps) {
        // Initialization
        queues = new LinkedPersonList[queueDefs.length];
        for(int q = 0; q < queues.length; q++)
            queues[q] = new LinkedPersonList();
        
        finished = new LinkedPersonList();
        avgQueueLengths = new double[queues.length];
        maxQueueLengths = new int[queues.length];
        
        Random random = new Random();
        for(int s = 0; s < steps; s++) {
            // New person enters a queue
            if(random.nextDouble() <= spawnProb) {
                Person person = randomPerson(random);
                queues[random.nextInt(queues.length)].addLast(person);
            }
            
            // Process persons in queues
            for(int q = 0; q < queues.length; q++) {
                LinkedPersonList queue = queues[q];
                if(!queue.isEmpty() && random.nextDouble() <= queueDefs[q]) {
                    Person first = queue.first.person;
                    first.currentItems--;
                    if(first.currentItems == 0)
                        finished.addLast(queue.removeFirst());
                }
                
                if(queue.size >= 2) {
                    int position = 1;
                    for(PersonNode node = queue.first.next; node != null; node = node.next, position++) {
                        int shortest = Utils.minIndex(queueLengths());
                        if(shortest != q && queues[shortest].size <= position - lazyness) {
                            queue.removeNode(node);
                            queues[shortest].addLast(node.person);
                            position--;
                        }
                    }
                }
            }
            
            // Increment time of all persons in queues and update stats
            for(int q = 0; q < queues.length; q++) {
                for(PersonNode node = queues[q].first; node != null; node = node.next)
                    node.person.timeInQueue++;
                avgQueueLengths[q] += queues[q].size;
                maxQueueLengths[q] = Math.max(maxQueueLengths[q], queues[q].size);
            }
            
            if(s % 10000 == 0 && s > 0)
                Utils.printBars(queueLengths(), System.out);
        }
        
        for(int q = 0; q < queues.length; q++)
            avgQueueLengths[q] /= steps;
    }

    private Person randomPerson(Random random) {
        return new Person(1 + random.nextInt(maxItems));
    }
    
    private int[] queueLengths() {
        int[] lengths = new int[queues.length];
        for(int i = 0; i < queues.length; i++)
            lengths[i] = queues[i].size;
        return lengths;
    }
}
