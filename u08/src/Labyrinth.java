import java.util.Stack;

public class Labyrinth {

	public static boolean task1(Room room) {	
		int sum = room.getAge();
		return rec1(room, sum);
	}
	
	public static boolean rec1(Room room, int sum) {
			
		// abort if sum of ages leading to this is divisible by three
		if(sum %3 == 0) return false;
		
		//case: foudn exit
		if(room.isExit()) return true;
		
		//go to ajecent rooms
		for(Room ajRoom : room.doorsTo) {
			int nextSum =  sum + ajRoom.getAge();
			
			if(ajRoom != room && //go to the same room
					rec1(ajRoom, nextSum))
				return true;			}
		
		return false;
	}
	
	public static boolean task2(Room room) {		
		
		Stack<Room> memoA = new Stack<>(); 
		Stack<Room> memoB = new Stack<>(); 	
		
		for(Room ajRoomA : room.doorsTo)
			for(Room ajRoomB : room.doorsTo) 
			{ // we try to find two ajecent rooms with the same age									
				if(ajRoomA.getAge() == ajRoomB.getAge())
				{
					// we add the ajecent rooms to the memo
					memoA.push(ajRoomA); memoB.push(ajRoomB);
					
					//if the recursion evaluates to true we found it
					if(rec2(ajRoomA, ajRoomB, copy(memoA), copy(memoB)))
						return true;	
					
					// we remove the rooms we just pushed, because we want to try another combination
					memoA.pop(); memoB.pop(); //revert memo
				}
			}		
		return false;
	}
	
	public static boolean rec2(Room roomA, Room roomB, Stack<Room> memoA, Stack<Room> memoB) {
		
		// if we have exits it won't run 'for each'
		for(Room ajRoomA : roomA.doorsTo)
			for(Room ajRoomB : roomB.doorsTo)
			{ // for every ajecent room combination with same age				
				if(ajRoomA.getAge() == ajRoomB.getAge()) 
				{			
					// we add the ajecent rooms to the memo
					memoA.push(ajRoomA); memoB.push(ajRoomB); //new combination	
					
					//if the recursion evaluates to true we found it
					if(rec2(ajRoomA, ajRoomB, copy(memoA), copy(memoB)))
						return true;	
					
					// we remove the rooms we just pushed, because we want to try another combination
					memoA.pop(); memoB.pop(); //revert memo
				}
			}
		
		if(roomA.isExit() && roomB.isExit())
		{
			// we backup our memo
			Stack<Room> memoSaveA = copy(memoA); Stack<Room> memoSaveB = copy(memoB); 
			
			// we only want to return true if they are different somewhere
			while(memoA.size() > 0) // stacks have same size
				if(memoA.pop() != memoB.pop()) {
					/*
					for(int i = 0; i < memoSaveA.size(); i++) {
						Room a = memoSaveA.pop();
						Room b = memoSaveB.pop();						
						System.out.println("Reference: " + a + ",	Age: " + a.getAge() + "	" + 
									       "Reference: " + b + ",	Age: " + b.getAge());
					}
					System.out.println("--------------------");*/
					return true;
				}		
			// we restore our memo
			memoA = memoSaveA; memoB = memoSaveB;	
		}
		
		return false;
	}
	
	
	/*
	 * return Returns a copied Stack with the same elements
	 */
	public static Stack<Room> copy(Stack<Room> st) {
		
		Stack<Room> flip = new Stack<>();
		while(st.size() > 0)
			flip.push(st.pop());	
		
		Stack<Room> stCopy = new Stack<>();
		while(flip.size() > 0) {
			Room ele = flip.pop();
			stCopy.push(ele);
			st.push(ele); }
			
		return stCopy;	
	}
	
	
}
