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