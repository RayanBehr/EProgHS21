import java.util.Scanner;

public class Sieb {
	
	///*
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("Upper limit: ");
		System.out.println("Number of primes up to inclusive limit: " + 
							anzahlPrimzahlenbis(s.nextInt()));
		
		s.close();
	}//*/
	
	public static int anzahlPrimzahlenbis(int limit) {
		boolean[] notPr = new boolean[limit + 1];
		notPr[0] = true; notPr[1] = true;
		
		for(int i = 2; i <= limit; i++) {
			for(int v = i+i; v <= limit; v += i) {
				notPr[v] = true;
			}
		}
		
		int cnt = 0;
		for(int i = 0; i <= limit; i++) {
			if(notPr[i] == false) cnt++;
		}
		
		return cnt;
	}
}
