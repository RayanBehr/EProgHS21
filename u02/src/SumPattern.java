
public class SumPattern {
	public static void main(String[] args) {
		// Aendern Sie die Werte um verschiedene Ausfuehrungen zu testen.
		int a = 4;
		int b = 10;
		int c = 6;
		
		// Vervollstaendigen Sie den Code wie in der Aufgabenbeschreibung beschrieben
		if(a + b == c) System.out.println("Moeglich.	" + a +" + " + b  + " == " + c);
		else if(a + c == b) System.out.println("Moeglich.	" + a +" + " + c  + " == " + b);
		else if(c + b == a) System.out.println("Moeglich.	" + c +" + " + b  + " == " + a);
		//Wenn die Summe von zwei der Variablen die dritte ergibt... Die Reihenfolge ist dabei egal!
		else System.out.println("Unmoeglich");
		
	}
}
