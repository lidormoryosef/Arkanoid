package sprites;
/*
 * @author lidor mor yosef <lidor28799@gmail .com>
 */

import biuoop.DrawSurface;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import levels.GameLevel;
import java.awt.Color;

/**
 * This class create ball with center point.
 */
public class Ball implements Sprite {
    private Point center;
    private final int r;
    private final java.awt.Color color;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;

    static final double EPSILON = 0.5;

    /**
     * This function create a ball object and initializes
     * it with center point,radius, and color.
     *
     * @param center          , the center of ball.
     * @param r               , the radius of ball.
     * @param color           , the color of ball.
     * @param gameEnvironment , all the collidable in the screen.
     */
    public Ball(Point center, int r, java.awt.Color color, GameEnvironment gameEnvironment) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.velocity = new Velocity(0, 0);
        this.gameEnvironment = gameEnvironment;
    }

    /**
     * This function create a ball object and initializes
     * it with center point,radius, and color.
     *
     * @param center , the center of ball.
     * @param r      , the radius of ball.
     * @param color  , the color of ball.
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.velocity = new Velocity(0, 0);
    }

    /**
     * This function create a ball object and initializes
     * it with x and y value of point,radius, and color.
     *
     * @param x               , value on axis x.
     * @param y               , value on axis x.
     * @param r               , the radius of ball.
     * @param color           , the color of ball.
     * @param gameEnvironment , all the collidable in the screen.
     */
    public Ball(int x, int y, int r, java.awt.Color color, GameEnvironment gameEnvironment) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
        this.velocity = new Velocity(0, 0);
        this.gameEnvironment = gameEnvironment;
    }

    /**
     * This function create a ball object and initializes
     * it with x and y value of point,radius, and color.
     *
     * @param x     , value on axis x.
     * @param y     , value on axis x.
     * @param r     , the radius of ball.
     * @param color , the color of ball.
     */
    public Ball(int x, int y, int r, java.awt.Color color) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
        this.velocity = new Velocity(0, 0);
    }

    /**
     * This function return the x value of center point.
     *
     * @return , x value.
     */
    public int getX() {
        return (int) this.center.getX();
    }
    /**
     * getter.
     * @return , center of ball.
     */
    public Point getCenter() {
        return this.center;
    }
    /**
     * This function return the y value of center point.
     *
     * @return , y value.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * This function return the radius of ball.
     *
     * @return , radius of ball.
     */
    public int getSize() {
        return this.r;
    }

    /**
     * This function return the color of ball.
     *
     * @return , color of ball.
     */
    public java.awt.Color getColor() {
        return color;
    }

    /**
     * draw the ball on the given DrawSurface.
     *
     * @param surface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.r);
        surface.setColor(Color.black);
        surface.drawCircle((int) this.center.getX(), (int) this.center.getY(), this.r);
    }

    /**
     * This function moves the ball on the screen.
     */
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * update the obstacles on screen.
     *
     * @param gameEnvironment , new game environment.
     */
    public void setGameEnvironment(GameEnvironment gameEnvironment) {
        this.gameEnvironment = gameEnvironment;
    }

    /**
     * This function update the velocity.
     *
     * @param velocity , the speed of the ball.
     */
    public void setVelocity(Velocity velocity) {
        this.velocity = velocity;
    }

    /**
     * This function update the velocity.
     *
     * @param dx , the new distance.
     * @param dy , the new distance.
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * This function return the velocity.
     *
     * @return velocity, the speed of ball.
     */

    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * This function adds the ball to the screen.
     *
     * @param g
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * This function moves the ball on the screen.
     */
    public void moveOneStep() {
        //Moves the ball in one step.

        //if the ball touch in the bounders.
        double yBefore = this.center.getY();
        Line trajectory = new Line(this.center, this.getVelocity().applyToPoint(this.center));
        CollisionInfo collisionInfo = this.gameEnvironment.getClosestCollision(trajectory);
        if (collisionInfo == null) {
            this.center = this.getVelocity().applyToPoint(this.center);

        } else {
            Rectangle rectangle = collisionInfo.collisionObject().getCollisionRectangle();
            Point pointInter = collisionInfo.collisionPoint();
            this.setVelocity(collisionInfo.collisionObject().hit(this, pointInter, this.getVelocity()));
            this.center = this.getVelocity().applyToPoint(this.center);
            int value = this.aplly(pointInter, rectangle);
            if (this.center.getX() > rectangle.getLeftLine().start().getX()
                    && this.center.getX() < rectangle.getRightLine().start().getX()
                    && this.center.getY() > rectangle.getUpperLine().start().getY()
                    && this.center.getY() < rectangle.getDownLine().start().getY()
                    && (rectangle.getWidth() > 400 || rectangle.getHeight() > 400)) {
                this.center.setY(50);
                this.center.setX(400);

            }
            if (value == 1) {
                if (this.center.getY() > rectangle.getUpperLine().start().getY()) {
                    if (this.center.getY() < rectangle.getDownLine().start().getY()) {
                        this.center.setY(rectangle.getDownLine().start().getY() + this.r);
                    } else {
                        this.center.setY(yBefore - this.r);

                    }
                }
                return;
            }
            if (value == 2) {
                if (this.center.getY() < rectangle.getDownLine().start().getY()) {
                    if (this.center.getY() > rectangle.getUpperLine().start().getY()) {
                        this.center.setY(rectangle.getUpperLine().start().getY() - this.r);
                    } else {
                        this.center.setY(yBefore + this.r);
                    }
                    return;
                }
            }
            if (value == 3) {
                if (this.center.getX() > rectangle.getRightLine().start().getX()) {
                    this.center.setX(rectangle.getRightLine().start().getX() + this.r);
                }
                return;
            }
            if (value == 4) {
                if (this.center.getX() < rectangle.getLeftLine().start().getX()) {
                    this.center.setX(rectangle.getLeftLine().start().getX() - this.r);
                }
            }
        }
    }

    private int aplly(Point collisionPoint, Rectangle rectangle) {
        if (rectangle.getUpperLine().pointOnLine(collisionPoint)
                && rectangle.getRightLine().pointOnLine(collisionPoint)) {
            return 5;
        }
        if (rectangle.getDownLine().pointOnLine(collisionPoint)
                && rectangle.getRightLine().pointOnLine(collisionPoint)) {
            return 6;
        }
        if (rectangle.getDownLine().pointOnLine(collisionPoint)
                && rectangle.getLeftLine().pointOnLine(collisionPoint)) {
            return 7;
        }
        if (rectangle.getLeftLine().pointOnLine(collisionPoint)
                && rectangle.getUpperLine().pointOnLine(collisionPoint)) {
            return 8;
        }
        if (rectangle.getUpperLine().pointOnLine(collisionPoint)) {
            return 1;
        }
        if (rectangle.getDownLine().pointOnLine(collisionPoint)) {
            return 2;
        }
        if (rectangle.getRightLine().pointOnLine(collisionPoint)) {
            return 3;
        }
        if (rectangle.getLeftLine().pointOnLine(collisionPoint)) {
            return 4;
        }
        return 9;


    }

    /**
     * remove this ball from the game.
     * @param game , class that charge the board game.
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }
}


