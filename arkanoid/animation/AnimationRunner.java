package animation;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import sprites.Counter;

/**
 * run the game.
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;
    private Counter counterBall;
    private Counter counterBlock;

    /**
     * return the counter ball.
     * @return counter.
     */
    public Counter getCounterBall() {
        return counterBall;
    }

    /**
     * setter.
     * @param counterBall , counter.
     */
    public void setCounterBall(Counter counterBall) {
        this.counterBall = counterBall;
    }

    /**
     * getter.
     * @return , counter.
     */
    public Counter getCounterBlock() {
        return counterBlock;
    }

    /**
     * setter.
     * @param counterBlock , counter.
     */
    public void setCounterBlock(Counter counterBlock) {
        this.counterBlock = counterBlock;
    }

    /**
     * constructor.
     * @param gui , the screen.
     * @param framesPerSecond , count of frame per second.
     */
    public AnimationRunner(GUI gui, int framesPerSecond) {
        this.gui = gui;
        this.framesPerSecond = framesPerSecond;
        this.sleeper = new Sleeper();
    }

    /**
     * run the game.
     * @param animation , the level we want to runner.
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}
