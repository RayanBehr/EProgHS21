

public class Split57 {
		
	public static boolean[][] powerSetRelationMatrix(int n) {
		// TODO: Implementieren Sie die Methode
		boolean[][] psrm = new boolean[(int)Math.pow(2, n)][n]; 
		// pswc[<power set>][<power set index>]
		
		boolean[] code = new boolean[n]; // 0, 0, 0 ..., 0 row
		
		//iterate over bianry array
		for(int s = 0; s < psrm.length; s++) {
			psrm[s] = code.clone();
			int bi = psrm[0].length-1;
			for(; bi >= 0; bi--)
				if(!code[bi]) {
					//System.out.print(bi);
					code[bi] = true; 
					for(int ni = bi+1; ni < psrm[0].length; ni++)
						code[ni] = false;
					break; }	
		}	
		return psrm;
	}
	
	public static boolean[] split57(int[] x) {
		// TODO: Implementieren Sie die Methode
		int n = x.length;
		boolean[] ina = new boolean[n];
		boolean[] inb = new boolean[n];
		boolean[] free = new boolean[n];
		
		for(int i = 0; i < n; i++) ina[i]    =  (x[i] % 5 == 0) && !(x[i] % 7 == 0); 		
		for(int i = 0; i < n; i++) inb[i]    = !(x[i] % 5 == 0) &&  (x[i] % 7 == 0);
		for(int i = 0; i < n; i++) free[i]   = (x[i] % 5 == 0) &&  (x[i] % 7 == 0);
		for(int i = 0; i < n; i++) if(!free[i])free[i]   = !(x[i] % 5 == 0) &&  !(x[i] % 7 == 0);
		
		int suma = 0; int sumb = 0;
		
		for(int k = 0; k < x.length; k++)
			if(ina[k]) suma += x[k];
		
		for(int k = 0; k < x.length; k++)
			if(inb[k]) sumb += x[k];
		
		int cnt = 0; //count the number of elements that are in both
		for(int k = 0; k < x.length; k++)
			if(free[k]) cnt++;
		
		int[][] inbothVal = new int[cnt][2]; 
		// inbothVal[<element>][<index> | <value>]
		
		int j = 0;
		for(int k = 0; k < x.length; k++)
			if(free[k]) {
				inbothVal[j][0] = k;
				inbothVal[j][1] = x[k];
				j++; }
		
		//wie platziere ich, welche elemente aus 'beides' platziere ich wo
		//damit die Summe 
				
		boolean[] code = new boolean[cnt]; // cnt = 3, -> one of {000, 001, 010, 011, 100, 101, 110, 111}
		//System.out.println(code.length);
		boolean[][] psrm = powerSetRelationMatrix(cnt); //{000, 001, 010, 011, 100, 101, 110, 111}
		
		/*
		for(int s = 0; s < psrm.length; s++) {
			for(int o = 0; o < inbothVal.length; o++)
				System.out.print(psrm[s][o] + " ");
			System.out.println();
		}*/
		
		boolean[] res = new boolean[n]; //res[i]
		//do some boolean array addition stuff...
		//so add 'or' the arrays ina and code together
		//true if and only if x[i] 'is in a' or in inbothVal
		
		for(int s = 0; s < psrm.length; s++) { //iterate trough all of the possible codes
			
			int asum = suma; int bsum = sumb;
			for(int i = 0; i < inbothVal.length; i++) {
				if(psrm[s][i]) asum += inbothVal[i][1];
				else bsum += inbothVal[i][1]; }
			
			/*
			System.out.println(s + " " + asum + " " + bsum);
			for(int o = 0; o < inbothVal.length; o++)
				System.out.print(psrm[s][o] + " ");
			System.out.println(); */
			
			if(asum == bsum) {
				code = psrm[s];
				
				//copy ina to res
				for(int k = 0; k < x.length; k++)
					res[k] = ina[k];
				
				//where code[k] is true, then res at index inbothVal[k][0] is true
				for(int k = 0; k < code.length; k++)
					if(code[k]) res[inbothVal[k][0]] = true;

				return res; }	
			
		} return null;		
	}

}
