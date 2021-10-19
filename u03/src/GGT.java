import java.util.Scanner;
/*
 * Author: 
 * 
 * 
 * Dieses Programm berechnet den GGT von zwei ganzen Zahlen.
 */
public class GGT {
	
	static int iterations = 0;

	
	public static void main(String[] args) {
		// TODO 
		long n = Long.parseLong("139472305678615");
		long m = Long.parseLong("273426584985");
		
		System.out.println("using Euclid's Algo");
		System.out.println("The GCD of " + n + " and " + m + " is " + gcdFAST(n,m));
		System.out.println("Computed in " + iterations+ " iterations");

	}
	
	
	static long gcdFAST(long n, long m) {
		iterations = 0;
		long d; long dd; long ddd;
		d = n; dd = m; ddd = d % dd;	
		System.out.println("( " + d + ", " + dd + ", " + ddd + " )");
		while(true) {
			if( ddd != 0 ) { d = dd % ddd; iterations++; }
			else { return dd;  }
			System.out.println("( " + d + ", " + dd + ", " + ddd + " )");
			
			if( d != 0   ) { dd = ddd % d; iterations++; }
			else { return ddd; }
			System.out.println("( " + d + ", " + dd + ", " + ddd + " )");
			
			if( dd != 0  ) { ddd = d % dd; iterations++; }
			else { return d;   }			
		}		
	}

}
