package listeners;

import sprites.Ball;
import sprites.Block;
import sprites.Counter;

/**
 * update this counter when blocks are being hit and removed.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * constructor.
     * @param scoreCounter , class that charge to score in the game.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * getter.
     * @return , currentScore.
     */
    public Counter getCurrentScore() {
        return this.currentScore;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);

    }
}
