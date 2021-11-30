import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BallGameTest {

	@Test
	public void testGreen1() {
		Ball[] b1 = {new GreenBall()};
		assertEquals(10, new BallGame(new TestBallPool(b1)).playGame(5, 0));
		
		Ball[] b2 = {new GreenBall(), new GreenBall()};
		assertEquals(4, new BallGame(new TestBallPool(b2)).playGame(5, 0));
		
		Ball[] b3 = {new GreenBall(), new GreenBall(), new GreenBall(), new GreenBall(), new GreenBall()};
		assertEquals(0, new BallGame(new TestBallPool(b3)).playGame(5, 0));
	}
	
	@Test
	public void testBlue1() {
		Ball[] b1 = {new BlueBall()};
		assertEquals(-2, new BallGame(new TestBallPool(b1)).playGame(5, 0));
		
		Ball[] b2 = {new BlueBall(), new BlueBall()};
		assertEquals(-1, new BallGame(new TestBallPool(b2)).playGame(5, 0));
		
		Ball[] b3 = {new BlueBall()};
		assertEquals(-4, new BallGame(new TestBallPool(b3)).playGame(7, 0));
	}
	
	@Test
	public void testRed1() {
		Ball[] b1 = {new GreenBall(), new GreenBall(), new RedBall()};
		assertEquals(0, new BallGame(new TestBallPool(b1)).playGame(3, 0));
		
		Ball[] b2 = {new GreenBall(), new GreenBall(), new RedBall()};
		assertEquals(2, new BallGame(new TestBallPool(b2)).playGame(5, 0));
		
		Ball[] b3 = {new GreenBall(), new GreenBall(), new RedBall()};
		assertEquals(8, new BallGame(new TestBallPool(b3)).playGame(7, 0));
	}
	
	@Test
	public void testPink1() {
		Ball[] b1 = {new GreenBall(), new GreenBall(), new PinkBall()};
		assertEquals(0, new BallGame(new TestBallPool(b1)).playGame(3, 0));
		
		Ball[] b2 = {new GreenBall(), new GreenBall(), new PinkBall()};
		assertEquals(1, new BallGame(new TestBallPool(b2)).playGame(5, 0));
		
		Ball[] b3 = {new GreenBall(), new GreenBall(), new PinkBall()};
		assertEquals(3, new BallGame(new TestBallPool(b3)).playGame(8, 0));
	}
	
	@Test
	public void testContinuous1() {
		Ball[] b1 = {new BlueBall()};
		BallPool p1 = new TestBallPool(b1);
		BallGame g1 = new BallGame(p1);
		
		assertEquals(-2, g1.playGame(5, 0));
		assertEquals(-2, g1.playGame(2, 0)); // Benutzt den letzten Pool!
	}
	
	@Test
	public void testContinuousCusrom1() {
		
		int[] vals = new int[] {33, 
								36, 
								39, 
								78, 
								156, 
								153, 
								153, 
								152, 
								152, 
								150, 
								150, 
								149, 
								149, 
								145, 
								149, 
								153, 
								153, 
								152, 
								152, 
								150, 
								150, 
								149, 
								149, 
								146, 
								146, 
								145, 
								145, 
								143, 
								143, 
								142, 
								142, 
								138, 
								142, 
								146, 
								292, 
								584, 
								580, 
								580, 
								579, 
								579, 
								577, 
								577, 
								576, 
								576, 
								573, 
								573, 
								572, 
								572, 
								570, 
								570, 
								569, 
								569, 
								564, 
								569, 
								574, 
								574, 
								573, 
								573, 
								571, 
								571, 
								570, 
								570, 
								567, 
								567, 
								566, 
								566, 
								564, 
								564, 
								563, 
								563, 
								559, 
								559, 
								558, 
								558, 
								556, 
								556, 
								555, 
								555, 
								552, 
								552, 
								551, 
								551, 
								549, 
								549, 
								548, 
								548, 
								543, 
								548, 
								553};
	
		
		for(int t = 48; t < 137; t++)
		{
			Ball[] b1 = {new PinkBall(),
						 new GreenBall(),
						 new RedBall(),
						 new PinkBall(),
						 new BlueBall(),
						 new GreenBall(),
						 new GreenBall(),
						 new BlueBall(),
						 new GreenBall(),
						 new GreenBall(),
						 new RedBall()};
			TestBallPool p1 = new TestBallPool(b1);
			//System.out.println("---------- " + p1.myPool.size);
			BallGame g1 = new BallGame(p1);		
			//System.out.println(g1.playGame(t, 0) + ", ");
			assertEquals(g1.playGame(t, 0), vals[t-48]);
			/*
			for(int i = 0; p1.myPool.size != 0; i++)
			{
				Ball draw = p1.draw();
				System.out.println(draw.getClass() + ": " + i);
			}*/
		}
		

	}
	
    @Test
    public void testContinuous2() {
        // testing yellow ball behavior (once)
        Ball[] b1 = {
                new PinkBall(),
                new GreenBall(),
                new GreenBall(),
                new GreenBall()};
        BallPool p1 = new TestBallPool2(b1);
        BallGame g1 = new BallGame(p1);

        assertEquals(17, g1.playGame(11, 17));
    }
    
    @Test
	public void testContinuous3() { //Lu's test
		Ball[] b1 = {new GreenBall(), new PinkBall(), new GreenBall(), new GreenBall()};
		BallPool p1 = new TestBallPool(b1);
		BallGame g1 = new BallGame(p1);
		assertEquals(1, g1.playGame(1, 1)); // Green ball drawn +0
		
		Ball[] b2 = {new GreenBall(), new PinkBall(), new GreenBall(), new GreenBall()};
		BallPool p2 = new TestBallPool(b2);
		BallGame g2 = new BallGame(p2);
		assertEquals(2, g2.playGame(2, 1)); // Pink ball drawn *2, second green ball removed
		
		Ball[] b3 = {new GreenBall(), new PinkBall(), new GreenBall(), new GreenBall()};
		BallPool p3 = new TestBallPool(b3);
		BallGame g3 = new BallGame(p3);
		assertEquals(2, g3.playGame(3, 1)); // third green ball drawn, +0
		
		Ball[] b4 = {new GreenBall(), new PinkBall(), new GreenBall(), new GreenBall()};
		BallPool p4 = new TestBallPool(b4);
		BallGame g4 = new BallGame(p4);
		assertEquals(3, g4.playGame(4, 1)); // first green ball drawn, +1
		
		Ball[] b5 = {new GreenBall(), new PinkBall(), new GreenBall(), new GreenBall()};
		BallPool p5 = new TestBallPool(b5);
		BallGame g5 = new BallGame(p5);
		assertEquals(1, g5.playGame(5, 1)); // yellow ball drawn *0+1, the third ball will have no effect
		
		Ball[] b6 = {new GreenBall(), new PinkBall(), new GreenBall(), new GreenBall()};
		BallPool p6 = new TestBallPool(b6);
		BallGame g6 = new BallGame(p6);
		assertEquals(2, g6.playGame(6, 1)); // pink ball drawn *2, third green ball removed
		
		Ball[] b7 = {new GreenBall(), new PinkBall(), new GreenBall(), new GreenBall()};
		BallPool p7 = new TestBallPool(b7);
		BallGame g7 = new BallGame(p7);
		assertEquals(4, g7.playGame(7, 1)); // first green ball drawn, +2
		
		Ball[] b8 = {new GreenBall(), new PinkBall(), new GreenBall(), new GreenBall()};
		BallPool p8 = new TestBallPool(b8);
		BallGame g8 = new BallGame(p8);
		assertEquals(4, g8.playGame(8, 1)); // first yellow ball drawn, no effect (see above)
		
		Ball[] b9 = {new GreenBall(), new PinkBall(), new GreenBall(), new GreenBall()};
		BallPool p9 = new TestBallPool(b9);
		BallGame g9 = new BallGame(p9);
		assertEquals(1, g9.playGame(9, 1)); // second yellow ball drawn *0+1, the third ball will have no effect
		
		Ball[] b10 = {new GreenBall(), new PinkBall(), new GreenBall(), new GreenBall()};
		BallPool p10 = new TestBallPool(b10);
		BallGame g10 = new BallGame(p10);
		assertEquals(2, g10.playGame(10, 1)); // pink ball drawn *2, first green ball removed
		
		Ball[] b11 = {new GreenBall(), new PinkBall(), new GreenBall(), new GreenBall()};
		BallPool p11 = new TestBallPool(b11);
		BallGame g11 = new BallGame(p11);
		assertEquals(5, g11.playGame(11, 1)); // first yellow ball drawn, *2+1, the third ball will have no effect
		
		Ball[] b12 = {new GreenBall(), new PinkBall(), new GreenBall(), new GreenBall()};
		BallPool p12 = new TestBallPool(b12);
		BallGame g12 = new BallGame(p12);
		assertEquals(5, g12.playGame(12, 1)); // second yellow ball drawn, no effect (see above)
		
		Ball[] b13 = {new GreenBall(), new PinkBall(), new GreenBall(), new GreenBall()};
		BallPool p13 = new TestBallPool(b13);
		BallGame g13 = new BallGame(p13);
		assertEquals(1, g13.playGame(13, 1)); // third yellow ball drawn, the third ball will have no effect
		
		Ball[] b14 = {new GreenBall(), new PinkBall(), new GreenBall(), new GreenBall()};
		BallPool p14 = new TestBallPool(b14);
		BallGame g14 = new BallGame(p14);
		assertEquals(1, g14.playGame(14, 1)); // pink ball drawn, no effect (see above)
		
		Ball[] b15 = {new GreenBall(), new PinkBall(), new GreenBall(), new GreenBall()};
		BallPool p15 = new TestBallPool(b15);
		BallGame g15 = new BallGame(p15);
		assertEquals(4, g15.playGame(15, 1)); // first yellow ball drawn, *3+1, the third ball will have no effect
		
		Ball[] b16 = {new GreenBall(), new PinkBall(), new GreenBall(), new GreenBall()};
		BallPool p16 = new TestBallPool(b16);
		BallGame g16 = new BallGame(p16);
		assertEquals(4, g16.playGame(16, 1)); // second yellow ball drawn, no effect (see above)
		
		Ball[] b17 = {new GreenBall(), new PinkBall(), new GreenBall(), new GreenBall()};
		BallPool p17 = new TestBallPool(b17);
		BallGame g17 = new BallGame(p17);
		assertEquals(5, g17.playGame(17, 1)); // third yellow ball drawn, *1+1, the third ball will have no effect
		
		Ball[] b18 = {new GreenBall(), new PinkBall(), new GreenBall(), new GreenBall()};
		BallPool p18 = new TestBallPool(b18);
		BallGame g18 = new BallGame(p18);
		assertEquals(5, g18.playGame(18, 1)); // pink ball drawn, no effect (see above)
		
		Ball[] b19 = {new GreenBall(), new PinkBall(), new GreenBall(), new GreenBall()};
		BallPool p19 = new TestBallPool(b19);
		BallGame g19 = new BallGame(p19);
		assertEquals(21, g19.playGame(19, 1)); // first yellow ball drawn, *4+1, the third ball will have no effect
		
		Ball[] b20 = {new GreenBall(), new PinkBall(), new GreenBall(), new GreenBall()};
		BallPool p20 = new TestBallPool(b20);
		BallGame g20 = new BallGame(p20);
		assertEquals(21, g20.playGame(20, 1)); // second yellow ball drawn, no effect (see above)
		
		Ball[] b21 = {new GreenBall(), new PinkBall(), new GreenBall(), new GreenBall()};
		BallPool p21 = new TestBallPool(b21);
		BallGame g21 = new BallGame(p21);
		assertEquals(43, g21.playGame(21, 1)); // third yellow ball drawn, *2+1, the third ball will have no effect
	}
	
	
}

