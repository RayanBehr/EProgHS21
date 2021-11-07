import java.util.Scanner;
/*
 * Author: Maximiliana Muster
 * für Einfuehrung in die Programmierung, HS 2018
 * 
 * Dieses Programm berechnet mithilfe des Newton-Verfahrens die Quadratwurzel.
 */

public class Newton {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Geben Sie eine ganze positive Zahl ein: ");
		int z = scanner.nextInt();
		if (z <= 0) {
			System.out.println("Keine ganze positive Zahl.");
		} else {
			double root = squareRoot(z);
			System.out.println("Wurzel von " + z + " = " + root);
		}
	}

	/**
	 * Berechnet die Quadratwurzel per Newton-Verfahren auf 12 Stellen
	 * nach dem Komma genau.
	 */
	static double squareRoot(int z) {
		double c = z;
		double t = c / 2.0;
		double eps = 0.000000000001;
		
		while (Math.abs(t * t - c) > eps) {
			t = (c / t + t) / 2.0;			
		}
		
		return t;
	}

}
