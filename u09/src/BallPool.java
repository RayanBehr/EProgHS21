import java.util.Random;

public class BallPool {
	
	LinkedBallList pool;
	Random random;
	
	public BallPool() {
		pool = new LinkedBallList();
		random = new Random();
	}
	
	public void add(Ball ball) {
		pool.addLast(ball);
	}
	
	public Ball draw() {
		if (pool.isEmpty()) {
			return null;
		}
		
		int index = random.nextInt(pool.size);
		Ball result = pool.remove(index);
		return result;
	}	
}