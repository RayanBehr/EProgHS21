import java.util.Scanner;
/*
 * Author: Rayan Behr
 * 
 * 
 * Dieses Programm liest einen String ein, der eine Siebensegmentanzeige kodiert, und gibt die kodierte Zahl als Integer aus.
 */
public class Zahlen {

	public static void main(String[] args) {
		
		System.out.println(codeToInt("abcdef"));		//0
		System.out.println(codeToInt("bc"));			//1
		System.out.println(codeToInt("abdeg"));			//2	
		System.out.println(codeToInt("abcdg"));			//3
		System.out.println(codeToInt("bcfg"));			//4
		System.out.println(codeToInt("acdfg"));			//5
		System.out.println(codeToInt("acdefg"));		//6
		System.out.println(codeToInt("abc"));			//7
		System.out.println(codeToInt("abcdefg"));		//8
		System.out.println(codeToInt("abcfg"));			//9	
	}
	
	public static int codeToInt(String k) {
		
		//Ich beginne mit den längsten Kodierungen!!!!!!
		if(containsAll(k, "abcdefg")) return 8; //len7
		
		if(containsAll(k, "acdefg")) return 6; //len6
		if(containsAll(k, "abcdef")) return 0; //len6
		
		if(containsAll(k, "abdeg")) return 2; //len5
		if(containsAll(k, "abcdg")) return 3; //len5
		if(containsAll(k, "acdfg")) return 5; //len5
		if(containsAll(k, "abcfg")) return 9; //len5
		
		if(containsAll(k, "bcfg")) return 4; //len4
		
		if(containsAll(k, "abc")) return 7; //len3
		
		return 1; //len2 ist eben die 1
	}
	
	public static boolean containsAll(String kThis, String kOther) {
		if(kOther.equals("")) return true;
		return kThis.contains(kOther.substring(0,1)) &&
			containsAll(kThis, kOther.substring(1)); //substring excluding first character
	}

}
