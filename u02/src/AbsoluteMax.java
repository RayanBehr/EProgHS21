
public class AbsoluteMax {
	
	public static void main(String[] args) { new AbsoluteMax(4, -5, 3, -1); }
	
	// Aendern Sie die Werte um verschiedene Ausfuehrungen zu testen.
	int a, b, c;
	
	// TODO: Vervollstaendigen Sie den Code wie in der Aufgabenbeschreibung beschrieben
	int r;


	public AbsoluteMax(int a, int b, int c, int r) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.r = r; //
		
		sysout();
	}
	
	void sysout() {
		// Der finale Wert von r wird ausgegeben
		System.out.println("a: " + a + ", b: " + b + 
					       ", c: " + c + " --> r: " + r);
	}
}