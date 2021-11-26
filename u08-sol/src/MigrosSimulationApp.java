import java.util.Scanner;

/* 
 * Author: Remi Meier, Michael Faes
 * für Einführung in die Programmierung I, HS 2016
 * 
 * Asks the user for the lazyness value and then runs a MigrosSimulation with the given
 * lazyness and some predefined parameters.
 */
public class MigrosSimulationApp {

    public static void main(String[] args) {
        System.out.print("Lazyness? ");
        int lazyness = new Scanner(System.in).nextInt();
        
        double[] queueDefs = new double[]{0.5, 0.8, 0.99};
        MigrosSimulation simulation = new MigrosSimulation(queueDefs, 0.21, 20, lazyness);
        
        simulation.run(10000000);
        
        System.out.println("\nAvg queue lengths:");
        Utils.printBars(simulation.getAvgQueueLengths(), System.out);
        
        System.out.println("Max queue lengths:");
        Utils.printBars(simulation.getMaxQueueLengths(), System.out);
        
        double avgTime = 0;
        int maxTime = 0;
        for(PersonNode node = simulation.getFinished().first; node != null; node = node.next) {
            avgTime += node.person.timeInQueue;
            maxTime = Math.max(maxTime, node.person.timeInQueue);
        }
        avgTime /= simulation.getFinished().size;
        
        System.out.printf("Avg time in queue: %.2f\n", avgTime);
        System.out.printf("Max time in queue: %d\n", maxTime);
    }
}
