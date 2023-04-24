package sprites;

import biuoop.DrawSurface;
import listeners.ScoreTrackingListener;
import levels.GameLevel;

import java.awt.Color;

/**
 * this class  will be in charge of displaying the current score.
 */
public class ScoreIndicator implements Sprite {
    private ScoreTrackingListener scoreTrackingListener;
    private String name;
    private int live;

    /**
     * constructor.
     *
     * @param scoreTrackingListener , class that update the score.
     */
    public ScoreIndicator(ScoreTrackingListener scoreTrackingListener) {
        this.scoreTrackingListener = scoreTrackingListener;
    }

    /**
     * setter.
     * @param name , set the name.
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * setter.
     * @param live , set the number of live.
     */
    public void setLive(int live) {
        this.live = live;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.white);
        d.drawText(360, 20, "score:" + " " + Integer.toString(scoreTrackingListener.getCurrentScore().getValue()), 15);
        d.drawText(610, 20, "Level Name: " + name, 15);
        d.drawText(27, 20, "Lives " + Integer.toString(this.live), 15);
    }

    @Override
    public void timePassed() {

    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);

    }
}