/** Alternative Implementation von BallPool mit einem deterministischen Ziehen. Es wird immer der erste, dann der zweite Ball aus der Liste gezogen. */
class TestBallPool2 extends BallPool {
    
    LinkedBallList myPool; // Fuer das Korrigieren werden wir nicht LinkedBallList verwenden.
    boolean alt = false;
    
    TestBallPool2(Ball[] balls) {
        this.myPool = new LinkedBallList();
        for (int i = 0; i < balls.length; i += 1) {
            this.myPool.addLast(balls[i]);
        }
    }
    
    @Override
    public void add(Ball ball) {
        myPool.addLast(ball);
    }
    
    @Override
    public Ball draw() {
        if (myPool.isEmpty()) {
            return null;
        }
        
        if (this.alt) {
            this.alt = false;
            return myPool.remove(1);
        } else {
            this.alt = true;
            return myPool.remove(0);
        }
    }
}



/** Alternative Implementation von BallPool mit einem deterministischen Ziehen. Es wird immer der erste Ball aus der Liste gezogen. */
class TestBallPool extends BallPool {
	
	LinkedBallList myPool; // Fuer das Korrigieren werden wir nicht LinkedBallList verwenden.
	
	TestBallPool(Ball[] balls) {
		this.myPool = new LinkedBallList();
		for (int i = 0; i < balls.length; i += 1) {
			this.myPool.addLast(balls[i]);
		}
	}
	
	@Override
	public void add(Ball ball) {
		myPool.addLast(ball);
	}
	
	@Override
	public Ball draw() {
		if (myPool.isEmpty()) {
			return null;
		}
		
		return myPool.remove(0);
	}
}