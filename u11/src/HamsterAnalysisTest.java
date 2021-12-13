import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public class HamsterAnalysisTest {
	
	@Test
	public void testgetData() throws FileNotFoundException {
		String dateiName = "hamster.txt";
		Scanner scanner = new Scanner(new File(dateiName));
		
		HamsterAnalysis x = new HamsterAnalysis(scanner);
		scanner.close();
		
		List<Offer> data = x.getData();
		
		assertEquals(3, data.get(0).getPrice());
		assertEquals("Cansumys", data.get(0).getGenus());
		assertEquals(2, data.get(0).getAge());
		assertEquals(101, data.get(0).getID());
		assertEquals("Bonanno", data.get(0).getAssociation());
		
		data = x.getData();
		
		assertEquals(3, data.get(0).getPrice());
		assertEquals("Cansumys", data.get(0).getGenus());
		assertEquals(2, data.get(0).getAge());
		assertEquals(101, data.get(0).getID());
		assertEquals("Bonanno", data.get(0).getAssociation());
		
		data.remove(0);
		data = x.getData();
		
		assertEquals(3, data.get(0).getPrice());
		assertEquals("Cansumys", data.get(0).getGenus());
		assertEquals(2, data.get(0).getAge());
		assertEquals(101, data.get(0).getID());
		assertEquals("Bonanno", data.get(0).getAssociation());
	}

	@Test
	public void testGenus1() throws FileNotFoundException {
		String dateiName = "hamster.txt";
		Scanner scanner = new Scanner(new File(dateiName));
		
		HamsterAnalysis x = new HamsterAnalysis(scanner);
		scanner.close();
		
		assertEquals(List.of(826, 828, 122, 123, 289), x.genus("Mesocricetus"));
		
		assertEquals(List.of(101, 83, 282, 4, 65, 12, 202), x.genus("Cansumys"));
		
		assertEquals(List.of(75), x.genus("Cricetus"));
		
		assertEquals(List.of(), x.genus("Phodopus"));
	}
	
	@Test
	public void testFraudDistance1() throws FileNotFoundException {
		String dateiName = "hamster.txt";
		Scanner scanner = new Scanner(new File(dateiName));
		
		HamsterAnalysis x = new HamsterAnalysis(scanner);
		scanner.close();
		
		assertEquals(1, x.fraudDistance("Mesocricetus", 3));
		
		assertEquals(2, x.fraudDistance("Cansumys", 2));
		
		assertEquals(0, x.fraudDistance("Cricetus", 1));
	}
	
	@Test
    public void testDeepCopy() throws FileNotFoundException {
        String dateiName = "hamster.txt";
        Scanner scanner = new Scanner(new File(dateiName));
        
        HamsterAnalysis x = new HamsterAnalysis(scanner);
        scanner.close();
        
        List<Offer> original = x.getData();
        List<Offer> copy = x.getData();
        
        copy.get(0).price = 42069;
        copy.get(0).genus = "Pikachu";
        copy.get(0).age = 69;
        copy.get(0).id = 1337;
        copy.get(0).association = "Pokémon";
        
        assertNotEquals(original.get(0).price, copy.get(0).price);
        assertNotEquals(original.get(0).genus, copy.get(0).genus);
        assertNotEquals(original.get(0).age, copy.get(0).age);
        assertNotEquals(original.get(0).id, copy.get(0).id);
        assertNotEquals(original.get(0).association, copy.get(0).association);
        
        copy.remove(0);
        
        assertNotEquals(original.size(), copy.size());
    }
	
}
