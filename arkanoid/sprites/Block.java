package sprites;

import biuoop.DrawSurface;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import listeners.HitListener;
import levels.GameLevel;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * the obstacle in the game.
 */

public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rectangle;
    private java.awt.Color color;
    private List<HitListener> hitListeners;
    static final double EPSILON = Math.pow(10, -6);

    /**
     * Create a new block with location and width/height.
     *
     * @param upperLeft , the starting point is in the upper left corner.
     * @param width     , the width of rectangle.
     * @param height    , the height of rectangle.
     * @param color     , the color of rectangle.
     */
    public Block(Point upperLeft, double width, double height, java.awt.Color color) {
        this.rectangle = new Rectangle(upperLeft, width, height);
        this.color = color;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * Create a new block with location and width/height.
     *
     * @param rectangle , the block.
     * @param color     , the color of rectangle.
     */
    public Block(Rectangle rectangle, java.awt.Color color) {

        this.rectangle = rectangle;
        this.color = color;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * setter.
     * @param color , color of ball.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * return the color of block.
     *
     * @return , return the color of block.
     */
    public java.awt.Color getColor() {
        return color;
    }

    /**
     * draw the ball on the given DrawSurface.
     *
     * @param surface , drawSurface.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillRectangle((int) this.rectangle.getUpperLeft().getX(),
                (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
        surface.setColor(Color.black);
        surface.drawRectangle((int) this.rectangle.getUpperLeft().getX(),
                (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
    }

    /**
     * time passed.
     */
    public void timePassed() {

    }

    /**
     * Return the "collision shape" of the object.
     *
     * @return rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * Notify the object that we collided with it at collisionPoint with
     * a given velocity.
     * The return is the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     *
     * @param collisionPoint  , The point of collision.
     * @param currentVelocity , the velocity that we want to upload.
     * @param hitter          , ball that hit.
     * @return the new velocity.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        if (rectangle.getUpperLine().pointOnLine(collisionPoint)) {
            currentVelocity.setDy(-currentVelocity.getDy());
            this.notifyHit(hitter);
            return currentVelocity;
        }
        if (rectangle.getDownLine().pointOnLine(collisionPoint)) {
            currentVelocity.setDy(-currentVelocity.getDy());
            this.notifyHit(hitter);
            return currentVelocity;
        }
        if (rectangle.getRightLine().pointOnLine(collisionPoint)) {
            currentVelocity.setDx(-currentVelocity.getDx());
            this.notifyHit(hitter);
            return currentVelocity;
        }
        if (rectangle.getLeftLine().pointOnLine(collisionPoint)) {
            currentVelocity.setDx(-currentVelocity.getDx());
            this.notifyHit(hitter);
            return currentVelocity;
        }
        this.notifyHit(hitter);
        return currentVelocity;


    }

    /**
     * remove this block from the game.
     *
     * @param game , class that charge the board game.
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }

    /**
     * This function adds the ball to the screen.
     *
     * @param g
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);

    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);

    }

    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}
