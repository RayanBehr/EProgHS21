/*
 * Author:  Rayan Behr
 * 
 * 
 * Dieses Programm gibt den eingegebenen Namen als in einem Quadrat angeordnete Scrabble-Steine aus.
 */
public class Scrabble {
	
	int nLen = 0;
	String out = "";

    public static void main(String[] args) {
		Scrabble s = new Scrabble();	
		System.out.println(s.drawNameSquare("Alfred"));
		System.out.println(s.drawNameSquare("Jim"));
	}
  	
    String drawNameSquare(String name) {
		// TODO: Implementieren Sie die Methode 
    	out = "";
    	nLen = name.length();
    	name = name.toUpperCase();
    	
    	breakLine(nLen); 	
    	for(int j = 0; j < nLen; j++)
    		out += "| " + name.substring(j,j+1) + " ";
    	out += "|\n";  	
    	breakLine(nLen);
    	
    	for(int m = 1; m < nLen-1; m++) {
    		out += "| " + name.substring(m,m+1) + " |";
    		out += " ".repeat(4).repeat(nLen-3); out += " ".repeat(3);
    		out += "| " + name.substring(nLen-m-1,nLen-m) + " |";
    		out += "\n";
        	if(m < nLen-2) { out += "+---+"  +
        							" ".repeat(4).repeat(nLen-3) +
        							" ".repeat(3) +
        							"+---+\n"; }
    	}
    	
    	breakLine(nLen);	
    	for(int j = nLen; j > 0 ; j--)
    		out += "| " + name.substring(j-1,j) + " ";
    	out += "|\n";  	
    	breakLine(nLen);
    	
    	return out;
    }
    
    void breakLine(int len) {
    	out += "+---".repeat(len) + "+\n";
    }

}
