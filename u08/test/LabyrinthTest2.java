import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Stack;

import org.junit.Test;

public class LabyrinthTest2 {

    @Test
    public void task1test1() {  
    	Room r9 = new Room(9,new Room[] {});
    	Room r8 = new Room(8,new Room[] {r9});
    	Room r7 = new Room(7,new Room[] {r8});
    	Room r6 = new Room(6,new Room[] {r7});
    	Room r5 = new Room(2,new Room[] {r6});
    	Room r4 = new Room(2,new Room[] {r5,r6});
    	Room r3 = new Room(2,new Room[] {r4});
    	Room r2 = new Room(2,new Room[] {r3,r4});
    	Room r1 = new Room(1,new Room[] {r2});
    	assertEquals(false, Labyrinth.task1(r1));
    }
    
    @Test
    public void task1test2() {   
    	Room r9 = new Room(9,new Room[] {});
    	Room r8 = new Room(8,new Room[] {r9});
    	Room r7 = new Room(7,new Room[] {r8});
    	Room r6 = new Room(2,new Room[] {r7});
    	Room r5 = new Room(1,new Room[] {r6});
    	Room r4 = new Room(3,new Room[] {r5});
    	Room r3 = new Room(2,new Room[] {r4});
    	Room r2 = new Room(1,new Room[] {r3});
    	Room r1 = new Room(1,new Room[] {r2});
    	assertEquals(true, Labyrinth.task1(r1));
    }
    
    @Test
    public void task1test3() {   
    	Room r9 = new Room(9,new Room[] {});
	    Room r8 = new Room(8,new Room[] {r9});
	    Room r7 = new Room(7,new Room[] {r8});
	    Room r6 = new Room(2,new Room[] {r7});
	    Room r5 = new Room(1,new Room[] {r6});
	    Room r4 = new Room(3,new Room[] {r5});
	    Room r3 = new Room(2,new Room[] {r4});
	    Room r2 = new Room(1,new Room[] {r3});
	    Room r1 = new Room(1,new Room[] {r2});
	    assertEquals(true, Labyrinth.task1(r1));
    }
    
    @Test
    public void task1test4() {
    	Room r10 = new Room(5,new Room[] {});
    	Room r9 = new Room(2,new Room[] {});
      	Room r8 = new Room(8,new Room[] {r9,r10});
      	Room r7 = new Room(7,new Room[] {r8});
      	Room r6 = new Room(2,new Room[] {r7});
      	Room r5 = new Room(1,new Room[] {r6});
      	Room r4 = new Room(3,new Room[] {r5});
      	Room r3 = new Room(2,new Room[] {r4});
      	Room r2 = new Room(1,new Room[] {r3});
      	Room r1 = new Room(1,new Room[] {r2});
      	assertEquals(false, Labyrinth.task1(r1));
    }
    
    @Test
    public void task1test5() {  // 
    	Room r11 = new Room(4,new Room[] {});
    	Room r10 = new Room(5,new Room[] {});
      	Room r9 = new Room(2,new Room[] {});
      	Room r8 = new Room(8,new Room[] {r9,r10});
      	Room r7 = new Room(7,new Room[] {r8});
      	Room r6 = new Room(2,new Room[] {r7,r10,r11});
      	Room r5 = new Room(1,new Room[] {r6});
      	Room r4 = new Room(3,new Room[] {r5});
      	Room r3 = new Room(2,new Room[] {r4});
      	Room r2 = new Room(1,new Room[] {r3});
      	Room r1 = new Room(1,new Room[] {r2});
      	assertEquals(true, Labyrinth.task1(r1));
    }
  
    @Test
    public void task2test1() {
    	Room r6 = new Room(6,new Room[] {});
    	Room r5 = new Room(5,new Room[] {r6});
    	Room r4 = new Room(4,new Room[] {r6});
    	Room r3 = new Room(3,new Room[] {r4});
    	Room r2 = new Room(2,new Room[] {r5});
    	Room r1 = new Room(1,new Room[] {r2,r3});
    	assertEquals(false, Labyrinth.task2(r1));
    }	
    
    @Test
    public void task2test2() {
      Room r6 = new Room(6,new Room[] {});
      Room r5 = new Room(2,new Room[] {r6});
      Room r4 = new Room(2,new Room[] {r6});
      Room r3 = new Room(2,new Room[] {r4});
      Room r2 = new Room(2,new Room[] {r5});
      Room r1 = new Room(1,new Room[] {r2,r3});
      assertEquals(true, Labyrinth.task2(r1));
    }
    
