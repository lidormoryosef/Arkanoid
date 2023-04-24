package listeners;
import sprites.Ball;
import sprites.Block;
import sprites.Counter;
import levels.GameLevel;

/**
 * if the ball hit in this block him out of game.
 */
public class BlockKilling implements HitListener {
    private GameLevel game;
    private Counter counterBall;
    private Counter counterBlock;

    /**
     * constructor.
     * @param game , The game board.
     * @param removedBlocks , class that charge of number
     *        of blocks in the game.
     * @param counterBall , class that charge of number
     *        of balls in the game.
     */
    public BlockKilling(GameLevel game, Counter removedBlocks, Counter counterBall) {
        this.game = game;
        this.counterBlock = removedBlocks;
        this.counterBall = counterBall;

    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(this.game);
        beingHit.removeHitListener(this);
        hitter.removeFromGame(this.game);
        hitter.getCenter().setY(1500);
        this.counterBlock.decrease(1);
        this.counterBall.decrease(1);
    }
}
