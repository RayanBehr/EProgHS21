
public class AbsoluteMax {
	
	public static void main(String[] args) { 	
		long n = Long.parseLong("139472305678615");
		long m = Long.parseLong("273426584985");
		new AbsoluteMax( n, m); 
	}
	
	// Aendern Sie die Werte um verschiedene Ausfuehrungen zu testen.
	long m, n;
	
	long steps = 0;
	
	// TODO: Vervollstaendigen Sie den Code wie in der Aufgabenbeschreibung beschrieben
	long r;


	public AbsoluteMax(long n, long m) {
		this.n = n;
		this.m = m;

		doStuff();
	}
	
	void doStuff() {
		System.out.println("using Naive Algo");
		//r = gcd(n,m);
		System.out.println("Program would not terminate in time");
		sysout();

		System.out.println("<------------>");
		
		System.out.println("using Euclid's Algo");
		r = gcdR(n,m);
		sysout();
	}
	
	void sysout() {
		// Der finale Wert von r wird ausgegeben
		System.out.println("n: " + n + ", m: " + m + " --> r: " + r + " (computed in: " + steps + " Steps)");
	}
	
	long gcd(long n, long m) {
		steps = 0; 
		for(long d = m; d > 1; d--) {
			steps++; System.out.println(steps);
			if(n%d == 0 && m%d == 0)
				return d;
			}
		return 1;
	}
	
	//can't count steps
	long gcdR(long n, long m) {
		if(n % m == 0) return m;
		else return gcdR(m, n % m);	
	}
	
	long gcdFAST(long n, long m) {
		steps = 0;
		long d; long dd; long ddd;
		d = n; dd = m; ddd = d % dd;	
		System.out.println("( " + d + ", " + dd + ", " + ddd + " )");
		while(true) {
			if( ddd != 0 ) { d = dd % ddd; steps++; }
			else { return dd;  }
			System.out.println("( " + d + ", " + dd + ", " + ddd + " )");
			
			if( d != 0   ) { dd = ddd % d; steps++; }
			else { return ddd; }
			System.out.println("( " + d + ", " + dd + ", " + ddd + " )");
			
			if( dd != 0  ) { ddd = d % dd; steps++; }
			else { return d;   }			
		}	
		
	}
			
}