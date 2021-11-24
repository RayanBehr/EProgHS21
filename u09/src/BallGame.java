import java.util.ArrayList;

public class BallGame {
	
	BallPool pool;
	
	ArrayList<Integer> drawsToSkip = new ArrayList<>();
	
	public BallGame(BallPool pool) {
		this.pool = pool;
	}

	public int playGame(int turns, int startScore) {
		int score = startScore;	
		
		for(int t = 0; t < turns; t++) 
		{
			if(!drawsToSkip.contains(t))
			{
				Ball draw = pool.draw();
				
				score = draw.scoreActions(score, pool, this); //we add absed on what we draw
				
				if(draw.getClass()
						.toString()
						.equals("class HabsburgerYellowBall"))
					drawsToSkip.add(t + 3);
	
				draw.stickerCount++;
				
				pool.add(draw);
			}
		}
			
		
		return score;
	}
}
