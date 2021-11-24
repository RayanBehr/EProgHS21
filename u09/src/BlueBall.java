
public class BlueBall extends Ball {

	@Override
	public int scoreActions(int score, 
							BallPool pool,
							BallGame game) {
		pool.add(new BlueBall());
		return score - this.stickerCount;
	}
	
	
}
