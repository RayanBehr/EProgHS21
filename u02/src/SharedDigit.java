
public class SharedDigit {
	
	// Aendern Sie die Werte um verschiedene Ausfuehrungen zu testen.
	int a = 10;
	int b = 22;
	
	// TODO: Vervollstaendigen Sie den Code wie in der Aufgabenbeschreibung beschrieben
	int r = -1; // -1 ist Sentinel
	
	public static void main(String[] args) { new SharedDigit(); }
	
	SharedDigit(){
		String sa = String.valueOf(a);
		String sb = String.valueOf(b);
		
		r = Integer.valueOf( aCommonDigit( sa.substring(0,1), sa.substring(1,2),
										   sb.substring(0,1), sb.substring(1,2) ) );
		
		// Der finale Wert von r wird ausgegeben
		System.out.println("a: " + a + ", b: " + b + " --> r: " + r);
	}
	
	String aCommonDigit(String a1, String b1, String a2, String b2) {
		
		if(a1.equals(a2)) return a1;
		if(a1.equals(b2)) return a1;
		
		if(b1.equals(a2)) return b1;
		if(b1.equals(b2)) return b1;
		
		return "-1";
	}
}
