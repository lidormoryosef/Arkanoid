package listeners;

import sprites.Ball;
import sprites.Block;
import sprites.Counter;
import levels.GameLevel;

import java.util.List;

/**
 * this class releases the ball from the cage.
 */
public class BlockCage implements HitListener {
    private GameLevel game;
    private Counter counterBlock;
    private Counter counterBall;
    private List<Block> blocks;

    /**
     * constructor.
     * @param game , the environment of game.
     * @param counterBlock , counter of blocks.
     * @param blocks , the blocks of cage.
     * @param counterBall , counter of balls.
     */
    public BlockCage(GameLevel game, Counter counterBlock, java.util.List<Block> blocks, Counter counterBall) {
        this.game = game;
        this.counterBlock = counterBlock;
        this.blocks = blocks;
        this.counterBall = counterBall;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(this.game);
        for (int i = 0; i < blocks.size(); i++) {
            blocks.get(i).removeFromGame(this.game);

        }
        beingHit.removeHitListener(this);
        this.counterBlock.decrease(1);
        this.counterBall.increase(1);

    }
}

