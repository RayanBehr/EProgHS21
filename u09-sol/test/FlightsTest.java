import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class FlightsTest {
		
	@Test 
	public void testNames() throws IOException {
		String[] flights = {
				"AR BR",
				"a1 00.00.0000 ECONOMY",
				".",
				"A BR C",
				"a123 00.00.0000 ECONOMY",
				"."};
		String[] miles = {
				"AR BR: 125",
				"A BR C: 125",
		};
		assertCalculateMiles(flights, miles);
	}
	
	@Test 
	public void testContinentalAndKlasses() throws IOException {
		String[] flights = {
				"A B",
				"a0 00.00.0000 ECONOMY",
				".",
				"A C",
				"a0 00.00.0000 BUSINESS",
				".",
				"A D",
				"a0 00.00.0000 FIRST",
				"."};
		String[] miles = {
				"A B: 125",
				"A C: 250",
				"A D: 375",
		};
		assertCalculateMiles(flights, miles);
	}
	

	
	@Test 
	public void testKlasses() throws IOException {
		String[] flights = {
				"A B",
				"a0 00.00.0000 ECONOMY 1",
				".",
				"A C",
				"a0 00.00.0000 BUSINESS 1",
				".",
				"A D",
				"a0 00.00.0000 FIRST 1",
				"."};
		String[] miles = {
				"A B: 1",
				"A C: 2",
				"A D: 3",
		};
		assertCalculateMiles(flights, miles);
	}
	
	@Test 
	public void testSpecialCases() throws IOException {
		String[] flights = {};
		String[] miles = {};
		assertCalculateMiles(flights, miles);
		
		flights = new String[] {
				"A C",
				".",
		};
		miles = new String[] {
				"A C: 0",
		};
		assertCalculateMiles(flights, miles);
		
		flights = new String[] {
				"A B C",
				"a0 00.00.0000 ECONOMY 0",
				".",
		};
		miles = new String[] {
				"A B C: 0",
		};
		assertCalculateMiles(flights, miles);
		
		flights = new String[] {
				"A C",
				".",
				"" // add manual newline (will be tested with that and with two newlines)
		};
		miles = new String[] {
				"A C: 0",
		};
		assertCalculateMiles(flights, miles);
	}
	
	@Test
	public void testBig() throws IOException {
		// GIVEN
		String[] flights = {
				"Michaela Meier",
				"LX326 05.12.2016 ECONOMY",
				"LX317 10.01.2017 ECONOMY",
				"A3851 12.05.2017 BUSINESS",
				"LX8 12.10.2017 FIRST 4433",
				".",
				"Stefan Oliver Schmid",
				"LX4150 19.10.2017 BUSINESS 6404",
				"."};
		String[] miles = {
				"Michaela Meier: 13799",
				"Stefan Oliver Schmid: 12808"
		};
		assertCalculateMiles(flights, miles);
		
		// Our tests:
		flights = new String[] {
				"Hans Peter Mueller",
				"LX8 12.03.2016 FIRST 5800",
				"LX8 13.03.2017 FIRST 6050",
				"LX8 11.03.2016 BUSINESS",
				"LX8 11.03.2017 BUSINESS",
				"LX8 12.03.2017 ECONOMY",
				".",
				"Heidi Peter",
				"LX8 12.03.2017 FIRST 5800",
				"LX8 12.03.2017 FIRST",
				"LX8 12.03.2017 FIRST 5800",
				".",
				"Mein Name",
				"LH777 11.08.2016 ECONOMY",
				"LX8 11.08.2017 ECONOMY 5",
				"LX8 11.08.2017 ECONOMY",
				"LH777 11.08.2015 ECONOMY",
				".",
				"a b",
				"LH777 11.08.2015 ECONOMY",
				".",
				"a c",
				".",
				"a b c",
				".",
				"e g",
				"LH777 11.08.2017 ECONOMY 123",
				"LH777 11.08.2017 ECONOMY",
				"LH777 11.08.2017 ECONOMY 234",
				".",
				"e f g",
				"LH777 11.08.2017 ECONOMY 123",
				"LH777 11.08.2017 ECONOMY",
				"LH777 11.08.2017 ECONOMY 234",
				".",
				"u v w",
				"LX8 11.03.2017 ECONOMY",
				"LX8 11.03.2017 BUSINESS",
				"LX8 11.03.2017 FIRST",
				"LX8 11.03.2017 ECONOMY 1000",
				"LX8 11.03.2017 BUSINESS 10000",
				"LX8 11.03.2017 FIRST 100000",
				"."
		};
		miles = new String[] {
				"Hans Peter Mueller: 36175", 
				"Heidi Peter: 35175",
				"Mein Name: 380",
				"a b: 125", 
				"a c: 0", 
				"a b c: 0", 
				"e g: 482", 
				"e f g: 482", 
				"u v w: 321750" 
		};
		assertCalculateMiles(flights, miles);
	}

	private void assertCalculateMiles(String[] flights, String[] expectedMiles) throws IOException {
		/*
		 * The specification says that there is a newline after the last ".". However, for the
		 * sake of many, we ignore wrong solutions by trying without and with a newline. (but
		 * remove one point with a specific test for this issue)
		 */
		ArrayList<String> flightsList = new ArrayList<>(Arrays.asList(flights));
		boolean testPassed = runAndCheck(flightsList, expectedMiles);
		flightsList.add("");
		assertTrue(testPassed || runAndCheck(flightsList, expectedMiles));
		
	}

	private boolean runAndCheck(List<String> flights, String[] expectedMiles) throws IOException {
		File inFile = File.createTempFile("flights-", ".txt");
		File outFile = File.createTempFile("miles-", ".txt");
		inFile.deleteOnExit();
		outFile.deleteOnExit();
		Path inPath = inFile.toPath();
		Path outPath = outFile.toPath();
		
		String joined = String.join(System.lineSeparator(), flights);
		
		Files.write(inPath, joined.getBytes(Charset.forName("UTF-8")),
				StandardOpenOption.CREATE, StandardOpenOption.DSYNC,
				StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);

		try {
			Flights.calculateMiles(inFile, outFile);
		} catch (Throwable t) {
			// catch and ignore, but test not passed
			return false;
		}
		
		List<String> lines = Files.readAllLines(outPath);
		
		// strip whitespace and empty lines:
		String[] actualMiles = lines.stream().map(x -> x.trim())
				.filter(x -> !x.equals(""))
				.toArray(String[]::new);

		return Arrays.equals(expectedMiles, actualMiles);
	}

}
