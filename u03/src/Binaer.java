import java.util.Scanner;
/*
 * Author: Rayan Behr
 * 
 * 
 * Dieses Programm gibt die Binaerdarstellung einer positive Zahl aus, ohne Arrays oder String-
 * Operationen.
 */
public class Binaer {

	public static void main(String[] args) {
		// TODO 
		
		System.out.println(intToBinary(14));
	}
	
	static String intToBinary(int Z){
		int k = (int) Math.floor(Math.log(Z) / Math.log(2));
		return intToBinaryRek(Z, k);
	}
	
	
	static String intToBinaryRek(int Z, int k) {
		if(Z == 0) return "0";
		int r = Z - (int) Math.pow(Z, k);
		
		return 0 < r? "1" +  intToBinaryRek(r, k-1) :
			"1" +  intToBinaryRek(r, k-1);
	}

}
