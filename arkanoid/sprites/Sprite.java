package sprites;

import biuoop.DrawSurface;
import levels.GameLevel;

/**
 * interface of all the object that can be drawn to the screen.
 */
public interface Sprite {
    /**
     * draw the sprite to the screen.
     * @param d , DrawSurface.
     */
    void drawOn(DrawSurface d);
    /**
     * notify the sprite that time has passed.
     */
    void timePassed();

    /**
     * add to game.
     * @param g , game.
     */
    void addToGame(GameLevel g);
}