    @Test
    public void task2test3() {
      Room r9 = new Room(9,new Room[] {});
      Room r8 = new Room(8,new Room[] {r9});
      Room r7 = new Room(7,new Room[] {r8});
      Room r6 = new Room(6,new Room[] {r7});
      Room r5 = new Room(2,new Room[] {r6});
      Room r4 = new Room(2,new Room[] {r6});
      Room r3 = new Room(2,new Room[] {r4});
      Room r2 = new Room(2,new Room[] {r5});
      Room r1 = new Room(1,new Room[] {r2,r3});
      assertEquals(true, Labyrinth.task2(r1));
    }
    
    @Test
    public void task2test4() {
      Room r9 = new Room(9,new Room[] {});
      Room r8 = new Room(8,new Room[] {r9});
      Room r7 = new Room(7,new Room[] {r8});
      Room r6 = new Room(6,new Room[] {r7});
      Room r5 = new Room(2,new Room[] {r6});
      Room r4 = new Room(2,new Room[] {r5});
      Room r3 = new Room(2,new Room[] {r4});
      Room r2 = new Room(2,new Room[] {r3});
      Room r1 = new Room(1,new Room[] {r2});
      assertEquals(false, Labyrinth.task2(r1));
    }
    
    @Test
    public void task2test5() {
      Room r9 = new Room(9,new Room[] {});
      Room r8 = new Room(8,new Room[] {r9});
      Room r7 = new Room(7,new Room[] {r8});
      Room r6 = new Room(6,new Room[] {r7});
      Room r5 = new Room(5,new Room[] {r6});
      Room r4 = new Room(4,new Room[] {r5,r6});
      Room r3 = new Room(3,new Room[] {r4});
      Room r2 = new Room(2,new Room[] {r3,r4});
      Room r1 = new Room(1,new Room[] {r2});
      assertEquals(false, Labyrinth.task2(r1));
    }
    
    @Test
    public void task2test6() {   // it's a very strong test
      Room r9 = new Room(9,new Room[] {});
      Room r8 = new Room(8,new Room[] {r9});
      Room r7 = new Room(7,new Room[] {r8});
      Room r6 = new Room(6,new Room[] {r7});
      Room r5 = new Room(2,new Room[] {r6});
      Room r4 = new Room(2,new Room[] {r5,r6});
      Room r3 = new Room(2,new Room[] {r4});
      Room r2 = new Room(2,new Room[] {r3,r4});
      Room r1 = new Room(1,new Room[] {r2});
      assertEquals(true, Labyrinth.task2(r1));
    }

    @Test
    public void task2test7() {  
    	Room r11 = new Room(10,new Room[] {});
    	Room r10 = new Room(8,new Room[] {r11});
    	Room r9 = new Room(9,new Room[] {});
    	Room r8 = new Room(8,new Room[] {r9});
    	Room r7 = new Room(7,new Room[] {r8,r10});
    	Room r6 = new Room(6,new Room[] {r7});
    	Room r5 = new Room(2,new Room[] {r6});
    	Room r4 = new Room(2,new Room[] {r5});
    	Room r3 = new Room(2,new Room[] {r4});
    	Room r2 = new Room(2,new Room[] {r3});
    	Room r1 = new Room(1,new Room[] {r2});
    	assertEquals(false, Labyrinth.task2(r1));
    }
    
    @Test
    public void task2test8() { 
	    Room r13 = new Room(13,new Room[] {});
	    Room r12 = new Room(12,new Room[] {});
	    Room r11 = new Room(11,new Room[] {});
	    Room r10 = new Room(8,new Room[] {r11,r12,r13});
	    Room r9 = new Room(9,new Room[] {});
	    Room r8 = new Room(8,new Room[] {r9});
	    Room r7 = new Room(7,new Room[] {r8,r10});
	    Room r6 = new Room(6,new Room[] {r7});
	    Room r5 = new Room(2,new Room[] {r6});
	    Room r4 = new Room(2,new Room[] {r5});
	    Room r3 = new Room(2,new Room[] {r4});
	    Room r2 = new Room(2,new Room[] {r3});
	    Room r1 = new Room(1,new Room[] {r2});
	    assertEquals(false, Labyrinth.task2(r1));
    }
    
