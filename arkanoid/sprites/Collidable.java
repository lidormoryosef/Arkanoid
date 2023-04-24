package sprites;

import biuoop.DrawSurface;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import levels.GameLevel;

/**
 * The sprites.Collidable interface will be used by things that can be collided with.
 */
public interface Collidable {
    /**
     * Return the "collision shape" of the object.
     * @return rectangle.
     */
    Rectangle getCollisionRectangle();
    /**
     * Notify the object that we collided with it at collisionPoint with
     * a given velocity.
     * The return is the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     * @param collisionPoint , The point of collision.
     * @param currentVelocity , the velocity that we want to upload.
     * @param hitter , the ball that hit.
     * @return the new velocity.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
    /**
     * draw the collidable on the given DrawSurface.
     * @param d , DrawSurface.
     */
    void drawOn(DrawSurface d);

    /**
     * This function adds the collidable to the screen.
     * @param game , game.
     */
    void addToGame(GameLevel game);
}
