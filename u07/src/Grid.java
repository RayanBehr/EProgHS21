
public class Grid {
	
	public static void main(String[] args) {
		Node n00 = new Node(null, null);
		Node n01 = new Node(null, null);
		n00.setRight(n01);
		Node n10 = new Node(null, null);
		n00.setBottom(n10);
		Node n11 = new Node(null, null);
		
		n01.setBottom(n11);
		n10.setRight(n11);
		
		Grid.adjustGrid(n00, 3, 2);
		System.out.println("Executed main for Grid");
	}
	public static void adjustGrid(Node origin, int A, int B) {
		
		Node[][] stru = new Node[A][B];
		
		//count rows
		Node current = origin;
		int a = 0;
		while(current != null) {
			current = current.getBottom();
			a++; }

		//count colums
		current = origin;	
		int b = 0;
		while(current != null) {
			current = current.getRight();
			b++; }	
		
		Node rowStart = origin;	
		for(int i = 0; i < A && i < a; i++) {
			Node rowElement = rowStart;
			for(int j = 0; j < B && j < b; j++) {
				stru[i][j] = rowElement;				
				rowElement = rowElement.getRight(); } //at end null

			rowStart = rowStart.getBottom(); } //at end null
	
	    for(int i = 0; i < A; i++) {
	        for(int j = 0; j < B; j++) {
	            Node curNode = stru[i][j];
	            if (curNode == null)  {
	            	stru[i][j] = new Node(null, null); 
	                curNode = stru[i][j]; }
	            
	            curNode.setRight(null); curNode.setBottom(null);
	            
	            if(i != 0) stru[i-1][j].setBottom(curNode);
	            if(j != 0) stru[i][j-1].setRight(curNode); } }
	    
		for(int i = 0; i < A; i++) {
			for(int j = 0; j < B; j++)
				System.out.print("(" + stru[i][j] + ", " + 
								         stru[i][j].getRight() + ", " +
								         stru[i][j].getBottom() + ")	");
			System.out.println();
		}
		
		System.out.println("###############");
		
    }
	
	/*
	public static void adjustGrid(Node origin, int A, int B) {
		
		//Size of input grid [a][b]
		
		
	    int i = 0;
		for (Node row = origin; row != null; row = row.getBottom()) {
		    int j = 0;
		    for(Node e = row; e != null;  e =  e.getRight()) {
		        if (i < A && j < B) stru[i][j] = e; j++;
		    } i++;
		} 
			
		// i < A && i < a
		// i < Math.min(A, a)
		Node[][] stru = new Node[A][B];
		
		int i = 0;
	    for (Node row = origin; row != null; row = row.getBottom()) {
	        int j = 0;
	        for(Node e = row; e != null;  e =  e.getRight()) {
	            if (i < A && j < B) stru[i][j] = e; j++;
	        } i++;
	    } 

		//full up
		
		//row wise
		for(int i = 0; i < A; i++)
			for(int j = 0; j < B; j++) {
				
				if(stru[i][j].getRight() == null && j < B-1) {
					Node right = new Node(null, null);
					stru[i][j].setRight(right);
					stru[i][j+1] = right;
				}
				
				if(stru[i][j].getBottom() == null && i < A-1) {
					Node bottom = new Node(null, null);
					stru[i][j].setBottom(bottom);
					stru[i+1][j] = bottom;
				}
				
			}
		for(int i = 0; i < A-1; i++) 
			stru[i][B-1].setBottom(stru[i+1][B-1]); // link last column
		for(int j = 0; j < B-1; j++) 
			stru[A-1][j+1].setRight(stru[A-1][j+1]); // link last row
		

		for(int i = 0; i < A; i++) 
			stru[i][B-1].setRight(null); // set right of last column to null
		for(int j = 0; j < B; j++) 
			stru[A-1][j].setBottom(null); // set bottom of last row to null
		
		//...
		
		for(int i = 0; i < A; i++) {
			for(int j = 0; j < B; j++)
				System.out.print("(" + stru[i][j] + ", " + 
								         stru[i][j].getRight() + ", " +
								         stru[i][j].getBottom() + ")	");
			System.out.println();
		}
		
		System.out.println("###############");

	}*/

}
