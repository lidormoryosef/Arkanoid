package listeners;

import sprites.Ball;
import sprites.Block;
import sprites.Counter;
import levels.GameLevel;

/**
 * BallRemover will be in charge of removing balls,
 * and updating an available-balls counter.
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter counter;

    /**
     * constructor.
     * @param game , The game board.
     * @param counter , class that charge of number
       of balls in the game.
     */
    public BallRemover(GameLevel game, Counter counter) {
        this.game = game;
        this.counter = counter;

    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        counter.decrease(1);
    }
}
