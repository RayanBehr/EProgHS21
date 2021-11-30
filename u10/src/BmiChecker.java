import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class BmiChecker {
    
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("body1.dat.txt");
        Scanner scanner = new Scanner(file);
        LinkedPersonList persons = readPersons(scanner);
        scanner.close();
        
        printUnhealthy(persons, System.out);
    }
    
    /**
     * Reads the person data from the given Scanner and returns it as a list.
     */
    private static LinkedPersonList readPersons(Scanner scanner) {
        LinkedPersonList persons = new LinkedPersonList();
        while(scanner.hasNextLine())
            persons.addLast(new Person(scanner.nextLine()));
        return persons;
    }
    
    /**
     * Finds all persons that are of abnormal weight and prints their corresponding weight category.
     */
    static void printUnhealthy(LinkedPersonList persons, PrintStream ausgabe) {
        for(PersonNode n = persons.first(); n != null; n = n.next()) {
            Person person = n.get();
            String category = weightCategory(person);
            if(!category.equals("normal"))
                ausgabe.println(person + " is " + category + "!");
        }
    }
    
    /**
     * Returns the weight category of the given person as a String. Possible categories are "obese",
     * "overweight", "normal", and "underweight".
     */
    static String weightCategory(Person person) {
        if(person.bodyMassIndex() >= 30)
            return "obese";
        if(person.bodyMassIndex() >= 25)
            return "overweight";
        if(person.bodyMassIndex() < 18.5)
            return "underweight";
        return "normal";
    }
}
