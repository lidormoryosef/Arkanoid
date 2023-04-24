package listeners;

import geometry.Point;
import sprites.Ball;
import sprites.Block;
import sprites.Counter;
import sprites.GameEnvironment;
import levels.GameLevel;

/**
 * if the ball hit in this block, one more ball.
 */
public class BlockLife implements HitListener {
    private GameLevel game;
    private Counter counterBall;
    private Counter counterBlock;
    private GameEnvironment gameEnvironment;
    /**
     * constructor.
     * @param game , The game board.
     * @param removedBlocks , class that charge of number
     * of blocks in the game.
     * @param counterBall , class that charge of number
     * of balls in the game.
     * @param gameEnvironment , list of all the sprites in the game.
     */
    public BlockLife(GameLevel game, Counter removedBlocks, Counter counterBall, GameEnvironment gameEnvironment) {
        this.game = game;
        this.counterBlock = removedBlocks;
        this.counterBall = counterBall;
        this.gameEnvironment = gameEnvironment;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(this.game);
        beingHit.removeHitListener(this);
        Ball ball1 = new Ball(new Point(hitter.getX(), hitter.getY()), hitter.getSize(), hitter.getColor());
        ball1.setGameEnvironment(this.gameEnvironment);
        ball1.setVelocity(-hitter.getVelocity().getDx(), -hitter.getVelocity().getDy());
        ball1.addToGame(this.game);
        this.counterBlock.decrease(1);
        this.counterBall.increase(1);
    }
}