    @Test
    public void task2test9() { // it's a very strong test
	    Room r13 = new Room(8,new Room[] {});
	    Room r12 = new Room(12,new Room[] {});
	    Room r11 = new Room(11,new Room[] {});
	    Room r10 = new Room(8,new Room[] {r11,r12,r13});
		Room r9 = new Room(9,new Room[] {});
		Room r8 = new Room(8,new Room[] {r9});
		Room r7 = new Room(7,new Room[] {r8,r10});
		Room r6 = new Room(6,new Room[] {r7});
		Room r5 = new Room(5,new Room[] {r6});
		Room r4 = new Room(4,new Room[] {r5});
		Room r3 = new Room(3,new Room[] {r4});
		Room r2 = new Room(2,new Room[] {r3});
		Room r1 = new Room(1,new Room[] {r2});
		assertEquals(false, Labyrinth.task2(r1));
    }
    
    @Test
    public void task2test10() { 
    	Room r13 = new Room(8,new Room[] {});
      	Room r12 = new Room(12,new Room[] {});
      	Room r11 = new Room(11,new Room[] {});
      	Room r10 = new Room(8,new Room[] {r11,r12,r13});
		Room r9 = new Room(9,new Room[] {});
		Room r8 = new Room(8,new Room[] {r9});
		Room r7 = new Room(7,new Room[] {r8,r10});
		Room r6 = new Room(6,new Room[] {r7});
		Room r5 = new Room(2,new Room[] {r6});
		Room r4 = new Room(2,new Room[] {r5});
		Room r3 = new Room(2,new Room[] {r4});
		Room r2 = new Room(2,new Room[] {r3});
		Room r1 = new Room(1,new Room[] {r2});
		assertEquals(false, Labyrinth.task2(r7));
    }
    
    @Test
    public void task2test11() { // it's a very strong test
    	Room r13 = new Room(9,new Room[] {});
      	Room r12 = new Room(12,new Room[] {});
      	Room r11 = new Room(11,new Room[] {});
      	Room r10 = new Room(8,new Room[] {r11,r12,r13});
        Room r9 = new Room(9,new Room[] {});
        Room r8 = new Room(8,new Room[] {r9});
        Room r7 = new Room(7,new Room[] {r8,r10});
        Room r6 = new Room(6,new Room[] {r7});
        Room r5 = new Room(5,new Room[] {r6});
        Room r4 = new Room(4,new Room[] {r5});
        Room r3 = new Room(3,new Room[] {r4});
        Room r2 = new Room(2,new Room[] {r3});
        Room r1 = new Room(1,new Room[] {r2});
        assertEquals(true, Labyrinth.task2(r1));
      }
    @Test
    public void task2test12() { 
    	Room r13 = new Room(9,new Room[] {});
    	Room r12 = new Room(12,new Room[] {});
    	Room r11 = new Room(11,new Room[] {});
    	Room r10 = new Room(8,new Room[] {r11,r12,r13});
        Room r9 = new Room(9,new Room[] {});
        Room r8 = new Room(8,new Room[] {r9});
        Room r7 = new Room(7,new Room[] {r8,r10});
        Room r6 = new Room(6,new Room[] {r7});
        Room r5 = new Room(5,new Room[] {r6});
        Room r4 = new Room(4,new Room[] {r5});
        Room r3 = new Room(3,new Room[] {r4});
        Room r2 = new Room(2,new Room[] {r3});
        Room r1 = new Room(1,new Room[] {r2});
        assertEquals(false, Labyrinth.task2(r11));
      }
    @Test
    public void task2test13() { 
    	Room r13 = new Room(9,new Room[] {});
    	Room r12 = new Room(12,new Room[] {});
    	Room r11 = new Room(11,new Room[] {});
    	Room r10 = new Room(8,new Room[] {r11,r12,r13});
        Room r9 = new Room(9,new Room[] {});
        Room r8 = new Room(8,new Room[] {r9});
        Room r7 = new Room(7,new Room[] {r8,r10});
        Room r6 = new Room(6,new Room[] {r7});
        Room r5 = new Room(5,new Room[] {r6});
        Room r4 = new Room(4,new Room[] {r5});
        Room r3 = new Room(3,new Room[] {r4});
        Room r2 = new Room(2,new Room[] {r3});
        Room r1 = new Room(1,new Room[] {r2});
        assertEquals(true, Labyrinth.task2(r7));
      }
    @Test
    public void task2test14() { 
        Room r14 = new Room(14,new Room[] {});
        Room r13 = new Room(9,new Room[] {r14});
        Room r12 = new Room(12,new Room[] {});
        Room r11 = new Room(11,new Room[] {});
        Room r10 = new Room(8,new Room[] {r11,r12,r13});
        Room r9 = new Room(9,new Room[] {});
        Room r8 = new Room(8,new Room[] {r9});
        Room r7 = new Room(7,new Room[] {r8,r10});
        Room r6 = new Room(6,new Room[] {r7});
        Room r5 = new Room(5,new Room[] {r6});
        Room r4 = new Room(4,new Room[] {r5});
        Room r3 = new Room(3,new Room[] {r4});
        Room r2 = new Room(2,new Room[] {r3});
        Room r1 = new Room(1,new Room[] {r2});
        assertEquals(false, Labyrinth.task2(r1));
      }
    @Test
    public void task2test15() {  // it's a very strong test 
        Room r15 = new Room(15,new Room[] {});
        Room r14 = new Room(14,new Room[] {});
        Room r13 = new Room(9,new Room[] {r14,r15});
        Room r12 = new Room(12,new Room[] {});
        Room r11 = new Room(11,new Room[] {});
        Room r10 = new Room(8,new Room[] {r11,r12,r13});
        Room r9 = new Room(9,new Room[] {});
        Room r8 = new Room(8,new Room[] {r9});
        Room r7 = new Room(7,new Room[] {r8,r10});
        Room r6 = new Room(6,new Room[] {r7});
        Room r5 = new Room(5,new Room[] {r6});
        Room r4 = new Room(4,new Room[] {r5});
        Room r3 = new Room(3,new Room[] {r4});
        Room r2 = new Room(2,new Room[] {r3});
        Room r1 = new Room(1,new Room[] {r2});
        assertEquals(false, Labyrinth.task2(r1));
      }
    @Test
    public void task2test16() {  // it's a very strong test 
        Room r15 = new Room(15,new Room[] {});
        Room r14 = new Room(14,new Room[] {});
        Room r13 = new Room(9,new Room[] {r14,r15});
        Room r12 = new Room(12,new Room[] {});
        Room r11 = new Room(11,new Room[] {});
        Room r10 = new Room(8,new Room[] {r11,r12,r13});
        Room r9 = new Room(9,new Room[] {r15});
        Room r8 = new Room(8,new Room[] {r9});
        Room r7 = new Room(7,new Room[] {r8,r10});
        Room r6 = new Room(6,new Room[] {r7});
        Room r5 = new Room(5,new Room[] {r6});
        Room r4 = new Room(4,new Room[] {r5});
        Room r3 = new Room(3,new Room[] {r4});
        Room r2 = new Room(2,new Room[] {r3});
        Room r1 = new Room(1,new Room[] {r2});
        assertEquals(true, Labyrinth.task2(r1));
      }    
    
