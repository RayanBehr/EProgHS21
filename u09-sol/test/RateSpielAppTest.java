import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

public class RateSpielAppTest {
    
    @Test
    public void testLiesWoerter() {
        Scanner scanner = new Scanner("3\nhallo\neprog\nwelt");
        String[] woerter = RateSpielApp.liesWoerter(scanner);
        assertEquals(3, woerter.length);
        assertEquals("hallo", woerter[0]);
        assertEquals("eprog", woerter[1]);
        assertEquals("welt", woerter[2]);
    }
}
