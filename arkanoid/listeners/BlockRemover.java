package listeners;

import sprites.Ball;
import sprites.Block;
import sprites.Counter;
import levels.GameLevel;

/**
 * a BlockRemover is in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter c;

    /**
     * constructor.
     * @param game , The game board.
     * @param removedBlocks , class that charge of number
     * of blocks in the game.
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.c = removedBlocks;

    }
    /**
     * Blocks that are hit should be removed
     * from the game. Remember to remove this listener from the block
     * that is being removed from the game.
     * @param beingHit , block that hit.
     * @param hitter , the ball that hit.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(this.game);
        beingHit.removeHitListener(this);
        this.c.decrease(1);

    }

}
