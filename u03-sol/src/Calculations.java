
public class Calculations {
	
	public static int checksum(int x) {
		// TODO: Vervollstaendigen Sie den Code wie in der Aufgabenbeschreibung beschrieben
		
		if (x < 10) { // Recursion Base Case falls das Argument aus nur einer Ziffer besteht.
			return x;
		} else { // Ansonsten ist die Quersumme gleich die Summe der letzten Ziffer plus die Quersumme der restlichen Ziffern.
			return x%10 + checksum(x/10);
		}
	}
	
	public static boolean magic7(int a, int b) {
		// TODO: Vervollstaendigen Sie den Code wie in der Aufgabenbeschreibung beschrieben

		// Wir pruefen alle Bedingungen.
		return a == 7 || b == 7 || a+b == 7 || a-b == 7 || b-a == 7;
	}
	
	public static boolean fast12(int z) {
		// TODO: Vervollstaendigen Sie den Code wie in der Aufgabenbeschreibung beschrieben
		
		// Eine Zahl x ist um y groesser oder kleiner als z, falls x+y zwischen z und z+2*y ist.
		// Wir wollen das für alle z testen, welche ein Vielfaches von 12 sind. 
		return (z + 2)%12 <= 4;
	}
}
