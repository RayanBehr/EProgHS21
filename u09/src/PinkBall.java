
public class PinkBall extends Ball {
	
	@Override
	public int scoreActions(int score, 
							BallPool pool,
							BallGame game) {
		score *= 2;		
		pool.draw();
		pool.add(new HabsburgerYellowBall());
		return score;
	}
	
}