    @Test
    public void testStackClone() {
	    Room r = new Room(2, new Room[0]);
	    Stack<Room> stack = new Stack<>();
	    stack.push(r);
	
	    Stack<Room> stack2 = Labyrinth.copy(stack);
	    assertEquals(stack.pop(), stack2.pop());
    }
    
    @Test // tests eve
    public void testTask2Pitfalls() {
        // generates two paths which diverge at the very start and never come together again
        Room[] empty = {};
        Room exit1 = new Room(5, empty);
        Room[] toExit1 = {exit1};
        Room middle1 = new Room(4, toExit1);
        
        Room exit2 = new Room(5, empty);
        Room[] toExit2 = {exit2};
        Room middle2 = new Room(4, toExit2);
        
        Room[] toMiddle = {middle1, middle2};
        Room start = new Room(3, toMiddle);
        
        assertEquals(true, Labyrinth.task2(start));
        
        // generates a labyrinth where the two paths both always have the same age
        // but one of them ends with an exit
        // and the other ends with another room
        Room exit3 = new Room(5, empty);
        Room[] toExit3 = {exit3};
        Room middle3 = new Room(4, toExit3);
        
        Room exit4 = new Room(4, empty);
        
        Room[] toMiddle2 = {middle3, exit4};
        Room start2 = new Room(3, toMiddle2);
        
        assertEquals(false, Labyrinth.task2(start2));
        
        // generates a labyrinth where the two paths diverge first with the same age
        // but then get to different ages
        // before coming together again
        Room finalExit = new Room(6, empty);
        Room[] tofinalExit = {finalExit};
        
        Room exit5 = new Room(42, tofinalExit);
        Room[] toExit5 = {exit5};
        Room middle5 = new Room(4, toExit5);
        
        Room exit6 = new Room(5, tofinalExit);
        Room[] toExit6 = {exit6};
        Room middle6 = new Room(4, toExit6);
        
        Room[] toMiddle3 = {middle5, middle6};
        Room start3 = new Room(3, toMiddle3);
        
        assertEquals(false, Labyrinth.task2(start3));
    }
    
}