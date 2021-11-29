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
			System.out.println("---------- " + p1.myPool.size);
			BallGame g1 = new BallGame(p1);		
			//System.out.println(g1.playGame(t, 0) + ", ");
			assertEquals(g1.playGame(t, 0), vals[t-48]);
			for(int i = 0; p1.myPool.size != 0; i++)
			{
				Ball draw = p1.draw();
				System.out.println(draw.getClass() + ": " + i);
			}
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