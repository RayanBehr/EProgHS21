
public class RedBall extends Ball {
	
	@Override
	public int scoreActions(int score, 
							BallPool pool,
							BallGame game) {	
		score *= 2;		
		pool.draw();
		return score;
	}
	
}
