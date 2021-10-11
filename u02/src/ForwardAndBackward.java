public class ForwardAndBackward {
    
    public static void main(String[] args) {
        // TODO 
    	new ForwardAndBackward();
    }
    
    ForwardAndBackward(){
    	for(int i = 1; i < 4; i++) {
    		System.out.println(helper(6-i, " ") + helper(i, "\\") + helper(i, "/"));
    	}
    	for(int i = 3; i > 0; i--) {
    		System.out.println(helper(6-i, " ") + helper(i, "/") + helper(i, "\\"));
    	}
    	
    }
    
    String helper(int n, String m) {
    	String s = "";
    	while(n > 0) 
    	{ s += m; n--; }
    	return s;
    }

}
