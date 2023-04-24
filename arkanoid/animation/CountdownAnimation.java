package animation;

import biuoop.DrawSurface;
import sprites.SpriteCollection;

import java.awt.Color;

/**
 * Count back to the beginning of the level.
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private Boolean shouldStop;
    private int frame;

    /**
     * constructor.
     *
     * @param numOfSeconds , The number of seconds of each digit.
     * @param countFrom    , how many seconds to count.
     * @param gameScreen   , sprite collection.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.shouldStop = false;
        this.frame = (int) this.numOfSeconds * 60;

    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.gameScreen.drawAllOn(d);
        d.setColor(Color.white);
        d.drawText(400, 280, String.valueOf((this.frame / 60) + 1), 50);
        this.frame--;
        if (this.frame == 0) {
            this.shouldStop = true;
        }

    }

    @Override
    public boolean shouldStop() {
        return this.shouldStop;
    }
}
