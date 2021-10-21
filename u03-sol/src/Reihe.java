import java.util.Scanner;

/*
 * Author: Maximiliana Muster
 * für Einfuehrung in die Programmierung, HS 2017
 * 
 * Dieses Programm berechnet die Reihe 1/1^2 + 1/2^2 + ... + 1/N^2
 */
public class Reihe {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Geben Sie eine natürliche Zahl ein: ");
        int n = scanner.nextInt();
        if(n < 0) {
            System.out.println("Keine natürliche Zahl!");
        }
        else {
            double sum = 0;
            for(int i = 1; i <= n; i++) {
                sum += 1.0 / (i * i); 
            }
            System.out.println(sum);
        }
	}
}
