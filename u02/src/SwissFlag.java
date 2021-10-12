
public class SwissFlag {
	
	String output = "";
	
	String line = "-----------------------------------";

	public static void main(String[] args) { new SwissFlag(); }
	
	SwissFlag(){
		swissFlagNew();
		//swissFlagOld();
		System.out.println(output);
	}
	
	void swissFlagNew() {	
		output += line + "\n";
		addNoPlus();
		addPlus();
		addMiddle();
		addPlus();
		addNoPlus();
		output += line + "\n"; }
	
	void addNoPlus() {	
		output += ("|" + " ".repeat(line.length()-2) 
					   + "|" + "\n").repeat(3); }
	
	void addPlus() {
		output += ("|" + " ".repeat(13) + "+".repeat(7)
					   + " ".repeat(13) + "|" + "\n").repeat(3); }
	
	void addMiddle() {
		output += ("|" + " ".repeat(6) + "+".repeat(21)
					   + " ".repeat(6) + "|" + "\n").repeat(3); }
	
	
	void swissFlagOld(){
		output += line + "\n";	
		output += helper(3, "|" + helper(line.length()-2, " ") + "|" + "\n");		
		output += helper(3, "|" + helper(13, " ") + helper(7, "+") + helper(13, " ") + "|" + "\n");
		output += helper(3, "|" + helper(6, " ") + helper(21, "+") + helper(6, " ") + "|" + "\n");
		output += helper(3, "|" + helper(13, " ") + helper(7, "+") + helper(13, " ") + "|" + "\n");
		output += helper(3, "|" + helper(line.length()-2, " ") + "|" + "\n");		
		output += line + "\n";				
	}

    String helper(int n, String m) {
    	String s = "";
    	while(n > 0) 
    	{ s += m; n--; }
    	return s;
    }
	

}
