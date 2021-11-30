
import java.util.Stack;

public class BallGame {
	
	BallPool pool;
	
	Stack<Integer> drawsToSkip = new Stack<>();
	
	public BallGame(BallPool pool) {
		this.pool = pool;
	}

	public int playGame(int turns, int startScore) {
		int score = startScore;	
		
		for(int t = 0; t < turns; t++) 
		{
			Ball draw = pool.draw();
			if(!drawsToSkip.contains(t))
			{			
				score = draw.scoreActions(score, pool, this); //we add absed on what we draw
				
				if(draw.getClass()
						.toString()
						.equals("class HabsburgerYellowBall"))
					drawsToSkip.push(t + 3);				
			}
			draw.stickerCount++; // haha
			pool.add(draw);
		}
			
		
		return score;
	}
}
