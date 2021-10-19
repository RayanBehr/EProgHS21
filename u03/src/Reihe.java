import java.util.Scanner;
/*
 * Author: Rayan Behr
 * 
 * 
 * Dieses Programm berechnet die Reihe 1/1^2 + 1/2^2 + ... + 1/N^2
 */
public class Reihe {

	public static void main(String[] args) {
		System.out.print("Input for N: ");
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println("N = " + N + " -> " + funnySum(N));
		sc.close();
	}
	
	static double funnySum(int N) {
		double sum = 0;
		for(int k = 1; k <= N; k++)
			sum += 1 / Math.pow(k,2);
		return sum;
	}
	
	
	int specialSum(int n) {
		int sum = 0;
		for(int j = 1; j < Math.sqrt(n); j++)
			for(int k = j; k <= n; k++)
				sum++;
		return sum*3;
	}
	
	int realSum(int n) {
		int sum = 0;
		for(int j = 1; j <= n; j++)
			if(j*j <= n)
				for(int k = j; k <= n; k++)
					sum++;
		return sum*3;
	}
	

}
