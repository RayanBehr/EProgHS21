

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Bienen {
	
	public static void main(String[] args) throws FileNotFoundException {
		String dateiName = "bienen.txt";
		Scanner scanner = new Scanner(new File(dateiName));
		PrintStream output = new PrintStream(System.out);
		
		analyze(scanner, output);
		
		output.close();
		scanner.close();
	}
	
	public static void analyze(Scanner input, PrintStream output) {
		int highestTotalPayment = 0;
		String highestPaidMember = "";
		float highestRatio = 0;
		String highestRatioMember = "";
		Map<String, Integer> countryShare = new HashMap<String, Integer>();
		
		while(input.hasNextLine()) {
			String name = input.next();
			String country = input.next();
			int payment = input.nextInt();
			int extraPayment = input.nextInt();
			
			if (highestTotalPayment < (payment + extraPayment)) {
				highestTotalPayment = payment + extraPayment;
				highestPaidMember = name;
			}
			if (highestRatio < ((float)extraPayment/(extraPayment+payment)) ) {
				highestRatio = (float)extraPayment/(extraPayment+payment);
				highestRatioMember = name;
			}
			
			countryShare.put(country, countryShare.getOrDefault(country, 0) + extraPayment);
		}
		
		Map.Entry<String, Integer> maxCountry = null;
	    for (Map.Entry<String, Integer> entry : countryShare.entrySet()) {
	        if (maxCountry == null || entry.getValue() > maxCountry.getValue()) {
	        	maxCountry = entry;
	        }
	    }
	    
		output.print(highestPaidMember);
		output.print(" ");
		output.println(highestTotalPayment);
		
		output.print(highestRatioMember);
		output.print(" ");
		output.println(Math.round(highestRatio*100));
		
		output.print(maxCountry.getKey());
		output.print(" ");
		output.println(maxCountry.getValue());
	}
}
