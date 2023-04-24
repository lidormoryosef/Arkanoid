package sprites;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import levels.GameLevel;

/**
 * create the paddle, player in the game.
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Block paddle;
    private double width;
    private double height;
    static final double EPSILON = Math.pow(10, -6);
    private int speedPaddle;

    /**
     * create a paddle.
     *
     * @param paddle   , block
     * @param keyboard , left or right.
     * @param speedPaddle , speef of paddle.
     */
    public Paddle(Block paddle, biuoop.KeyboardSensor keyboard, int speedPaddle) {
        this.paddle = paddle;
        this.keyboard = keyboard;
        this.width = paddle.getCollisionRectangle().getWidth();
        this.height = paddle.getCollisionRectangle().getHeight();
        this.speedPaddle = speedPaddle;
    }

    /**
     * move the paddle one move left.
     */
    public void moveLeft() {
        double xPoint = this.paddle.getCollisionRectangle().getUpperLeft().getX();
        double yPoint = this.paddle.getCollisionRectangle().getUpperLeft().getY();

        if (xPoint - this.speedPaddle >= 25) {
            Point point = new Point(xPoint - 10, yPoint);
            this.paddle.getCollisionRectangle().setUpperLeft(point);
            return;
        }
        if (xPoint - this.speedPaddle < 25) {
            Point point = new Point(25, yPoint);
            this.paddle.getCollisionRectangle().setUpperLeft(point);
        }

    }

    /**
     * move the paddle one move right.
     */
    public void moveRight() {
        double xPoint = this.paddle.getCollisionRectangle().getUpperLeft().getX();
        double yPoint = this.paddle.getCollisionRectangle().getUpperLeft().getY();
        if (xPoint + this.speedPaddle + this.width <= 775) {
            Point point = new Point(xPoint + 10, yPoint);
            this.paddle.getCollisionRectangle().setUpperLeft(point);
            return;
        }
        if (xPoint + this.speedPaddle + this.width > 775) {
            Point point = new Point(775 - width, yPoint);
            this.paddle.getCollisionRectangle().setUpperLeft(point);
        }

    }

    /**
     * Checks what is pressed on the keyboard.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }


    }

    /**
     * draw the paddle.
     *
     * @param d , DrawSurface.
     */
    public void drawOn(DrawSurface d) {
        this.paddle.drawOn(d);

    }

    // sprites.Collidable

    /**
     * return the collision rectangle.
     *
     * @return rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return this.paddle.getCollisionRectangle();
    }

    /**
     * updatethe velocity.
     *
     * @param collisionPoint  , The point of collision.
     * @param currentVelocity , the velocity that we want to upload.
     * @param hitter          , ball.
     * @return velocity.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double part1, part2, part3, part4, part5, part6, yUp, yDown, pointX, pointY, speed, xRight, xLeft;
        speed = Math.sqrt(Math.pow(currentVelocity.getDy(), 2) + Math.pow(currentVelocity.getDx(), 2));
        yUp = this.paddle.getCollisionRectangle().getUpperLeft().getY();
        yDown = this.paddle.getCollisionRectangle().getUpperLeft().getY() + this.height;
        xLeft = this.paddle.getCollisionRectangle().getUpperLeft().getX();
        xRight = this.paddle.getCollisionRectangle().getUpperLeft().getX() + this.width;
        part1 = this.paddle.getCollisionRectangle().getUpperLeft().getX();
        part2 = part1 + (this.width / 5);
        part3 = part2 + (this.width / 5);
        part4 = part3 + (this.width / 5);
        part5 = part4 + (this.width / 5);
        part6 = part5 + (this.width / 5);
        pointX = collisionPoint.getX();
        pointY = collisionPoint.getY();
        if (part1 <= pointX && pointX < part2 && Math.abs(pointY - yUp) < EPSILON) {
            return Velocity.fromAngleAndSpeed(300, speed);
        }
        if (part2 <= pointX && pointX < part3 && Math.abs(pointY - yUp) < EPSILON) {
            return Velocity.fromAngleAndSpeed(330, speed);
        }
        if (part3 <= pointX && pointX < part4 && Math.abs(pointY - yUp) < EPSILON) {
            currentVelocity.setDy(-currentVelocity.getDy());
            return currentVelocity;
        }
        if (part4 <= pointX && pointX < part5 && Math.abs(pointY - yUp) < EPSILON) {
            return Velocity.fromAngleAndSpeed(30, speed);
        }
        if (part5 <= pointX && pointX < part6 && Math.abs(pointY - yUp) < EPSILON) {
            return Velocity.fromAngleAndSpeed(60, speed);
        }
        if (this.paddle.getCollisionRectangle().getRightLine().pointOnLine(collisionPoint)) {
            currentVelocity.setDx(-currentVelocity.getDx());
            return currentVelocity;
        }
        if (this.paddle.getCollisionRectangle().getLeftLine().pointOnLine(collisionPoint)) {
            currentVelocity.setDx(-currentVelocity.getDx());
            return currentVelocity;
        }
        if (pointX >= xLeft && pointX <= xRight && pointY >= yUp && pointY <= yDown) {
            currentVelocity.setDy(-currentVelocity.getDy());
            return currentVelocity;
        }
        return currentVelocity;
    }

    /**
     * Add this paddle to the game.
     *
     * @param g , game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}