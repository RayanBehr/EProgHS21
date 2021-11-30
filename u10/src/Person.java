import java.util.Scanner;

/**
 * A person with some properties, such as age and weight.
 */
public class Person {
    public int age;        // years
    public int weight;     // kg
    public int height;     // cm
    public boolean isMale;
    
    /**
     * Creates a new person and initializes its properties based on the given row of data.
     */
    public Person(String dataRow) {
        Scanner scanner = new Scanner(dataRow);
        age = scanner.nextInt();
        weight = scanner.nextInt();
        height = scanner.nextInt();
        isMale = scanner.next().equals("m");
    }

    /**
     * Returns the body mass index of this person (in kg/m²).
     */
    public int bodyMassIndex() {
        return 10000 * weight / (height * height);
    }
    
    public String toString() {
        String gender;
        if(isMale)
            gender = "m";
        else
            gender = "w";
        
        return "Person (" + gender + ", " + age + " Jahre, " + height + " cm, " + weight + " kg)";
    }
}
