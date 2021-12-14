import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Flights {

	public static void main(String[] args) throws FileNotFoundException {
		calculateMiles(new File("flights.txt"), new File("miles.txt"));
	}

	/**
	 * Liest eine Datei 'input' mit Flügen von Personen ein, berechnet die Anzahl Meilen pro Person
	 * und schreibt das Resultat in eine Datei 'output'.
	 * 
	 * Verändern Sie <b>nicht</b> die Signatur dieser Methode.
	 */
	public static void calculateMiles(File input, File output) throws FileNotFoundException {
		Scanner in = new Scanner(input);
		PrintStream out = new PrintStream(output);

		while (in.hasNext()) {
			String fullName = in.nextLine();

			// now the list of flights starts
			int totalMiles = 0;
			String flightNum = in.next();
			while (!flightNum.equals(".")) {
				String date = in.next();
				String category = in.next();

				int miles = 125;
				if (in.hasNextInt()) {
					miles = in.nextInt();
				}

				if (category.equals("FIRST")) {
					miles = miles * 3;
				} else if (category.equals("BUSINESS")) {
					miles = miles * 2;
				} else {
					assert category.equals("ECONOMY");
				}

				totalMiles += miles;
				
				flightNum = in.next();
			}
			
			in.nextLine();
			out.println(fullName + ": " + totalMiles);
		}

		in.close();
		out.close();
	}

}
