

public class Split57 {
	
	public static void main(String[] args) {
		//print2dArray(powerSetRelationMatrix(5));
		int[] in4 = {1,2,3,4,5,6,7};
		boolean[][] exs4 = {{true, true, false, false, true, true, false},{false, true, true, true, true, false, false},{false, false, true, false, true, true, false}};
		boolean[] res4 = Split57.split57(in4);
		for(int s = 0; s < res4.length; s++)
			System.out.println(res4[s]);
	}
	
	
	public static boolean[][] powerSetRelationMatrix(int n) {
		// TODO: Implementieren Sie die Methode
		boolean[][] psrm = new boolean[(int)Math.pow(2, n)][n]; 
		// pswc[<power set>][<power set index>]
		
		boolean[] code = new boolean[n]; // 0, 0, 0 ..., 0 row
		
		//iterate over bianry array
		for(int s = 0; s < psrm.length; s++) {
			psrm[s] = code;
			int bi = psrm[0].length-1;
			for(; bi >= 0; bi--)
				if(!code[bi]) {
					//System.out.print(bi);
					code[bi] = true; 
					for(int ni = bi+1; ni < psrm[0].length; ni++)
						code[ni] = false;
					break; }	
			code = code.clone();
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
		for(int i = 0; i < n; i++) free[i] =  (x[i] % 5 == 0) &&  (x[i] % 7 == 0);
		for(int i = 0; i < n; i++) free[i] =  !(x[i] % 5 == 0) &&  !(x[i] % 7 == 0);
		
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			if(ina[i]) cnt++;
			if(inb[i]) cnt++;
			if(free[i]) cnt++; }
		
		int suma = 0; int sumb = 0;
		
		for(int k = 0; k < x.length; k++)
			if(ina[k]) suma += x[k];
		
		for(int k = 0; k < x.length; k++)
			if(inb[k]) sumb += x[k];
		
		cnt = 0; //count the number of elements that are in both
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
				
		boolean[] code = new boolean[cnt]; // cnt = 3, -> onen of {000, 001, 010, 011, 100, 101, 110, 111}
		
		boolean[][] psrm = powerSetRelationMatrix(cnt); //{000, 001, 010, 011, 100, 101, 110, 111}
		
		boolean[] res = new boolean[n]; //res[i]
		//do some boolean array addition stuff...
		//so add 'or' the arrays ina and code together
		//true if and only if x[i] 'is in a' or in inbothVal
		
		for(int s = 0; s < psrm.length; s++) { //iterate trough all of the possible codes
			
			int asum = suma; int bsum = sumb;
			for(int i = 0; i < inbothVal.length; i++) {
				if(psrm[s][i]) asum += inbothVal[i][1];
				else bsum += inbothVal[i][1]; }
			
			System.out.println(psrm.length);
			
			if(asum == bsum) {
				System.out.println(s);
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
	
	/* Printed den Inhalt des Arguments. */
	static void print2dArray(boolean[][] array) {
		
		String[][] strings = new String[array.length][];
		int biggestSize = 0;
		for (int i = 0; i < array.length; i += 1) {
			boolean[] row = array[i];
			strings[i] = new String[row.length];
			for (int j = 0; j < row.length; j += 1) {
				strings[i][j] = Boolean.toString(row[j]);
				if (strings[i][j].length() > biggestSize) {
					biggestSize = strings[i][j].length();
				}
			}
		}
		
		System.out.print("{");
		for (int i = 0; i < strings.length; i += 1) {
			String[] row = strings[i];
			if (i != 0) {
				System.out.print(" ");
			}
			System.out.print("{");
			for (int j = 0; j < row.length; j += 1) {
				if (j != 0) {
					System.out.print(", ");
				}
				int remainder = biggestSize - row[j].length();
				for (int k = 0; k < remainder; k += 1) {
					System.out.print(" ");
				}
				System.out.print(row[j]);
			}
			System.out.print("}");
			if (i == strings.length-1) {
				System.out.println("}");
			} else {
				System.out.println(",");
			}
		}
	}


}
