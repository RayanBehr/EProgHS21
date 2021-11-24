
public class GreenBall extends Ball {
	
	@Override
	public int scoreActions(int score,
							BallPool pool,
							BallGame game) {
		return score + this.stickerCount;
	}
	
}
