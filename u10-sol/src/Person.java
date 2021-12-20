import java.util.InputMismatchException;
import java.util.NoSuchElementException;
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
     * Creates a new person and initializes its properties based on the given row of data. If the
     * row contains illegal values, an {@link IllegalPersonFormatException} is thrown.
     */
    public Person(String dataRow) throws IllegalPersonFormatException {
        Scanner scanner = new Scanner(dataRow);
        try {
            age = scanner.nextInt();
            if(age < 0)
                throw new IllegalPersonFormatException("negative age");
            
            weight = scanner.nextInt();
            if(weight <= 0)
                throw new IllegalPersonFormatException("non-positive weight");
            
            height = scanner.nextInt();
            if(height <= 0)
                throw new IllegalPersonFormatException("non-positive height");
            
            String gender = scanner.next();
            if(!gender.equals("m") && !gender.equals("f"))
                throw new IllegalPersonFormatException("illegal value for gender: " + gender);
            isMale = gender.equals("m");
        } catch(InputMismatchException e) {
            throw new IllegalPersonFormatException("non-int value");
        } catch(NoSuchElementException e) {
            throw new IllegalPersonFormatException("not enough values");
        }
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
