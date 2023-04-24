package levels;

import geometry.Velocity;
import sprites.Block;
import sprites.Sprite;

import java.util.List;

/**
 * the information we need to know to runner game.
 */
public interface LevelInformation {
    /**
     * return the number of balls in the level.
     * @return , number of balls
     */
    int numberOfBalls();

    /**
     * list of all velocity balls.
     * @return , list of velocity.
     */
    List<Velocity> initialBallVelocities();

    /**
     * the speed of paddle.
     * @return , speed.
     */

    int paddleSpeed();

    /**
     * the width of paddle.
     * @return , width.
     */
    int paddleWidth();

    /**
     * the level name will be displayed at the top of the screen.
     * @return , string name.
     */
    String levelName();

    /**
     * Returns a sprite with the background of the level.
     * @return , background.
     */
    Sprite getBackground();

    /**
     * the Blocks that make up this level, each block contains
     * its size, color and location.
     * @return , list of blocks.
     */
    List<Block> blocks();

    // Number of blocks that should be removed
// before the level is considered to be "cleared".
// This number should be <= blocks.size();

    /**
     * Number of blocks that should be removed
     * before the level is considered to be "cleared".
     * @return , number of blocks.
     */
    int numberOfBlocksToRemove();
}
