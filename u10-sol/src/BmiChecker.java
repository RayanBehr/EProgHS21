import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/* 
 * Author: Remi Meier, Michael Faes
 * for Einführung in die Programmierung I, HS 2016
 * 
 * A program that reads body data from a file and outputs unhealthy persons.
 */
public class BmiChecker {
    
    public static void main(String[] args) {
        File file = new File("body.dat.txt");
        LinkedPersonList persons = null;
        try {
            Scanner scanner = new Scanner(file);
            persons = readPersons(scanner);
            scanner.close();
        } catch(FileNotFoundException e) {
            System.out.println("Error: The file " + file + " could not be found");
            System.exit(-1);
        }
        
        printUnhealthy(persons, System.out);
    }
    
    /**
     * Reads the person data from the given Scanner and returns it as a list. If an
     * {@link IllegalPersonFormatException} occurs, that row of data is skipped.
     */
    private static LinkedPersonList readPersons(Scanner scanner) {
        LinkedPersonList persons = new LinkedPersonList();
        int row = 1;
        while(scanner.hasNextLine()) {
            try {
                persons.addLast(new Person(scanner.nextLine()));
            } catch(IllegalPersonFormatException e) {
                System.out.println("Error: illegal person data in row " + row + ": " +
                        e.getMessage());
            }
            row++;
        }
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
