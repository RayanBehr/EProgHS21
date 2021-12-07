

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class HamsterAnalysis {
	
	public static void main(String[] args) throws FileNotFoundException {
		String dateiName = "hamster.txt";
		Scanner scanner = new Scanner(new File(dateiName));
		
		HamsterAnalysis x = new HamsterAnalysis(scanner);
		scanner.close();
		
		System.out.println("Data: ");
		for (Offer offer : x.getData()) {
		    System.out.println(offer);
		}
		
	}
	
	HamsterAnalysis(Scanner input) {
		// TODO
	}
	
	public List<Offer> getData() {
		// TODO
		return null;
	}
	
	public List<Integer> genus(String gen) {
		// TODO
		return null;
	}
	
	public int fraudDistance(String gen, int age) {
		// TODO
		return 0;
	}
}
