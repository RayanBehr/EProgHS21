
public class SwissFlag {
	
	String output = "";
	
	String line = "-----------------------------------";

	public static void main(String[] args) { new SwissFlag(); }
	
	SwissFlag(){
		line.length();
		
		output += line + "\n";	
		output += helper(3, "|" + helper(line.length()-2, " ") + "|" + "\n");	
		
		output += helper(3, "|" + helper(13, " ") + helper(7, "+") + helper(13, " ") + "|" + "\n");
		output += helper(3, "|" + helper(6, " ") + helper(21, "+") + helper(6, " ") + "|" + "\n");
		output += helper(3, "|" + helper(13, " ") + helper(7, "+") + helper(13, " ") + "|" + "\n");
		

		output += helper(3, "|" + helper(line.length()-2, " ") + "|" + "\n");		
		output += line + "\n";
		
		
		System.out.println(output);
	}

    String helper(int n, String m) {
    	String s = "";
    	while(n > 0) 
    	{ s += m; n--; }
    	return s;
    }
	

}
