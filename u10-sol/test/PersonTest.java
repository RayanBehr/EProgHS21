import static org.junit.Assert.*;

import org.junit.Test;

public class PersonTest {
    
    private void assertException(boolean shouldThrow, String dataRow) {
        boolean thrown = false;
        
        try {
            new Person(dataRow);
        } catch(IllegalPersonFormatException e) {
            thrown = true;
        }
        
        if(shouldThrow != thrown)
            fail("Unexpected result for Person(" + dataRow + "): shouldThrow="
                    + shouldThrow + " thrown=" + thrown);
    }
    
    @Test
    public void testPerson() throws IllegalPersonFormatException {
        Person person = new Person("1 2 3 m");
        assertEquals(1, person.age);
        assertEquals(2, person.weight);
        assertEquals(3, person.height);
        assertTrue(person.isMale);
        
        person = new Person("10 20 30 f");
        assertEquals(10, person.age);
        assertEquals(20, person.weight);
        assertEquals(30, person.height);
        assertFalse(person.isMale);
        
        assertException(false, "1 1 1 f");
        assertException(false, "1 1 1 m");
        assertException(false, "0 1 1 m");
        assertException(true, "-1 1 1 m");
        assertException(true, "0 0 1 m");
        assertException(true, "0 1 0 m");
        assertException(true, "1 1 1 w");
        assertException(true, "1 1e 1 m");
        assertException(true, "1 1 1");
        assertException(true, "");
    }
    
    @Test
    public void testBodyMassIndex() throws IllegalPersonFormatException {
        assertEquals(25, new Person("25 100 200 m").bodyMassIndex());
        assertEquals(24, new Person("25  80 180 m").bodyMassIndex());
        assertEquals(24, new Person("25  70 170 f").bodyMassIndex());
        assertEquals(23, new Person("25  60 160 f").bodyMassIndex());
    }
    
}
