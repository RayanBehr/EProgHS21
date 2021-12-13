
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
	
	List<Offer> offers = new ArrayList<>();
	
	HamsterAnalysis(Scanner input) {		
		while(input.hasNextLine()) {
			String line = input.nextLine();
			Scanner lineScan = new Scanner(line);			
			int price, age, id;
			String genus, association;		
			price = lineScan.nextInt();
			genus = lineScan.next();
			age = lineScan.nextInt();
			id = lineScan.nextInt();
			association = lineScan.next();				
			Offer o = new Offer(price,genus,age,id,association);
			lineScan.close();
			offers.add(o);
		}	
	}
	
	public List<Offer> getData() {
		List<Offer> offersCopy = new ArrayList<>();
		for (Offer offer : offers) {
			Offer offerCopy = new Offer(offer.getPrice(), offer.getGenus(),
										offer.getAge(), offer.getID(),
										offer.getAssociation());
		    offersCopy.add(offerCopy);
		}  return offersCopy;
	}
	
	public List<Integer> genus(String gen) {
		List<Integer> idList = new ArrayList<>();	
		for (Offer offer : offers)
			if(offer.getGenus().equals(gen))
				idList.add(offer.getID());			
		return idList;
	}
	
	public int fraudDistance(String gen, int age) {
		List<Integer> hams = new ArrayList<>();
		for (Offer offer : offers)
			if(offer.getGenus().equals(gen) && offer.age == age)
				hams.add(offer.getPrice());
		if(hams.size() == 0) return -1; // es gibt keine passenden
		int minPrice = Integer.MAX_VALUE; int maxPrice = -1;
		int avg; int sum = 0;
		for (Integer price : hams) {
			if(price < minPrice) minPrice = price;
			if(price > maxPrice) maxPrice = price;
			sum += price; }
		avg = (int) Math.ceil( (double) sum / hams.size());	
		return Math.max((maxPrice - avg), (avg - minPrice));
	}
	
} 