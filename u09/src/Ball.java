
public class Ball {
	int stickerCount = 0;	
	
	// to be overridden
	public int scoreActions(int score, BallPool pool, BallGame game) {
		return score; // nothing happens to the score and pool
		// if the ball is not special
	}
	
}
